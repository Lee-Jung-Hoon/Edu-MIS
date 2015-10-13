package kr.co.edumis.user.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IdCheckDAO {

	private static SqlSessionTemplate session = null;

	public int selectId(String id) throws Exception{
//		 int no = session.selectOne("idCheck.dao.IdCheckMapper.idCheck",id);
//		 System.out.println(no);
		return session.selectOne("idCheck.dao.IdCheckMapper.idCheck",id);
		
	}
}
