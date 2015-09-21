package kr.co.edumis.user.vote.service;

import java.util.List;

import kr.co.edumis.user.vote.dao.VoteDAO;
import kr.co.edumis.user.vote.vo.VoteVO;

public class VoteServiceImpl implements VoteService {

	private VoteDAO dao;
	
	public VoteServiceImpl(){
		dao = new VoteDAO();
	}

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
