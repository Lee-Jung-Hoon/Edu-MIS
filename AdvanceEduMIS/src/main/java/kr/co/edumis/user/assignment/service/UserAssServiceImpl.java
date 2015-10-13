package kr.co.edumis.user.assignment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.dao.UserAssDAO;
import kr.co.edumis.user.assignment.vo.UserAssVO;


@Repository
public class UserAssServiceImpl implements UserAssService{
	
	@Autowired
	private UserAssDAO uasdao;
	

	public List<AdminAssVO> getList(Map<String, String> param) throws Exception{
		return uasdao.selectAssignment(param);
	}
	
	public AdminAssVO admdetail(String no) throws Exception{
		
		return uasdao.selectDetailAssignment(no);
	}
	
	public void registAssignment(UserAssVO userass) throws Exception{
		uasdao.registAssignment(userass); 
	}
	
	public UserAssVO userdetail(Map<String, String> param)throws Exception{
		return uasdao.userdetail(param);
	}
	
	public void updateUserAss(UserAssVO userass)throws Exception{
		uasdao.updateUserAss(userass);
	}
	//전체 게시물 조회
	public int AssCount() throws Exception{
		return uasdao.AssCount();
	}




}
