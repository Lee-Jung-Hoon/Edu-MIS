package kr.co.edumis.main.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.service.MainService;
import kr.co.edumis.main.service.MainServiceImpl;

@WebServlet("/edumis/main.do")
public class MainController extends HttpServlet{
	
	private static MainService service;
	
	public MainController() {
		service = new MainServiceImpl();
	}
	
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		// main페이지 일일 출석 결과 불러오기
//		AdminAttVO attend = service.selectDailyAttend();
		// main페이지 일일 관리자 일정 결과 불러오기
//		ScheduleVO schedule = service.selectDailySchedule();
		// main페이지 일일 자리 배치도 불러오기
		
		
		
		
		
		
	}
}
