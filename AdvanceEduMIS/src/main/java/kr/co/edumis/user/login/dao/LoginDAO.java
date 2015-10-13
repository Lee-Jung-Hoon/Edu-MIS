package kr.co.edumis.user.login.dao;


import org.mybatis.spring.SqlSessionTemplate;

import kr.co.edumis.user.login.vo.LoginVO;

public class LoginDAO {
	
	private static SqlSessionTemplate session = null;
	
	public LoginVO selectMember(LoginVO login) throws Exception {
		return session.selectOne("login.dao.LoginMapper.login", login);
		
	}
}
