package kr.co.edumis.user.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.PostNoVO;

public class PostNoDAO {
	private static SqlSession session = null;
	
	public PostNoDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<PostNoVO> getPostNoList(String dong) {
		List<PostNoVO> list = session.selectList("postno.getPostNoList", dong);
		return list;
	}

	public String selectAddr(String zipcode) {
		PostNoVO addrArr = session.selectOne("postno.selectAddr", zipcode);
		
		String addr = "";
		
//		sido, gugun, dong, ri, bunji
		addr += addrArr.getSido() + " ";
		addr += addrArr.getGugun() + " ";
		addr += addrArr.getDong() + " ";
		if(addrArr.getRi().equals(null))
			addr += "";
		else
			addr += addrArr.getRi() + " ";
		if(addrArr.getBunji().equals(null))
			addr += "";
		else	
			addr += addrArr.getBunji() + " ";
		
		return addr;
	}
}
