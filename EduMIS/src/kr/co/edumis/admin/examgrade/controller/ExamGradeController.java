package kr.co.edumis.admin.examgrade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.edumis.admin.examgrade.service.ExamGradeService;
import kr.co.edumis.admin.examgrade.service.ExamGradeServiceImpl;
import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class ExamGradeController {
	private ExamGradeService service;

	public ExamGradeController() {
		service = new ExamGradeServiceImpl();
	}

	@RequestMapping("/examgrade/ExamTurnWriteForm.do")
	public ModelAndView ExamTurnWriteForm() {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/examgrade/examturnwriteForm.jsp");
		return mav;
	}

	@RequestMapping("/examgrade/ExamTurnWrite.do")
	public ModelAndView ExamTurnWrite(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/examgrade/ExamTurnList.do");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String date = req.getParameter("date");

		ExamBoardVO board = new ExamBoardVO();
		board.setTitle(title);
		board.setRegDate(date);
		board.setContent(content);

		try {
			service.insertExamBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/examgrade/ExamTurnList.do")
	public ModelAndView ExamTurnList() {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examlist.jsp");

		try {
			List<ExamBoardVO> list = service.getBoardList();
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/examgrade/ExamGradeWriteForm.do")
	public ModelAndView ExamGradeWrite(String no) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examwrite.jsp");

		List<MemberVO> member;
		try {
			ExamBoardVO board = service.getBoard(no);
			mav.addObject("board", board);
			member = service.getMemeberList();
			mav.addObject("member", member);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/examgrade/writescore.do")
	public ModelAndView WriteScore(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/examgrade/ExamTurnList.do");

		List<MemberVO> member;
		try {
			member = service.getMemeberList();
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String no = req.getParameter("no");
			for (MemberVO m : member) {
				String score = req.getParameter(m.getId());
				ExamGradeVO grade = new ExamGradeVO();
				grade.setId(m.getId());
				grade.setName(m.getName());
				grade.setScore(Integer.parseInt(score));
				grade.setTitle(title);
				grade.setContent(content);
				grade.setNo(no);
				service.insertExamGrade(grade);
			}
			service.updateBoardCheck(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/examgrade/ExamGradeDetail.do")
	public ModelAndView ExamGradeDetail(String no) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examdetail.jsp");

		ExamBoardVO board;
		try {
			List<ExamGradeVO> list = service.getGradeList(no);
			mav.addObject("list", list);
			board = service.getBoard(no);
			mav.addObject("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
