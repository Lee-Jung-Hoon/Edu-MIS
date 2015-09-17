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
import kr.co.edumis.user.member.vo.memberVO;

@Controller
public class ExamGradeController {
	private ExamGradeService service;

	public ExamGradeController() {
		service = new ExamGradeServiceImpl();
	}

	@RequestMapping("/examgrade/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		ModelAndView mav = new ModelAndView("/jsp/admin/examgrade/examwrite.jsp");
										
		try {
			List<memberVO> list = service.getList();
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/examgrade/write.do")
	public String write(ExamGradeVO gradeVO) throws Exception {
		System.out.println("gradeVO : " + gradeVO);
		return "redirect:/EduMIS/examgrade/writeForm.do";
	}
}
