package kr.co.edumis.user.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.vote.vo.VoteVO;

public class VoteDAO {

	private static SqlSession session = null;

	public VoteDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public List<VoteVO> selectList() throws Exception {

		return session.selectList("vote.dao.voteMapper.vote");
	}

}
