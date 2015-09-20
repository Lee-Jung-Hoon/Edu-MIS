package kr.co.edumis.admin.talk.service;

import java.util.List;

import kr.co.edumis.admin.talk.dao.TalkDAO;
import kr.co.edumis.admin.talk.vo.TalkVO;

public class TalkServiceImpl implements TalkService{
	private TalkDAO dao;
	
	public TalkServiceImpl(){
		dao = new TalkDAO();
	}
	
	public List<TalkVO> selectReceiveTalkList(int no) throws Exception{
		return dao.selectReceiveTalkList(no);
	}
	
	public List<TalkVO> selectSendTalkList(int no) throws Exception{
		return dao.selectSendTalkList(no);
	}

	public TalkVO selectDetailTalk(int no) throws Exception {
		return null;
	}

}
