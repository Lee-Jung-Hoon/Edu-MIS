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
}
