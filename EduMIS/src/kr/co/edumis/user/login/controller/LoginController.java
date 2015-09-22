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
		
		LoginVO login = new LoginVO();
		login.setId(req.getParameter("id"));
		login.setPass(req.getParameter("pass"));
		
		try {
			LoginVO member = service.login(login);
			HttpSession session = req.getSession();
			
			Cookie cookie = new Cookie("loginId", id);
			cookie.setPath("/");

			if(req.getParameter("saveId") != null) {
				cookie.setMaxAge(60 * 60); 
			} else {
				cookie.setMaxAge(0);  
			}
			res.addCookie(cookie);
			ModelAndView mav = new ModelAndView();
			if (member != null) { 
				session.setAttribute("userInfo", member);
				mav.setView("redirect:" + req.getContextPath());
			} else {
				mav.setView("redirect:/EduMIS/jsp/user/login/loginForm.jsp");
			}
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
