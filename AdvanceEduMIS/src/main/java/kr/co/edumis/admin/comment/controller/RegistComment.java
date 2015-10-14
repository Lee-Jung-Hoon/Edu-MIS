package kr.co.edumis.admin.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.comment.service.CommentService;
import kr.co.edumis.admin.comment.service.CommentServiceImpl;
import kr.co.edumis.admin.comment.vo.CommentVO;

@WebServlet("/comment/RegistComment.do")
public class RegistComment extends HttpServlet{
	
	private CommentService service = null;
	
	public RegistComment() {
		service = new CommentServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommentVO vo = new CommentVO();
		vo.setId(req.getParameter("id"));
		vo.setContent(req.getParameter("content"));
		
		try {
			service.commentInsert(vo);
			vo = service.selectOneComment();
			
			String json= "";
//			json += "[";
			json += "  {";
			json += "    'regDate':'" + vo.getReg_date() + "',";
			json += "    'content':'" + vo.getContent() + "',";
			json += "    'no':'" + vo.getNo() + "'";
			json += "   }";
//			json += "]";
			
			res.setContentType("text/html; charSet=UTF-8");
			
			PrintWriter out = res.getWriter();
			
			out.println(json);
			out.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
