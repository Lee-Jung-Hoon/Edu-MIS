package kr.co.edumis.framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 사용자의 모든 요청을 받아서 처리할 Fromt controller 역할
 */
public class DispatcherServlet extends HttpServlet {
	private HandlerMapping mappings;
	
	public void init(ServletConfig config) throws ServletException {
		String packageName = config.getInitParameter("scan-package");
		try {
			mappings = new HandlerMapping(packageName);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// 해야할 일
		// 1. 사용자의 URL을 추출해야함...
		String uri = req.getRequestURI();

		// 사용자의 요청 정보중에서 의미없는 부분인 프로젝트 경로(웹어플리케이션 경로)를 제거한다.
		String contextPath = req.getContextPath();

		// 전체 경로에서 웹 어플리케이션 경로로 제거하기
		uri = uri.substring(contextPath.length());

		// 2. 추출한 경로와 연관된 일을 처리할 클래스 호출하고 결과 받기
		// - 컨트롤러에서 작업 처리 후 반환하는 경로를
		// forward 대상인지 redirect 대상인지 판단하기 위해서
		// redirect 인 경우는 경로의 시작을 "redirect:"으로 시작한다.
		//
		// HandlerMapping mappings = new HandlerMapping();

		// 매핑정보를 가지는 클래스를 활용해서 컨트롤러를 얻어온다.
		CtrlAndMethod control = mappings.getCtrlAndMethod(uri);

		if (control == null) {
			throw new ServletException("요청하신 URL이 올바르지 않습니다.");
		}

		// uri : http://localhost:8000/MVCMyBatis/a.do
		// 만약, 사용자가 요청한 uri 주소에 대한 처리 구문이 없다면
		// control 객체는 생성되지 못했기 때문에 null을 가지고 있음

		// ModelAndView 객체를 얻어온다.
		// 1. 넘어갈 페이지의 정보를 얻는다. : mav.getView();
		// 2. JSP에서 사용할 데이터를 공유 영역에 설정하기
		// - 컨트롤러에서 설정한 데이터를 담고 있는 model(맵) 객체 얻기
		// - mav.getModel();

		Object target = control.getTarget();
		Method method = control.getMethod();
		String view = "";
		try {
			// 변경된 부분
			// 파라미터 자동 설정 부분 추가함....
			//===================================================
			PreProcessor pre = new PreProcessor();
			Object[] params = pre.process(method, req, res);
			//===================================================
			
			String retName = method.getReturnType().getSimpleName();
			if ("ModelAndView".equalsIgnoreCase(retName)) {
				ModelAndView mav = (ModelAndView)method.invoke(target, params);

				// JSP에서 사용할 수 있도록 model안의 데이터들을 공유영역에 설정
				Map<String, Object> model = mav.getModel();
				
				// 맵의 키값들을 모두 얻은 다음 반복 수행하면서 값을 꺼낸다.
				Set<String> keys = model.keySet();
				for (String key : keys) {
					// req.setAttribute(key, value);
					req.setAttribute(key, model.get(key));
				}

				view = mav.getView();
			} else if ("String".equalsIgnoreCase(retName)) {
				view = (String)method.invoke(target, params);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// sendRedirect로 이동할 페이지임
		if (view.startsWith("redirect:")) {
			res.sendRedirect(view.substring("redirect:".length()));
		}

		// forward로 이동할 페이지임
		else {
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, res);
		}
	}
}
