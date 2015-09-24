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

@WebServlet("/memo/updateMemo.do")
public class UpdateMemo extends HttpServlet{
	MemoService service;
	
	
	public UpdateMemo() {
		service = new MemoServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String content = req.getParameter("content");
			String posX = req.getParameter("posX");
			String posY = req.getParameter("posY");
			String id = req.getParameter("id");
			MemoVO memo = new MemoVO();
			memo.setContent(content);
			memo.setPosX(Integer.parseInt(posX));
			memo.setPosY(Integer.parseInt(posY));
			memo.setMemoNo(Integer.parseInt(id));
			
			service.updateMemo(memo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
