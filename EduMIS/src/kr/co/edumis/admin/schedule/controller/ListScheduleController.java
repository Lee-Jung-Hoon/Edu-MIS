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

@WebServlet ("/admin/listschedule")
public class ListScheduleController extends HttpServlet {
	private ScheduleServiceImpl service;
	public ListScheduleController() {
		service = new ScheduleServiceImpl(); 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");
//		ScheduleVO schedule = (ScheduleVO) WebUtil.getFromParamToVO("kr.co.edumis.admin.schedule.vo.ScheduleVO",req);
		try {
			ScheduleVO schedule = new ScheduleVO(); 
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String oneday = req.getParameter("oneday");
			
//			System.out.println(month.length());
			
			if(month.length() == 1) {
				month = "0"+month;
			}
			if(oneday.length() == 1) {
				oneday ="0"+oneday;
			}
			schedule.setStartDate(month+"/"+oneday+"/"+year);
			schedule.setEndDate(month+"/"+oneday+"/"+year);
			List<ScheduleVO> list = service.listSchedule(schedule);

			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i).getTitle());
			}
			
			PrintWriter out = res.getWriter();
			String json = "";
			int cnt = 0;
			for(int i =0; i<list.size();i++) {
			cnt ++;
			json += "[";
			json += "	{";
			json += "		'importance': "+"'"+ list.get(i).getImportance()+"'"+", ";
			json += "		'title': "+"'"+ list.get(i).getTitle()+"'"+", ";
			json += "		'content': "+"'"+ list.get(i).getContent()+"'"+", ";
			json += "	}";
			if(cnt==list.size()) {
				json += "]";
			}	else {
				json += "	},";
			}
			}
//			System.out.println(schedule.getTitle());
//			json=schedule.getTitle();
			out.println(json);
			out.close();
//			ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examlist.jsp");
//			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
	