package kr.co.edumis.user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minipro.framework.Controller;
import minipro.framework.ModelAndView;
import minipro.framework.RequestMapping;
import minipro.memberDAO.MemberDAO;
import minipro.memberVO.MemberVO;

@Controller
public class memberController {
	@RequestMapping("/member.do")
	public void ModelAndView (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		MemberVO join = new MemberVO();
		join.setmId(req.getParameter("mId"));
		join.setmName(req.getParameter("mName"));
		join.setmPw(req.getParameter("mPw"));
		join.setmBirth(req.getParameter("mBirth"));
		join.setmEmail(req.getParameter("mEmail"));
		join.setmZaddr(req.getParameter("mZaddr"));
		join.setmZcode(req.getParameter("mZcode"));

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