package kr.co.edumis.user.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.login.service.LoginService;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping("/login.do")
	public String login(@RequestParam("id") String id, LoginVO login, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		LoginVO member = service.login(login);

		String grade = "";
		HttpSession session = req.getSession();

		Cookie cookie = new Cookie("loginId", id);
		cookie.setPath("/");

		if (req.getParameter("save") != null) {
			cookie.setMaxAge(60 * 60);
		} else {
			cookie.setMaxAge(0);
		}
		res.addCookie(cookie);

		if (member != null) {
			System.out.println("member is not null");
			login.setName(member.getName());
			login.setGrade(member.getGrade());

			grade = member.getGrade();
		} else {
			grade = "3";
		}

		System.out.println("grade : " + grade);

		switch (grade) {
		case "1":
			session.setAttribute("admin", member);
			return "redirect:/admin/main.do";
		case "2":
			session.setAttribute("user", member);
			return "redirect:/user/main.do";
		default:
			return "redirect:/user/member/joinForm";
		}
	}

	@RequestMapping("/logout.do")
	public String userLogout(HttpServletRequest req) throws Exception {
		req.getSession().invalidate();
		return "redirect:/user/main";
	}

	@RequestMapping("/admin/login/logout.do")
	public String adminLogout(HttpServletRequest req) throws Exception {
		req.getSession().invalidate();
		return "redirect:/admin/main.do";
	}
}
