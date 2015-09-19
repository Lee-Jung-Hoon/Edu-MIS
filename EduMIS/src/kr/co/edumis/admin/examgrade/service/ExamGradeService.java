package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface ExamGradeService {

	public void insertExamBoard(ExamBoardVO board) throws Exception;

	public List<ExamBoardVO> getBoardList() throws Exception;

	public List<MemberVO> getMemeberList() throws Exception;

	public ExamBoardVO getBoard(String no) throws Exception;

	public void insertExamGrade(ExamGradeVO grade) throws Exception;

	public void updateBoardCheck(String no)  throws Exception;

	public List<ExamGradeVO> getGradeList(String no) throws Exception;


}
