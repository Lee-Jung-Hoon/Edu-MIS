package kr.co.edumis.user.member.dao;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.edumis.user.member.vo.MemberVO;


public class MemberDAO {

	private static SqlSessionTemplate session = null;
	
	public void insertMember(MemberVO member) {
		session.insert("member.dao.MemberMapper.memberJoin", member);
		session.commit();
	}
	
	public void resetLeader() {
		session.update("member.dao.MemberMapper.resetLeader");
		session.commit();
	}
	public List<MemberVO>  selectMember() {
		
		return session.selectList("member.dao.MemberMapper.getMemberList");
	}
	
	public void updateLeader(MemberVO mvo) {
		session.update("member.dao.MemberMapper.updateLeader", mvo);
		session.commit();
	}

}