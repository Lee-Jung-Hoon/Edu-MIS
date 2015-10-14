package kr.co.edumis.admin.examgrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.examgrade.service.ExamGradeService;
import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/examgrade")
public class ExamGradeController {

	@Autowired
	private ExamGradeService service;

	// 성적 관리 메인으로 이동
	@RequestMapping("/ExamGradeMain.do")
	public String ExamGradeMain() {
		return "admin/examgrade/exammain";
	}

	// 시험 등록폼으로 이동
	@RequestMapping("/ExamTurnWriteForm.do")
	public String ExamTurnWriteForm() {
		return "admin/examgrade/examturnwriteForm";
	}

	// 시험 등록
	@RequestMapping("/ExamTurnWrite.do")
	public String ExamTurnWrite(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String datepicker = req.getParameter("datepicker");
		System.out.println(datepicker);
		String date = datepicker.replace("-", "");
		System.out.println(date);

		ExamBoardVO board = new ExamBoardVO();
		board.setTitle(title);
		board.setRegDate(date);
		board.setContent(content);

		try {
			service.insertExamBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/examgrade/exammain";
	}

	// 시험 리스트 출력
	@RequestMapping("/ExamTurnList.do")
	public ModelAndView ExamTurnList() {
		ModelAndView mav = new ModelAndView("admin/examgrade/examlist");

		try {
			List<ExamBoardVO> list = service.getBoardList();
			for (int i = 0; i < list.size(); i++)
				System.out.println("ck : " + list.get(i).getCk());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 시험 점수 입력 폼으로 이동
	@RequestMapping("/ExamGradeWriteForm.do")
	public ModelAndView ExamGradeWrite(String no) {
		ModelAndView mav = new ModelAndView("admin/examgrade/examwrite");

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

	// 시험 점수 입력
	@RequestMapping("/writescore.do")
	public ModelAndView WriteScore(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("jsp/admin/examgrade/exammain");

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

	// 시험별 상세 출력
	@RequestMapping("/ExamGradeDetail.do")
	public ModelAndView ExamGradeDetail(String no) {
		ModelAndView mav = new ModelAndView("admin/examgrade/examdetail");

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

	// 학생별 상세 출력
	@RequestMapping("/StudentGradeDetail.do")
	public ModelAndView StudentGradeDetail(String id) {
		ModelAndView mav = new ModelAndView("admin/examgrade/studentdetail");

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

	// 학생 리스트 출력
	@RequestMapping("/ExamStudentList.do")
	public ModelAndView ExamStudentList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/examgrade/studentlist");

		List<MemberVO> member;
		try {
			member = service.getMemeberList();
			mav.addObject("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 성적 수정 폼으로 이동
	@RequestMapping("/ExamGradeModifyForm.do")
	public ModelAndView ExamGradeModifyForm(String no) {
		ModelAndView mav = new ModelAndView("admin/examgrade/exammodify");

		try {
			List<ExamGradeVO> grade = service.getGradeList(no);
			mav.addObject("list", grade);
			mav.addObject("no", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 성적 수정
	@RequestMapping("/ModifyScoreUpdate.do")
	public ModelAndView ExamGradeModifyForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/examgrade/exammain");

		String no = req.getParameter("no");
		System.out.println(no);
		try {
			List<ExamGradeVO> grade = service.getGradeList(no);
			for (ExamGradeVO g : grade) {
				g.setScore(Integer.parseInt(req.getParameter(g.getId())));
				g.setNo(no);
				service.UpdateScore(g);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 시험 삭제
	@RequestMapping("/ExamTurnDelete.do")
	public ModelAndView ExamTurnDelete(String no) {
		ModelAndView mav = new ModelAndView("admin/examgrade/exammain");
		try {
			service.deleteExamGrade(no);
			service.deleteExamTurn(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 시험 정보 수정폼으로 이동
	@RequestMapping("/ExamTurnModify.do")
	public ModelAndView ExamTurnModify(String no) {
		ModelAndView mav = new ModelAndView("admin/examgrade/examTurnmodify");
		try {
			List<ExamGradeVO> list = service.getGradeList(no);
			mav.addObject("list", list);
			ExamBoardVO board = service.getBoard(no);
			mav.addObject("board", board);
			mav.addObject("no", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 시험 정보 수정
	@RequestMapping("/ExamTurnUpdate.do")
	public ModelAndView ExamTurnUpdate(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/examgrade/exammain");

		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String datepicker = req.getParameter("datepicker");
		String year = datepicker.substring(6);
		String month = datepicker.substring(0, 2);
		String day = datepicker.substring(3, 5);
		String date = year + "" + month + "" + day;

		ExamBoardVO board = new ExamBoardVO();
		board.setTitle(title);
		board.setRegDate(date);
		board.setContent(content);
		board.setNo(no);

		try {
			service.UpdateExamTurn(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/excelExport.do")
	public String excelExport() {
		return "admin/examgrade/excelExport";
	}

	@RequestMapping("excelList.do")
	@ResponseBody
	protected String excelList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, Exception {
		
		ModelAndView mav = new ModelAndView("admin/examgrade/examExcelAjax");
		
		List<MemberVO> memList;
		memList = service.getMemeberList();

		String json = "";
		json += "[";
		for (int i = 0; i < memList.size(); i++) {
			MemberVO mem = memList.get(i);

			json += "  {";
			json += "'no': '" + mem.getNo() + "', ";
			json += "'name': " + "'" + mem.getName() + "' ";

			List<ExamGradeVO> GradeMemList = service.getGrade(mem.getId());
			for (int j = 0; j < GradeMemList.size(); j++) {
				if (j == 0) {
					json += ", ";
					json += "'score': [";
				}
				ExamGradeVO GradeMem = GradeMemList.get(j);
				json += "'" + GradeMem.getTitle() + ":" + GradeMem.getScore() + "' ";

				if (j != GradeMemList.size() - 1) {
					json += ", ";
				}
			}
			if (GradeMemList.size() != 0) {
				json += "]";
			}

			json += "  } ";

			if (i != memList.size() - 1) {
				json += ", ";
			}
		}

		json += "]";
		
		System.out.println(json);

		return json;
	}
}
