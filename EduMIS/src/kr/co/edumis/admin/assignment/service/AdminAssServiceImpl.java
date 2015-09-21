package kr.co.edumis.admin.assignment.service;

import java.util.List;

import kr.co.edumis.admin.assignment.dao.AdminAssDAO;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class AdminAssServiceImpl implements AdminAssService {

	private AdminAssDAO dao;

	public AdminAssServiceImpl() {
		dao = new AdminAssDAO();
	}

	@Override
	public void insert(AdminAssVO adAssvo) throws Exception {
		// TODO Auto-generated method stub
		
		dao.insertAss(adAssvo);
	}

	@Override
	public List<AdminAssVO> list() throws Exception {
		
		List<AdminAssVO> list = dao.selectList();
		
		return list;
	}

	@Override
	public AdminAssVO detail(String no) throws Exception {
		return dao.selectDetail(no);
	}

	@Override
	public List<MemberVO> memberList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminAssVO modify() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAssVO userDetail(String id, String no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminAssVO detailDownload(String no) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectDetail(no);
	}

	@Override
	public AdminAssVO modify(String no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AdminAssVO adAssvo) {
		// TODO Auto-generated method stub
		dao.updateAss(adAssvo);
	}

}
