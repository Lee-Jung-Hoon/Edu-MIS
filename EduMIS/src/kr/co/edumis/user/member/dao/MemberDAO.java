package kr.co.edumis.user.member.dao;



import org.apache.ibatis.session.SqlSession;

import minipro.memberVO.MemberVO;


public class MemberDAO {

	private static SqlSession session = null;
	
	public MemberDAO() {
//		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public int memberJoin(MemberVO member) throws Exception {
		session.insert("member.dao.MemberMapper.memberJoin", member);
		session.commit();
		return 1;
	}
}
