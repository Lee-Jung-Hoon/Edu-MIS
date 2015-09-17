package kr.co.admin.examgrade.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.admin.examgrade.vo.ExamGradeVO;

public class ExamGradeDAO {
	private static SqlSession session = null;
	
	public ExamGradeDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<ExamGradeVO> selectBoard() throws Exception {
		List<ExamGradeVO> list = session.selectList("examgrade.selectBoard");
		System.out.println(list.size());
		return null;
	}
}
