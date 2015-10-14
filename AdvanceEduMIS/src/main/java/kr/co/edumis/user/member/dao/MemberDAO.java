package kr.co.edumis.user.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.member.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate SqlSessionTemplate ;

	public void insertMember(MemberVO member) throws Exception {
		SqlSessionTemplate.insert("member.dao.MemberMapper.memberJoin", member);
		
	}

	public void resetLeader()  {
		SqlSessionTemplate.update("member.dao.MemberMapper.resetLeader");
		
	}

	public List<MemberVO> selectMember()  {
		System.out.println("테스트");
		
		List<MemberVO> list = SqlSessionTemplate.selectList("member.dao.MemberMapper.getMember");
		System.out.println(list.size());
		
		return list;
	}

	public void updateLeader(MemberVO member)   {
		SqlSessionTemplate.update("member.dao.MemberMapper.updateLeader", member);
		
	}

}
