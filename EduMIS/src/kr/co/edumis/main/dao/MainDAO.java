package kr.co.edumis.main.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.main.vo.MainAdminAttVO;

public class MainDAO {
	
	private static SqlSession session = null;
	
	public MainDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public MainAdminAttVO selectDailyAttend () {
		return session.selectOne("");
	}
}
