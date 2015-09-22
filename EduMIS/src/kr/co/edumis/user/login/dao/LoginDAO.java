package kr.co.edumis.user.login.dao;


import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.login.vo.LoginVO;

public class LoginDAO {
	
	private static SqlSession session = null;
	
	public LoginDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public LoginVO selectMember(LoginVO login) throws Exception {
		return session.selectOne("login.dao.LoginMapper.login", login);
		
	}
}
