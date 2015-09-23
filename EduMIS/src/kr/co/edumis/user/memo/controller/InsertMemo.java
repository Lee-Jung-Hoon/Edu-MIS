package kr.co.edumis.user.memo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.user.member.vo.MemberVO;
import kr.co.edumis.user.memo.service.MemoService;
import kr.co.edumis.user.memo.service.MemoServiceImpl;
import kr.co.edumis.user.memo.vo.MemoVO;

@WebServlet("/memo/insertMemo.do")
public class InsertMemo extends HttpServlet{
	MemoService service;
	
	
	public InsertMemo() {
		service = new MemoServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("userInfo");
			
			String content = req.getParameter("content");
			String posX = req.getParameter("posX");
			String posY = req.getParameter("posY");
			
			MemoVO memo = new MemoVO();
			memo.setContent(content);
			memo.setPosX(Integer.parseInt(posX));
			memo.setPosY(Integer.parseInt(posY));
			if(member == null){
				memo.setUserNo(0);
			}else{
				memo.setUserNo(Integer.parseInt(member.getNo()));
			}
			
			
			System.out.println("저장\n" + memo);
			service.insertMemo(memo);
			
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		
		
	}
}
