package kr.co.edumis.admin.attendance.service;

import java.util.List;

import kr.co.edumis.admin.attendance.vo.AdminAttListVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;



public interface AdminAttService {
	
	// 출석 통계
	public List<AdminAttListVO> selectAttList() throws Exception;
	
	// 멤버정보
	public List<MemberVO> selectMemList();
	// 출석정보리스트
	public List<AdminAttVO> selectAttList2();
	// 개인당 출석정보
	public List<AdminAttVO> selectAttMemList(String mNo);
	// 출석입력
	public void insertAtt(AdminAttVO att);
	// 출석수정
	public void updateAtt(AdminAttVO att);

}
