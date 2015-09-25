package kr.co.edumis.user.videoLecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		int comno = Integer.parseInt(req.getParameter("comno").trim());
		System.out.println("dele 번호 : " + comno);
		try {
			
			service.lecCommentDelete(comno);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
