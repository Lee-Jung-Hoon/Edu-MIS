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
@WebServlet ("/admin/delschedule")
public class DelScheduleController extends HttpServlet {
	private ScheduleServiceImpl service;
	public DelScheduleController() {
		service = new ScheduleServiceImpl(); 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");
		try {
			ScheduleVO schedule = new ScheduleVO();
			int no = Integer.parseInt(req.getParameter("m_no"));
//			String title = req.getParameter("m_title");
//			String content = req.getParameter("m_content");
//			String startDate = req.getParameter("m_startDate");
//			String endDate = req.getParameter("m_endDate");
//			int importance = Integer.parseInt(req.getParameter("m_importance"));
//			String latitude = req.getParameter("m_latitude");
//			String longitude = req.getParameter("m_longitude");
//			String place = req.getParameter("m_place");
			
			
			schedule.setNo(no);
//			schedule.setTitle(title);
//			schedule.setContent(content);
//			schedule.setStartDate(startDate);
//			schedule.setEndDate(endDate);
//			schedule.setLatitude(latitude);
//			schedule.setImportance(importance);
//			schedule.setLongitude(longitude);
//			schedule.setPlace(place);
			service.delSchedule(schedule);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}