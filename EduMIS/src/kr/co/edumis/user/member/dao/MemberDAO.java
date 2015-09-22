package kr.co.edumis.user.member.dao;



import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.MemberVO;

import org.apache.ibatis.session.SqlSession;


public class MemberDAO {

	private static SqlSession session = null;
	
	public MemberDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public void insertMember(MemberVO member) {
		session.insert("member.dao.MemberMapper.memberJoin", member);
		session.commit();
	}

}
