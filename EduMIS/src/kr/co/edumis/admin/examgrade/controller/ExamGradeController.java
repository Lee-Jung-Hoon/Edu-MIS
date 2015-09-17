package kr.co.edumis.admin.examgrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.examgrade.service.ExamGradeService;
import kr.co.edumis.admin.examgrade.service.ExamGradeServiceImpl;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class ExamGradeController {
	private ExamGradeService service;

	public ExamGradeController() {
		service = new ExamGradeServiceImpl();
	}

	@RequestMapping("/examgrade/wirteForm.do")
	public ModelAndView writeForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/examgrade/examwrite.jsp");
		try {
			List<ExamGradeVO> list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/board/write.do")
	public ModelAndView write(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

//		ExamGradeVO board = new ExamGradeVO();
//		board.setTitle(title);
//		board.setWriter(writer);
//		board.setContent(content);

		try {
//			service.registBoard(board);
			ModelAndView mav = new ModelAndView("redirect:/MVCMyBatis/board/list.do?call=W");
			return mav;

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@RequestMapping("/board/list.do")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 등록에서 호출 된 경우 "call=W" 파라미터가 넘어온다.
		String call = req.getParameter("call");

		// BoardDAO
		try {
			ModelAndView mav = new ModelAndView("/jsp/board/list.jsp");

//			List<BoardVO> list = service.getList();
//			// BoardDAO dao = new BoardDAO();
			// ArrayList<BoardVO> list = dao.selectBoard();

			// 화면에서 사용할 데이터를 ModelAndView 객체에 추가
//			mav.addObject("list", list);

			if ("W".equals(call)) {
				mav.addObject("msg", "게시글이 등록되었습니다.");
			}
			return mav;

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@RequestMapping("/board/detail.do")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("/jsp/board/detail.jsp");
		String boardNo = req.getParameter("boardNo");

		try {
//			BoardVO board = service.detailBoard(boardNo);
//			mav.addObject("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
