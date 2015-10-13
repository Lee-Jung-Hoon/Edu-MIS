package kr.co.edumis.admin.talk.service;

import java.util.List;

import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface TalkService {

	public List<TalkVO> selectReList(int no) throws Exception;
	
	public int selectReCount(int no) throws Exception;

	public List<MemberVO> selectMemberList() throws Exception;

	public TalkVO selectNo(int no) throws Exception;

	public void insertTalk(TalkVO talk) throws Exception;

	public void updateCheck(int no) throws Exception;

	public int selectSeq() throws Exception;

	public void insertNewTalk(TalkVO talk) throws Exception;

	public List<TalkVO> selectReceiveTalkList(int no) throws Exception;

	public List<TalkVO> selectSendTalkList(int no) throws Exception;

	public TalkVO selectDetailTalk(int no) throws Exception;

	public void insertSendTalk(TalkVO talk) throws Exception;

	public void setCheck(int tNo) throws Exception;

	public List<TalkVO> searchTalk(TalkVO talk) throws Exception;

	public List<TalkVO> searchNameTalk(TalkVO talk) throws Exception;

	public List<TalkVO> searchTalk2(TalkVO talk) throws Exception;

	public List<TalkVO> searchNameTalk2(TalkVO talk) throws Exception;

	public List<TalkVO> talkTrash(int no) throws Exception;

	public void deleteCheckTalk(TalkVO talk) throws Exception;

	public void deleteTalk(int no) throws Exception;

	public void realDeleteCheckTalk(int tNo) throws Exception;

	public void reviveCheckTalk(int tNo) throws Exception;
}
