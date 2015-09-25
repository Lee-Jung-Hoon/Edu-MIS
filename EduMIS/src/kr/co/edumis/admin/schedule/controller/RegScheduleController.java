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
@WebServlet ("/admin/regschedule")
public class RegScheduleController extends HttpServlet {
	private ScheduleServiceImpl service;
	public RegScheduleController() {
		service = new ScheduleServiceImpl(); 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");
		try {
			ScheduleVO schedule = new ScheduleVO(); 
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			int importance = Integer.parseInt(req.getParameter("importance"));
			String latitude = req.getParameter("latitude");
			String longitude = req.getParameter("longitude");
			String place = req.getParameter("place");
			
			schedule.setTitle(title);
			schedule.setContent(content);
			schedule.setStartDate(startDate);
			schedule.setEndDate(endDate);
			schedule.setLatitude(latitude);
			schedule.setImportance(importance);
			schedule.setLongitude(longitude);
			schedule.setPlace(place);
			service.registSchedule(schedule);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}