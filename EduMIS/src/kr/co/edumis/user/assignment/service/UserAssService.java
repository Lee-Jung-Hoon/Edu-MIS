package kr.co.edumis.user.assignment.service;

import java.util.List;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;


public interface UserAssService {
	
	//과제해야 할 전체목록
	public List<AdminAssVO> getList() throws Exception;
	
	
	//등록
	public void registAssignment(UserAssVO userass) throws Exception;
	
	//과제내용- 상세조회
	public AdminAssVO addetail(int no) throws Exception;
	
	//제출한 과제 상세조회
	public UserAssVO userdetail(int no)throws Exception;
	

}
