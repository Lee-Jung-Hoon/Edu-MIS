package kr.co.edumis.admin.assignment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.assignment.dao.AdminAssDAO;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Service
public class AdminAssServiceImpl implements AdminAssService {
	
	@Autowired
	private AdminAssDAO dao;

	@Override
	public void insert(AdminAssVO adAssvo) throws Exception {
		dao.insertAss(adAssvo);
	}

	@Override
	public List<AdminAssVO> list(Map<String, Integer> param) throws Exception {
		List<AdminAssVO> list = dao.selectList(param);
		
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

	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		dao.delete(no);
	}

	@Override
	public List<MemberVO> studentAssignmentList() throws Exception {
		return dao.selectMember();
	}

	@Override
	public List<UserAssVO> getsubList() throws Exception {
		return dao.selectSubmit();
	}

	@Override
	public UserAssVO getDetail(Map<String, String> param) {
		return dao.selectSubject(param);
	}

	@Override
	public int selectCount() throws Exception {
		return dao.selectCount();
		
	}

}
