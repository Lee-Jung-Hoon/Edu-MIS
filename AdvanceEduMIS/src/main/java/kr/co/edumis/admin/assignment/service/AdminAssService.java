package kr.co.edumis.admin.assignment.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.SearchVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

/**
 * 
 * @author Administrator
 */
public interface AdminAssService {
	/**
	 *  관리자가 과제를 등록하는 기능
	 * @param adAssvo
	 * @throws Exception
	 */
	public void insert(AdminAssVO adAssvo) throws Exception;
	public List<AdminAssVO> list(Map<String, Object> param) throws Exception;
	public AdminAssVO detail(String no) throws Exception;
	public List<MemberVO> memberList() throws Exception; 
	public AdminAssVO modify() throws Exception; 
	public UserAssVO userDetail(String id, String no) throws Exception;
	public AdminAssVO detailDownload(String no) throws Exception;
	public void update(AdminAssVO adAssvo);
	public void delete(String no);
	public List<MemberVO> studentAssignmentList() throws Exception ;
	public List<UserAssVO> getsubList() throws Exception;
	public UserAssVO getDetail(Map<String, String> param) throws Exception;
	public int selectCount() throws Exception;
	public Map<String, Object> list(SearchVO vo) throws Exception;
}
