package kr.co.edumis.user.member.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class MemberController {
	@RequestMapping("/user/member/join.do")
	public ModelAndView write(MemberVO member, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		System.out.println("2222222222");
		
//		MemberDAO dao = new MemberDAO();
//		try{
//			 dao.memberJoin(member);
//			 System.out.println("111111111111");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}
	
	@RequestMapping("/user/member/joinForm.do")
	public String joinForm() throws ServletException, IOException {
		return "/jsp/user/member/joinForm.jsp";
	}
}