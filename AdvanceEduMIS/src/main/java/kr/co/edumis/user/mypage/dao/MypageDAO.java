package kr.co.edumis.user.mypage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.mypage.vo.MypageVO;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate session;

	public MypageVO selectMyinfo(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("mypage.dao.MypageMapper.selectMyinfo", id);
	}

	public void updateMyinfo(MypageVO mvo) {
		// TODO Auto-generated method stub
		session.update("mypage.dao.MypageMapper.updateMyinfo", mvo);
	}
	
}
