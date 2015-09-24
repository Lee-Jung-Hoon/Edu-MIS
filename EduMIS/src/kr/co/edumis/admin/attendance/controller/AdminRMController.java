package kr.co.edumis.admin.attendance.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class AdminRMController {
	private AdminAttService service;
	
	public AdminRMController() {
		service = new AdminAttServiceImpl();
	}
	
	@RequestMapping("/examgrade/ExamTurnWrite.do")
	public ModelAndView AttRegist(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/attendance/attendance.jsp");
		
		try{
			// insert시키는 부분
		} catch(Exception e){
			e.printStackTrace();
		}
		return mav;
		
	}
	
	public ModelAndView AttUpdate(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/attendance/attendance.jsp");
		
		try{
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return mav;
		
	}
	
	

}
