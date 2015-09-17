package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.dao.ExamGradeDAO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;

public class ExamGradeServiceImpl implements ExamGradeService {
	private ExamGradeDAO dao = null;
	
	public ExamGradeServiceImpl() {
		dao = new ExamGradeDAO();
	}
	
	@Override
	public List<ExamGradeVO> getList() throws Exception {
		return dao.selectBoard();
	}

}
