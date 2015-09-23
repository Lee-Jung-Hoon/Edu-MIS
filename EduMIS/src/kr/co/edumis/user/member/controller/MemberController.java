package kr.co.edumis.user.member.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.service.MemberService;
import kr.co.edumis.user.member.service.MemberServiceImpl;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class MemberController {
	private MemberService service;
	
	public MemberController(){
		service = new MemberServiceImpl();
	}
	
	@RequestMapping("/user/member/join.do")
	public ModelAndView join(MemberVO member, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("/jsp/user/member/main.jsp");
		
		try {
			service.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/user/member/joinForm.do")
	public String joinForm() throws ServletException, IOException {
		return "/jsp/user/member/joinForm.jsp";
	}
}