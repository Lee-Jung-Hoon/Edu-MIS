package kr.co.edumis.admin.schedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.schedule.service.ScheduleServiceImpl;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.framework.WebUtil;

@Controller
public class ScheduleController {
	private ScheduleServiceImpl service;
	public ScheduleController() {
		service = new ScheduleServiceImpl(); 
	}
	
	//스케줄을 등록하는 mav
	@RequestMapping("/regschedule.do")
	public ModelAndView write (HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ScheduleVO schedule = (ScheduleVO) WebUtil.getFromParamToVO("kr.co.edumis.admin.schedule.vo.ScheduleVO",req);
		try {
			service.registSchedule(schedule);
			return new ModelAndView("redirect:/EduMIS/jsp/admin/schedule/schedule.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	
}


