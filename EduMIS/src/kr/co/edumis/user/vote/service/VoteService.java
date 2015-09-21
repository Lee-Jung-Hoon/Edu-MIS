package kr.co.edumis.user.vote.service;

import java.util.List;

import kr.co.edumis.user.vote.vo.VoteVO;

public interface VoteService {
	
	public List<VoteVO> getList() throws Exception;

	public List<VoteVO> getResult() throws Exception;

	public void voteInsert(VoteVO vote) throws Exception;
	
}
