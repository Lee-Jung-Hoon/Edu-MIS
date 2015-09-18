package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface ExamGradeService {

	public void insertExamBoard(ExamBoardVO board) throws Exception;

	public List<ExamBoardVO> getBoardList() throws Exception;


}
