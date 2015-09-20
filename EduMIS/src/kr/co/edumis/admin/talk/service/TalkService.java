package kr.co.edumis.admin.talk.service;

import java.util.List;

import kr.co.edumis.admin.talk.vo.TalkVO;

public interface TalkService {

	public List<TalkVO> selectReceiveTalkList(int no) throws Exception;
	
	public List<TalkVO> selectSendTalkList(int no) throws Exception;

	public TalkVO selectDetailTalk(int no) throws Exception;
}
