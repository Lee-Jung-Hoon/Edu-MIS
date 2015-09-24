package kr.co.edumis.user.login.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.login.service.LoginService;
import kr.co.edumis.user.login.service.LoginServiceImpl;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
public class LoginController {
	private LoginService service;

	public LoginController() {
		service = new LoginServiceImpl();
	}

	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		System.out.println("111111111111");
		LoginVO login = new LoginVO();
		login.setId(req.getParameter("id"));
		login.setPass(req.getParameter("pass"));
		
		try {
			LoginVO member = service.login(login);
			String grade = member.getGrade();
			HttpSession session = req.getSession();
			
			ModelAndView mav = new ModelAndView();
			if (member != null && grade == null) { 
				session.setAttribute("user", member);
				mav.setView("redirect:/EduMIS/jsp/user/login/loginMain.jsp");
				System.out.println(id);
			} else if (grade =="s"){
				session.setAttribute("admin", member);
				mav.setView("redirect:/EduMIS/jsp/user/login/loginMain.jsp");			
				
			} else {
				mav.setView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
			
			}
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/login/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
		return mav;
	}
	
	@RequestMapping("/login/logOut.do")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("11111");
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
