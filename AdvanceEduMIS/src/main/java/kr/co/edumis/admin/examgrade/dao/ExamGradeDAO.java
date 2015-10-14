package kr.co.edumis.admin.examgrade.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.user.member.vo.MemberVO;
@Repository
public class ExamGradeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	public void insertExamBoard(ExamBoardVO board) {
		sqlsession.insert("examgrade.inserExamBoard", board);
		
	}

	public List<ExamBoardVO> selectBoard() {
		List<ExamBoardVO> list = sqlsession.selectList("examgrade.selectExamBoardList");
		return list;
	}

	public List<MemberVO> selectMember() {
		List<MemberVO> list = sqlsession.selectList("examgrade.selectMember");
		return list;
	}

	public ExamBoardVO selectBoard(String no) {
		ExamBoardVO board = sqlsession.selectOne("examgrade.selectExamBoard", no);
		return board;
	}

	public void insertExamGrade(ExamGradeVO grade) {
		sqlsession.insert("examgrade.insertExamGrade", grade);
	}

	public void updateBoardCheck(String no) {
		sqlsession.update("examgrade.updateBoardCheck", no);
	}

	public List<ExamGradeVO> getGradeList(String no) {
		List<ExamGradeVO> list = sqlsession.selectList("examgrade.getGradeList", no);
		return list;
	}

	public List<ExamGradeVO> getGrade(String id) {
		List<ExamGradeVO> list = sqlsession.selectList("examgrade.getGrade", id);
		return list;
	}

	public void UpdateScore(ExamGradeVO g) {
		sqlsession.update("examgrade.setScore", g);
	}

	public MemberVO getMember(String id) {
		MemberVO member = sqlsession.selectOne("examgrade.getmember", id);
		return member;
	}

	public void deleteExamTurn(String no) {
		sqlsession.delete("examgrade.deleteExamTurn", no);
	}

	public void UpdateExamTurn(ExamBoardVO board) {
		sqlsession.update("examgrade.setExamTurn", board);
	}

	public void deleteExamGrade(String no) {
		sqlsession.delete("examgrade.deleteExamGrade", no);
	}
}