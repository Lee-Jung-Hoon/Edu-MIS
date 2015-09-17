package kr.co.admin.examgrade.service;

import java.util.List;

import kr.co.admin.examgrade.dao.ExamGradeDAO;
import kr.co.admin.examgrade.vo.ExamGradeVO;

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
