package kr.co.edumis.user.vote.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.vote.vo.VoteVO;

@Repository
public class VoteDAO {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	public List<VoteVO> selectList() throws Exception {
		List<VoteVO> list = sqlsession.selectList("kr.co.edumis.user.vote.dao.vote");
		return list;
	}

	public List<VoteVO> ResultList() throws Exception {
		List<VoteVO>list = sqlsession.selectList("kr.co.edumis.user.vote.dao.voteResult");
		return list;
	}

	public void voteInsert(VoteVO vote) throws Exception{

		sqlsession.insert("kr.co.edumis.user.vote.dao.voteInsert",vote);
		
	}

}
