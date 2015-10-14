package kr.co.edumis.user.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.vote.dao.VoteDAO;
import kr.co.edumis.user.vote.vo.VoteVO;


@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDAO dao;
	

	@Override
	public List<VoteVO> getList() throws Exception {
			
		List<VoteVO> list = dao.selectList();
			return list;
			
	}

	@Override
	public List<VoteVO> getResult() throws Exception {
		List<VoteVO> list = dao.ResultList();
		return list;
	}

	@Override
	public void voteInsert(VoteVO vote) throws Exception {
		
		dao.voteInsert(vote);
		
	}
	
	
}
