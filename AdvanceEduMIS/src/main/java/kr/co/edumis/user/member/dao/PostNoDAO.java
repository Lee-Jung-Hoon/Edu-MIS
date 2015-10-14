package kr.co.edumis.user.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.member.vo.PostNoVO;

@Repository
public class PostNoDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<PostNoVO> getPostNoList(String dong)  throws Exception {
		List<PostNoVO> list = session.selectList("postno.getPostNoList", dong);
		return list;
	}

	public String selectAddr(String zipcode)  throws Exception {
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
