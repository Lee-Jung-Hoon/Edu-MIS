package kr.co.edumis.admin.examgrade.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.MemberVO;

public class ExamGradeDAO {
	private static SqlSession session = null;
	
	public ExamGradeDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertExamBoard(ExamBoardVO board) {
		session.insert("examgrade.inserExamBoard", board);
		session.commit();
		
	}

	public List<ExamBoardVO> selectBoard() {
		List<ExamBoardVO> list = session.selectList("examgrade.selectExamBoardList");
		return list;
	}

	public List<MemberVO> selectMember() {
		List<MemberVO> list = session.selectList("examgrade.selectMember");
		return list;
	}

	public ExamBoardVO selectBoard(String no) {
		ExamBoardVO board = session.selectOne("examgrade.selectExamBoard", no);
		return board;
	}

	public void insertExamGrade(ExamGradeVO grade) {
		session.insert("examgrade.insertExamGrade", grade);
		session.commit();
	}

	public void updateBoardCheck(String no) {
		session.update("examgrade.updateBoardCheck", no);
		session.commit();
	}

	public List<ExamGradeVO> getGradeList(String no) {
		List<ExamGradeVO> list = session.selectList("examgrade.getGradeList", no);
		return list;
	}

}