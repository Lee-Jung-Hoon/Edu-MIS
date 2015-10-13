package kr.co.edumis.user.login.service;

import kr.co.edumis.user.login.dao.LoginDAO;
import kr.co.edumis.user.login.vo.LoginVO;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao;
	public LoginServiceImpl(){
		dao = new LoginDAO();
	}

	@Override
	public LoginVO login(LoginVO login) throws Exception {
		return dao.selectMember(login);
	}
}
