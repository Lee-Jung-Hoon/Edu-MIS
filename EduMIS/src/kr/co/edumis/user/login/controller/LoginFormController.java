package kr.co.edumis.user.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.login.service.LoginService;
import kr.co.edumis.user.login.service.LoginServiceImpl;

@Controller
public class LoginFormController{
	private LoginService service;

	public LoginFormController() {
		service = new LoginServiceImpl();
	}
	
	@RequestMapping("/login/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
//		res.sendRedirect("/MVCMyBatis/jsp/login/loginForm.jsp");
		ModelAndView mav = new ModelAndView("redirect:/MVCMyBatis/jsp/login/loginForm.jsp");
		return mav;
	}
}