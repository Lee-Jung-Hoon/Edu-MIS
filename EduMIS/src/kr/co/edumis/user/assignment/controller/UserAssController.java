package kr.co.edumis.user.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class UserAssController {
	
	@RequestMapping("/user/assList.do")
	public ModelAndView userAssList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
	}
	
	@RequestMapping("/user/assregist.do")
	public ModelAndView userAssRegist(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
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
