package kr.co.edumis.admin.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import kr.co.edumis.admin.assignment.service.AdminAssService;
import kr.co.edumis.admin.assignment.service.AdminAssServiceImpl;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class AdminAssController {
	private AdminAssService service;
	
	public AdminAssController(){
		service = new AdminAssServiceImpl();
	}
	
	@RequestMapping("/admin/assDetail.do")
	public ModelAndView adAssDetail(String no) 
			throws ServletException, IOException {

		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/addAssDetail.jsp");
		return mav;
	}
	
	@RequestMapping("/admin/assRegist.do")
	public String adAssRegist(AdminAssVO adminassVO) throws Exception {
		return "redirect:/jsp/admin/assignment/adAssRegist.jsp";
	}
	
	@RequestMapping("/admin/assList.do")
	public ModelAndView adAssList(AdminAssVO adminassVO) throws Exception {
		
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/addAssList.jsp");
		return mav;
	}

}
