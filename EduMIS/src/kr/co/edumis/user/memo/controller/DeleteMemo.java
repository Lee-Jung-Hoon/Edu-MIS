package kr.co.edumis.user.memo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.user.memo.service.MemoService;
import kr.co.edumis.user.memo.service.MemoServiceImpl;

@WebServlet("/memo/deleteMemo.do")
public class DeleteMemo extends HttpServlet{
MemoService service;
	
	
	public DeleteMemo() {
		service = new MemoServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			service.deleteMemo(id);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
