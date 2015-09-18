package kr.co.edumis.admin.examgrade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.edumis.admin.examgrade.service.ExamGradeService;
import kr.co.edumis.admin.examgrade.service.ExamGradeServiceImpl;
import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
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
	
//	@RequestMapping("/examgrade/examturnlist.do")
//	public ModelAndView examTurnList(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examlist.jsp");
//		
//		try {
//			List<ExamBoardVO> list = service.getBoardList();
//			mav.addObject("list", list);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mav;
//	
	
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
		
		ExamBoardVO board = new ExamBoardVO();
		board.setTitle(title);
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
		
//		List<MemberVO> member;
		try {
//			member = service.getMemeberList(no);
//			mav.addObject("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
}
