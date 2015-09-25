package kr.co.edumis.admin.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.schedule.service.ScheduleServiceImpl;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
@WebServlet ("/admin/detailschedule.do")
public class DetailScheduleController extends HttpServlet {
	private ScheduleServiceImpl service;
	public DetailScheduleController() {
		service = new ScheduleServiceImpl(); 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");
		try {
			ScheduleVO schedule = new ScheduleVO(); 
			String no = req.getParameter("no");
//		System.out.println(no);
			schedule.setNo(Integer.parseInt(no));
			ScheduleVO vo = service.detailSchedule(schedule);

//			System.out.println(vo.getNo());
			
			PrintWriter out = res.getWriter();
			String json = "";
			json += "	{";
			json += "		'no': "+"'"+					vo.getNo()						+"'"+", ";
			json += "		'importance': "+"'"+ 	vo.getImportance()		+"'"+", ";
			json += "		'title': "+"'"+ 				vo.getTitle()						+"'"+", ";
			json += "		'content': "+"'"+ 		vo.getContent()				+"'"+", ";
			json += " 		'place' :"+"'"+				vo.getPlace()					+"'"+",";
			json += "		'startDate' :"+"'"+		vo.getStartDate()			+"'"+",";  
			json += "		'endDate' :"+"'"+		vo.getEndDate()				+"'"+","; 
			json += "		'importance' :"+"'"+	vo.getImportance()		+"'"+",";
			json += "		'latitude' :"+"'"+			vo.getLatitude()				+"'"+",";
			json += "		'longitude' :"+"'"+		vo.getLongitude()			+"'";			
			json += "	}";

			out.println(json);
			out.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}