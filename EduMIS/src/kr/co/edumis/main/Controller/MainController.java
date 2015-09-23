package kr.co.edumis.main.Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.service.MainService;
import kr.co.edumis.main.service.MainServiceImpl;
import kr.co.edumis.main.vo.MainAdminAttVO;

@WebServlet("/edumis/main.do")
public class MainController extends HttpServlet{
	
	private static MainService service;
	
	public MainController() {
		service = new MainServiceImpl();
	}
	
	protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
		// main페이지 일일 출석 결과 불러오기
		MainAdminAttVO attend = service.selectDailyAttend();
		req.setAttribute("attend", attend);
		
		// main페이지 일일 관리자 일정 결과 불러오기
		ScheduleVO schedule = service.selectDailySchedule();
		
		
		// main페이지 일일 자리 배치도 불러오기
			
		
			
		RequestDispatcher rd = req.getRequestDispatcher("#");
		rd.forward(req, res);
			
		}catch(Exception e) { 
			throw new ServletException(e);
		}
	}
}

