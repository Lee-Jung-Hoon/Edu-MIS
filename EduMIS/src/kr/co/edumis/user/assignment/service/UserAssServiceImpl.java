package kr.co.edumis.user.assignment.service;

import java.util.List;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.dao.UserAssDAO;
import kr.co.edumis.user.assignment.vo.UserAssVO;

public class UserAssServiceImpl implements UserAssService{
	
	private UserAssDAO uasdao;
	
	public UserAssServiceImpl() {
		uasdao = new UserAssDAO();
	}
	
	public List<AdminAssVO> getList() throws Exception{
		return uasdao.selectAssignment();
	}
	
	public AdminAssVO addetail(int no) throws Exception{
		
		return uasdao.selectDetailAssignment(no);
	}
	
	public void registAssignment(UserAssVO userass) throws Exception{
		uasdao.registAssignment(userass); 
	}
	
	public UserAssVO userdetail(int no)throws Exception{
		return uasdao.userdetail(no);
	}


}
