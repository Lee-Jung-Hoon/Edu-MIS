package kr.co.edumis.admin.assignment.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.db.MyAppSqlConfig;

public class AdminAssDAO {
	
	private static SqlSession sqlMapper;
	
	public AdminAssDAO(){
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertAss(AdminAssVO adAssvo) {
		
		sqlMapper.insert("Assignment.registAssignment.", adAssvo);
		sqlMapper.commit();
		
	}

}
