package kr.co.edumis.user.mypage.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.mypage.vo.MypageVO;

public class MypageDAO {
	
	private static SqlSession session = null;
	
	public MypageDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public MypageVO selectMyinfo(String id) throws Exception{
		
		
		return null;
	}

}
