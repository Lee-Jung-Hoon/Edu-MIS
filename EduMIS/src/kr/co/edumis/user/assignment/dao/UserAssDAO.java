package kr.co.edumis.user.assignment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.assignment.vo.UserAssVO;

public class UserAssDAO {
	private static SqlSession session = null;
	
	public UserAssDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
//	public List<UserAssVO> selectAssignment throws Exception{
//		
//	}

}
