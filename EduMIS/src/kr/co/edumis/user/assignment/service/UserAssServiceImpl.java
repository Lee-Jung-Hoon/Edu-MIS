package kr.co.edumis.user.assignment.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.dao.UserAssDAO;
import kr.co.edumis.user.assignment.vo.UserAssVO;

public class UserAssServiceImpl implements UserAssService{
	
	private UserAssDAO uasdao;
	
	public UserAssServiceImpl() {
		uasdao = new UserAssDAO();
	}
	
	public List<AdminAssVO> getList(Map<String, String> param) throws Exception{
		return uasdao.selectAssignment(param);
	}
	
	public AdminAssVO admdetail(int no) throws Exception{
		
		return uasdao.selectDetailAssignment(no);
	}
	
	public void registAssignment(UserAssVO userass) throws Exception{
		uasdao.registAssignment(userass); 
	}
	
	public UserAssVO userdetail(int no)throws Exception{
		return uasdao.userdetail(no);
	}
	
	public void updateUserAss(UserAssVO userass)throws Exception{
		uasdao.updateUserAss(userass);
	}
	//전체 게시물 조회
	public int AssCount() throws Exception{
		return uasdao.AssCount();
	}




}
