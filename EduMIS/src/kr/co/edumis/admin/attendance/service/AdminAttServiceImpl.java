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
		System.out.println("size : " + memList.size());
//		for(int i = 0; i < memList.size(); i++){
//			MemberVO member = memList.get(i);
//			System.out.println("name : "+memList.get(i).getName());
//		}
//		MemberVO member = memList.get(0);
//		System.out.println("size2 : " + memList.size());
		
		System.out.println("servieImpl member : "+ memList.get(0).getName());
		return memList;
	}
	@Override
	public List<AdminAttVO> selectAttList(String mNo) {
		
		List<AdminAttVO> attList = dao.selectAttList(mNo);
		
		return attList;
	}
	@Override
	public void insertAtt(AdminAttVO att) {
		dao.insertAtt(att);
	}
	@Override
	public void updateAtt(AdminAttVO att) {
		
	}

}
