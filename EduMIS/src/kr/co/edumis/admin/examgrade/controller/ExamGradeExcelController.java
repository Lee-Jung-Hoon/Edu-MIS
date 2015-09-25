package kr.co.edumis.admin.examgrade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.examgrade.service.ExamGradeService;
import kr.co.edumis.admin.examgrade.service.ExamGradeServiceImpl;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.user.member.vo.MemberVO;

@WebServlet("/ExamGradeExcelController.do")
public class ExamGradeExcelController extends HttpServlet {
	private ExamGradeService service;

	public ExamGradeExcelController() {
		service = new ExamGradeServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=utf-8");
		PrintWriter out = res.getWriter();
		List<MemberVO> memList;
		try {
			memList = service.getMemeberList();

			String json = "";
			json += "[";
			for (int i = 0; i < memList.size(); i++) {
				MemberVO mem = memList.get(i);

				json += "  {";
				json += "	'no': '" + mem.getNo() + "', ";
				json += "	'name': " + "'" + mem.getName() + "' ";

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
			System.out.println(json);
			
			json += "]";
			
			out.println(json);
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}