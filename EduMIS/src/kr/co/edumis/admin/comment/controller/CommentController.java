package kr.co.edumis.admin.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.comment.service.CommentService;
import kr.co.edumis.admin.comment.service.CommentServiceImpl;
import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

public class CommentController {

	private CommentService service;

	public CommentController() {
		service = new CommentServiceImpl();
	}

	@RequestMapping("/admin/commentList.do")
	public ModelAndView CommentList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		try {
			ModelAndView mav = new ModelAndView("/jsp/admin/comment/commentList.jsp");
			List<CommentVO> list = service.getList();
			mav.addObject("list", list);
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
