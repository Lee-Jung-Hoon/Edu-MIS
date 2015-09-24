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
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/examgrade/exammain.jsp");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String datepicker = req.getParameter("datepicker");
		String year = datepicker.substring(6);
		String month = datepicker.substring(0,2);
		String day = datepicker.substring(3,5);
		String date = year+""+month+""+day;

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
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/examgrade/exammain.jsp");

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
	
	@RequestMapping("/examgrade/StudentGradeDetail.do")
	public ModelAndView StudentGradeDetail(String id) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/studentdetail.jsp");
		
		try {
			MemberVO member = service.getMember(id);
			List<ExamGradeVO> list = service.getGrade(id);
			mav.addObject("list", list);
			mav.addObject("member", member);
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/examgrade/ExamStudentList.do")
	public ModelAndView ExamStudentList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/studentlist.jsp");

		List<MemberVO> member;
		try {
			member = service.getMemeberList();
			mav.addObject("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	@RequestMapping("/examgrade/ExamGradeModifyForm.do")
	public ModelAndView ExamGradeModifyForm(String no) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/exammodify.jsp");

		try {
			List<ExamGradeVO> grade = service.getGradeList(no);
			mav.addObject("list", grade);
			mav.addObject("no", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/examgrade/ModifyScoreUpdate.do")
	public ModelAndView ExamGradeModifyForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/exammain.jsp");

		String no = req.getParameter("no");
		System.out.println(no);
		try {
			List<ExamGradeVO> grade = service.getGradeList(no);
			for(ExamGradeVO g : grade) {
				g.setScore(Integer.parseInt(req.getParameter(g.getId())));
				g.setNo(no);
				service.UpdateScore(g);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/examgrade/ExamTurnDelete.do")
	public ModelAndView ExamTurnDelete(String no) {
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/examgrade/exammain.jsp");
		try {
			service.deleteExamTurn(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
//	<th width="100px">번호</th>
//	<th width="200px">이름</th>
//	<th width="300px">아이디</th>
//	<th width="100px">가입일</th>
	
	
//	ExamTurnModify.do
}
