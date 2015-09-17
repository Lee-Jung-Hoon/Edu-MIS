package kr.co.edumis.admin.examgrade.dao;

import java.util.List;

import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.common.db.MyAppSqlConfig;

import org.apache.ibatis.session.SqlSession;

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
