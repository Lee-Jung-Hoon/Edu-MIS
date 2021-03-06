package kr.co.edumis.user.login.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.login.vo.LoginVO;

@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public LoginVO selectMember(LoginVO login) throws Exception {
		return session.selectOne("login.dao.LoginMapper.login", login);
	}
}
