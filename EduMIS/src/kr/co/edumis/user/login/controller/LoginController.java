package kr.co.edumis.user.login.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.login.service.LoginService;
import kr.co.edumis.user.login.service.LoginServiceImpl;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
public class LoginController {
	private LoginService service;

	public LoginController() {
		service = new LoginServiceImpl();
	}

	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);

		LoginVO login = new LoginVO();

		login.setId(req.getParameter("id"));
		login.setPass(req.getParameter("pass"));		
		
		try {
			LoginVO member = service.login(login);
			ModelAndView mav = new ModelAndView();
			
			String grade = "";
			HttpSession session = req.getSession();
			
			Cookie cookie = new Cookie("loginId", id);
			cookie.setPath("/");

			if(req.getParameter("save") != null) {
				cookie.setMaxAge(60 * 60); 
			} else {
				cookie.setMaxAge(0);  
			}
			res.addCookie(cookie);
		
			if(member != null){

				login.setName(member.getName());
				login.setGrade(member.getGrade());
				
				grade = member.getGrade();				
			}
			else{
				grade = "3";
			}

			switch(grade) { 
			case "1":
				session.setAttribute("admin", member);
				mav.setView("redirect:/EduMIS/jsp/user/login/admin.jsp");	
				break;
			case "2":
				session.setAttribute("user", member);
				mav.setView("redirect:/EduMIS/jsp/user/main.jsp");
				break;
			default:
				mav.setView("redirect:/EduMIS/jsp/user/member/joinForm.jsp");
				break;
				
			}
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/login/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
		return mav;
	}
	
	@RequestMapping("/login/logOut.do")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			session.invalidate();
			
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
