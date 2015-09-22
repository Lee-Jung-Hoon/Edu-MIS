package kr.co.edumis.user.member.service;

import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = null; 

	public MemberServiceImpl() {
		dao = new MemberDAO();
	}

	@Override
	public void insertMember(MemberVO member) throws Exception {
		dao.insertMember(member);
	}
}
