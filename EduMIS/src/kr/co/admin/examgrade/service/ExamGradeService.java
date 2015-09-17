package kr.co.admin.examgrade.service;

import java.util.List;

import kr.co.admin.examgrade.vo.ExamGradeVO;

public interface ExamGradeService {

	public List<ExamGradeVO> getList() throws Exception;
}
