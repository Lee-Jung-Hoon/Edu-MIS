package kr.co.edumis.user.assignment.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;
public interface UserAssService {
	
	//과제해야 할 전체목록
	public List<AdminAssVO> getList(Map<String, String> param) throws Exception;
	
	//등록
	public void registAssignment(UserAssVO userass) throws Exception;
	
	//과제내용- 상세조회
	public AdminAssVO admdetail(String no) throws Exception;
	
	//제출한 과제 상세조회
	public UserAssVO userdetail(Map<String, String> param)throws Exception;
	
	//과제 수정
	public void updateUserAss(UserAssVO userass)throws Exception;
	
//	//제출한 과제 번호 목록
//	public List<String> userSubmitCheck(String id)throws Exception; 
	
	//전체 게시물  꺼내오기
	public int AssCount() throws Exception;

	
	

}
