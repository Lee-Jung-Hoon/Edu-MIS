package kr.co.edumis.admin.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.comment.service.CommentService;
import kr.co.edumis.admin.comment.service.CommentServiceImpl;

@WebServlet("/comment/delete.do")
public class DeleteCommnet extends HttpServlet{
	CommentService service = null;
	
	public DeleteCommnet(){
		service = new CommentServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		try {
			service.deleteComment(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
