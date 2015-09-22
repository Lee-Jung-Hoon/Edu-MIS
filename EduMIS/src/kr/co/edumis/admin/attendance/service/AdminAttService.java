package kr.co.edumis.admin.attendance.service;

import java.util.List;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface AdminAttService {

	public List<MemberVO> selectMemList() ;
	
	public List<AdminAttVO> selectAttList();
	
	public List<AdminAttVO> selectAttMemList(String mNo);
	
	public void insertAtt(AdminAttVO att);
	
	public void updateAtt(AdminAttVO att);
	
	
	
}
