package kr.co.edumis.user.assignment.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.assignment.service.UserAssService;
import kr.co.edumis.user.assignment.service.UserAssServiceImpl;
import kr.co.edumis.user.assignment.vo.UserAssVO;

@Controller
public class UserAssController {
	
	private UserAssService service;
	
	public UserAssController(){
		service = new UserAssServiceImpl();
	}
	
	@RequestMapping("/user/assList.do")
	public ModelAndView userAssList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssList.jsp");
		
		try {
			List<AdminAssVO> list = service.getList();
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/user/assRegist.do")
	public ModelAndView userAssRegist(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("no"));

		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssRegist.jsp");
		
		//해야할 과제 정보 보여주기
		try {
			AdminAssVO admass = service.detail(no);
			mav.addObject("ass", admass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//과제 올리기
//		String content = req.getParameter("usertext");
//		String orgFileName = req.getParameter("userattachFile");
//		
//		UserAssVO userass = new UserAssVO();
//		userass.setContent(content);
//		userass.setOrgFileName(orgFileName);	
		return mav;
		
	}
	
	
	@RequestMapping("/user/assDetailComplete.do")
	public ModelAndView userAssDetailComplete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
	}
	@RequestMapping("/user/assBfModify.do")
	public ModelAndView userAssBfModify(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		return null;
		
	}
	@RequestMapping("/user/assModify.do")
	public ModelAndView userAssModify(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
	}
	
	
	
	
}
