package kr.co.edumis.admin.attendance.service;

import java.util.List;

import kr.co.edumis.admin.attendance.dao.AdminAttDAO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class AdminAttServiceImpl implements AdminAttService{

	private AdminAttDAO dao = null;
	
	public AdminAttServiceImpl(){
		dao = new AdminAttDAO();
	}
	@Override
	public List<MemberVO> selectMemList() {
		
		List<MemberVO> memList = dao.selectMemList();
		return memList;
	}
	@Override
	public List<AdminAttVO> selectAttList() {
		
		List<AdminAttVO> attList = dao.selectAttList();
		System.out.println(attList.size());
		return attList;
	}
	@Override
	public void insertAtt(AdminAttVO att) {
		dao.insertAtt(att);
	}
	@Override
	public void updateAtt(AdminAttVO att) {
		dao.updateAtt(att);
	}
	@Override
	public List<AdminAttVO> selectAttMemList(String mNo) {
		List<AdminAttVO> attMemList = dao.selectAttMemList(mNo);
		return attMemList;
	}
	//**************** 꾸중이 ********************   
	   @Override
	   public List<AdminAttVO> selectAttList2() {
	      List<AdminAttVO> attList2 = dao.selectAttList2();
	      return attList2;
	   }
	   @Override
	   public List<AdminAttVO> selectAttendList(int attType) {
	      List<AdminAttVO> attendList = dao.selectAttendList(attType);
	      return attendList;
	   }
	//**************** 꾸중이 ********************   

}
