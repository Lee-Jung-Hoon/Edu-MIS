package kr.co.edumis.user.login.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.edumis.user.login.service.LoginService;
import kr.co.edumis.user.login.service.LoginServiceImpl;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
public class LoginController {
	private LoginService service;

	public LoginController() {
		service = new LoginServiceImpl();
	}

	@RequestMapping("/user/login/login.do")
	public String login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);

		LoginVO login = new LoginVO();

		login.setId(req.getParameter("id"));
		login.setPass(req.getParameter("pass"));		
		
		try {
			LoginVO member = service.login(login);

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
				System.out.println("member is not null");	
				login.setName(member.getName());
				login.setGrade(member.getGrade());
				
				grade = member.getGrade();				
			}
			else{
				grade = "3";
			}
			
			System.out.println("grade : " + grade);
			
			switch(grade) { 
			case "1":
				session.setAttribute("admin", member);
				return "redirect:/EduMIS/admin/main.do";	
			case "2":
				session.setAttribute("user", member);
				return "redirect:/EduMIS/user/main.do";
			default:
				return "redirect:/EduMIS/jsp/user/member/joinForm.jsp";
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/user/login/loginForm.do")
	public String loginForm( ) {
		return "redirect:/EduMIS/jsp/user/login/loginForm.jsp";
	}
	
	@RequestMapping("/user/login/logout.do")
	public String userLogout(HttpServletRequest req) throws Exception {
		req.getSession().invalidate();
		return "redirect:/EduMIS/jsp/user/main.jsp";
	}
	
	@RequestMapping("/admin/login/logout.do")
	public String adminLogout(HttpServletRequest req) throws Exception {
		req.getSession().invalidate();
		return "redirect:/EduMIS/admin/main.do";
	}
}
