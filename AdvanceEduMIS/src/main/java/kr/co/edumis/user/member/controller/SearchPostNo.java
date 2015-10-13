package kr.co.edumis.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.user.member.service.PostNoService;
import kr.co.edumis.user.member.service.PostNoServiceImpl;

@WebServlet("/postno/search")
public class SearchPostNo extends HttpServlet {
	private PostNoService service;

	public SearchPostNo() {
		service = new PostNoServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");

		String zipcode = req.getParameter("zipcode");
		
		PrintWriter out = res.getWriter();
		try {
			String addr = service.getAddr(zipcode);
			out.println(addr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
