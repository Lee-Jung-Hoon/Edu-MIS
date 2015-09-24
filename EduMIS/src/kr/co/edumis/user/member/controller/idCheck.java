package kr.co.edumis.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.user.member.dao.IdCheckDAO;

@WebServlet("/member/idCheck.do")
public class idCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		String id = req.getParameter("id");
		IdCheckDAO dao = new IdCheckDAO();

		try {
			int cnt = dao.selectId(id);
			if (cnt == 1) {
				out.println("이미 사용중인 아이디 입니다.");
			} else {
				out.println("사용 가능한 아이디 입니다.");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		return;
	}
}