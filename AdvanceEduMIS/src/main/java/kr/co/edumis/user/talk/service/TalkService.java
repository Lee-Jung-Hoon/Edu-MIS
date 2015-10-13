package kr.co.edumis.user.talk.service;

import java.util.List;

import kr.co.edumis.user.talk.vo.TalkUserVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface TalkService {

	public int selectAdminNo() throws Exception;
	
	public List<TalkUserVO> selectReList(int no) throws Exception;

	public int selectReCount(int no) throws Exception;
	
	public List<MemberVO> selectMemberList(int no) throws Exception;

	public TalkUserVO selectNo(int no) throws Exception;

	public void insertTalk(TalkUserVO talk) throws Exception;

	public void updateCheck(int no) throws Exception;

	public int selectSeq() throws Exception;

	public void insertNewTalk(TalkUserVO talk) throws Exception;

	public List<TalkUserVO> selectReceiveTalkList(int no) throws Exception;

	public List<TalkUserVO> selectSendTalkList(int no) throws Exception;

	public TalkUserVO selectDetailTalk(int no) throws Exception;

	public void insertSendTalk(TalkUserVO talk) throws Exception;

	public void setCheck(int tNo) throws Exception;

	public List<TalkUserVO> searchTalk(TalkUserVO talk) throws Exception;

	public List<TalkUserVO> searchNameTalk(TalkUserVO talk) throws Exception;

	public List<TalkUserVO> searchTalk2(TalkUserVO talk) throws Exception;

	public List<TalkUserVO> searchNameTalk2(TalkUserVO talk) throws Exception;

	public List<TalkUserVO> talkTrash(int no) throws Exception;

	public void deleteCheckTalk(TalkUserVO talk) throws Exception;

	public void deleteTalk(int no) throws Exception;

	public void realDeleteCheckTalk(int tNo) throws Exception;

	public void reviveCheckTalk(int tNo) throws Exception;
}
