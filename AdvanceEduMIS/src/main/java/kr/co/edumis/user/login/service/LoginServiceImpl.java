package kr.co.edumis.user.login.service;

import org.springframework.stereotype.Service;

import kr.co.edumis.user.login.dao.LoginDAO;
import kr.co.edumis.user.login.vo.LoginVO;

@Service
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
