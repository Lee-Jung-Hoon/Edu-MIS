package kr.co.edumis.user.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.member.vo.MemberVO;

@Repository
public class MemberDAO {

	private static SqlSessionTemplate session = null;

	public void insertMember(MemberVO member) throws Exception {
		session.insert("member.dao.MemberMapper.memberJoin", member);
		session.commit();
	}

	public void resetLeader() throws Exception {
		session.update("member.dao.MemberMapper.resetLeader");
		session.commit();
	}

	public List<MemberVO> selectMember() throws Exception {
		return session.selectList("member.dao.MemberMapper.getMemberList");
	}

	public void updateLeader(MemberVO mvo)  throws Exception {
		session.update("member.dao.MemberMapper.updateLeader", mvo);
		session.commit();
	}

}
