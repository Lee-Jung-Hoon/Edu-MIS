package kr.co.edumis.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;

public class MainDAO {
	
	private static SqlSession session = null;
	
	public MainDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	// 일일 출석 현황 결과
	public List<String> selectDailyAttend(){
		return session.selectList("main.dao.mainMapper.attendance");
	}
	
	public List<String> selectDailyAbsent(){
		return session.selectList("main.dao.mainMapper.absent");
	}
	
	public List<String> selectDailyLate(){
		return session.selectList("main.dao.mainMapper.late");
	}
}
