package kr.co.edumis.admin.examgrade.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.memberVO;

public class ExamGradeDAO {
	private static SqlSession session = null;
	
	public ExamGradeDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<memberVO> selectBoard() throws Exception {
		List<memberVO> list = session.selectList("examgrade.selectBoard");
		return list;
	}
}
