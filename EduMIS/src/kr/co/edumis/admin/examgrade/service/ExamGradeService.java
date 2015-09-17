package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;

public interface ExamGradeService {

	public List<ExamGradeVO> getList() throws Exception;
}
