package kr.co.edumis.user.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao; 

	@Override
	public void insertMember(MemberVO member) throws Exception {
		dao.insertMember(member);
	}
	public List<MemberVO> selectMember() throws Exception {
		return dao.selectMember();
	}
	public void resetLeader() throws Exception {
		dao.resetLeader();
	}
	public void updateLeader(MemberVO member) throws Exception {
		dao.updateLeader(member);
	}
}
