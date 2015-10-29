package kr.co.edumis.admin.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.attendance.dao.AdminAttDAO;
import kr.co.edumis.admin.attendance.vo.AdminAttListVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Service
public class AdminAttServiceImpl implements AdminAttService{
	
	@Autowired
	private AdminAttDAO dao;
	
	@Override
	public List<MemberVO> selectMemList() {
		
		return dao.selectMemList();
	}
	@Override
	public List<AdminAttVO> selectAttList2() {
		
		return dao.selectAttList2();
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
	
	// 출석 통계
	public List<AdminAttListVO> selectAttList() throws Exception{
		return dao.selectAttList();
	}
	

}
