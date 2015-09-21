package kr.co.edumis.user.assignment.service;

import java.util.List;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;


public interface UserAssService {
	
	//목록
	public List<AdminAssVO> getList() throws Exception;
	
	//등록
	public void registAssignment(UserAssVO userass) throws Exception;
	
	//과제내용- 상세조회
	public AdminAssVO detail(int no) throws Exception;
	
	

}
