package kr.co.edumis.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.edumis.user.member.service.PostNoService;

@WebServlet("/postno/search")
public class SearchPostNo extends HttpServlet {

	@Autowired
	private PostNoService service;

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
			e.printStackTrace();
		}
		out.close();
	}

}
