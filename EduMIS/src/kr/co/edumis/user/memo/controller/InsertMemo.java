package kr.co.edumis.user.memo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String content = req.getParameter("content");
			String posX = req.getParameter("posX");
			String posY = req.getParameter("posY");
			
			MemoVO memo = new MemoVO();
			memo.setContent(content);
			memo.setPosX(Integer.parseInt(posX));
			memo.setPosY(Integer.parseInt(posY));
			
			System.out.println("저장\n" + memo);
			service.insertMemo(memo);
			
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		
		
	}
}
