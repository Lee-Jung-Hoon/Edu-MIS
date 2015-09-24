package kr.co.edumis.user.videoLecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.user.videoLecture.dao.LecCommentDAO;
import kr.co.edumis.user.videoLecture.service.LecCommentService;
import kr.co.edumis.user.videoLecture.service.LecCommentServiceImpl;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;

@WebServlet("/user/LecCommentController")
public class LecCommentController extends HttpServlet {
	private LecCommentService service = null;

	public LecCommentController() {
		service = new LecCommentServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");

		int no = Integer.parseInt(req.getParameter("no"));
		String id = req.getParameter("id");
		String comments = req.getParameter("comments");

		LecCommentVO lecComment = new LecCommentVO();
		lecComment.setComments(comments);
		lecComment.setId(id);
		lecComment.setNo(no);

		// System.out.println(comments);
		System.out.println(lecComment);
		LecCommentDAO dao = new LecCommentDAO();
		try {
			service.lecCommentRegist(lecComment);
			List<LecCommentVO> list = service.lecCommentList(no);
			PrintWriter out = res.getWriter();
			String str = "";
			str += "[";
			for (LecCommentVO lec : list) {
				str += "{";
				str += " 'id' : '" + lec.getId() + "' ,";
				str += " 'comments' : '" + lec.getComments() + "'";
				str += "},";
			}
			str += "]";
			out.println(str);
			out.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
}
