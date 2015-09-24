package kr.co.edumis.user.member.dao;

import org.apache.ibatis.session.SqlSession;
import kr.co.edumis.common.db.MyAppSqlConfig;

public class IdCheckDAO {

	private static SqlSession session = null;

	public IdCheckDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public int selectId(String id) {
//		 int no = session.selectOne("idCheck.dao.IdCheckMapper.idCheck",id);
//		 System.out.println(no);
		return session.selectOne("idCheck.dao.IdCheckMapper.idCheck",id);
		
	}
}
