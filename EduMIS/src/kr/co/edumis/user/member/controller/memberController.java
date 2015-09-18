package kr.co.edumis.user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class memberController {
	@RequestMapping("/member.do")
	public void ModelAndView (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		MemberVO join = new MemberVO();
		join.setId(req.getParameter("id"));
		join.setName(req.getParameter("name"));
		join.setPass(req.getParameter("pass"));
		join.setBirth(req.getParameter("birth"));
		join.setEmail(req.getParameter("email"));
		join.setZaddr(req.getParameter("zaddr"));
		join.setZcode(req.getParameter("zcode"));

		System.out.println(1111);
		
		MemberDAO dao = new MemberDAO();
		try{
			 dao.memberJoin(join);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return;
	}
}