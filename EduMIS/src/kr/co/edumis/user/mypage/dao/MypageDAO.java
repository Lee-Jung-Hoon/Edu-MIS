package kr.co.edumis.user.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.mypage.vo.MypageVO;

public class MypageDAO {
	
	private static SqlSession session = null;
	
	public MypageDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public List<MypageVO> selectMyinfo(String id) throws Exception{
		List<MypageVO> list = session.selectList("mypage.dao.MypageMapper.selectMyinfo", id);
		return list;
	}


	public void updateMyinfo(MypageVO vo) throws Exception{
		session.update("mypage.dao.MypageMapper.updateMyinfo", vo);
		session.commit();
	}
}
