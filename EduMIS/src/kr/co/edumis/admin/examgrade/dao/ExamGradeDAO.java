package kr.co.edumis.admin.examgrade.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
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
		List<ExamBoardVO> list = session.selectList("examgrade.selectExamBoard");
		return list;
	}
}