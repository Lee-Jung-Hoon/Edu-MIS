package kr.co.edumis.user.videoLecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.user.videoLecture.service.LecCommentService;
import kr.co.edumis.user.videoLecture.service.LecCommentServiceImpl;

@WebServlet("/user/LecCommentDelete")
public class LecCommentDelete extends HttpServlet {
	private LecCommentService service = null;

	public LecCommentDelete() {
		service = new LecCommentServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");

		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("번호 : " + no);
		try {
			service.lecCommentDelete(no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
