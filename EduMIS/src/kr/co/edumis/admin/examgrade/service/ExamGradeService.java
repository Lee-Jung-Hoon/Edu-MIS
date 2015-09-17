package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.user.member.vo.memberVO;

public interface ExamGradeService {

	public List<memberVO> getList() throws Exception;
}
