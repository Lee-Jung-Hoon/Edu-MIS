package kr.co.edumis.admin.talk.service;

import java.util.List;

import kr.co.edumis.admin.talk.dao.TalkDAO;
import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class TalkServiceImpl implements TalkService {
	private TalkDAO dao;

	public TalkServiceImpl() {
		dao = new TalkDAO();
	}

	public List<TalkVO> selectReList(int no) throws Exception {

		return dao.selectReList(no);
	}
	
	public int selectReCount(int no) throws Exception {
		
		return dao.selectReCount(no);
	}

	public List<MemberVO> selectMemberList(int no) throws Exception {
		System.out.println("service no : " + no);
		return dao.selectMemberList(no);
	}

	public TalkVO selectNo(int no) throws Exception {
		return dao.selectNo(no);
	}

	public void insertTalk(TalkVO talk) throws Exception {
		dao.insertTalk(talk);
	}

	public void updateCheck(int no) throws Exception {
		dao.updateCheck(no);
	}

	public int selectSeq() throws Exception {
		return dao.selectSeq();
	}

	public void insertNewTalk(TalkVO talk) throws Exception {
		dao.insertNewTalk(talk);
	}
	public List<TalkVO> selectReceiveTalkList(int no) throws Exception{
		return dao.selectReceiveTalkList(no);
	}
	
	public List<TalkVO> selectSendTalkList(int no) throws Exception{
		return dao.selectSendTalkList(no);
	}

	public TalkVO selectDetailTalk(int tNo) throws Exception {
		return dao.selectDetailTalk(tNo);
	}
	public void insertSendTalk(TalkVO talk) throws Exception{
		dao.insertSendTalk(talk);
	}
	public void setCheck(int tNo) throws Exception{
		dao.setCheck(tNo);
	}
	
	public List<TalkVO> searchTalk(TalkVO talk)throws Exception{
		return dao.searchTalk(talk);
	}
	public List<TalkVO> searchNameTalk(TalkVO talk) throws Exception{
		return dao.searchNameTalk(talk);
	}
	public List<TalkVO> searchTalk2(TalkVO talk) throws Exception{
		return dao.searchTalk2(talk);
	}
	public List<TalkVO> searchNameTalk2(TalkVO talk) throws Exception {
		return dao.searchNameTalk2(talk);
	}
	
	public List<TalkVO> talkTrash(int no) throws Exception{
		return dao.talkTrash(no);
	}
	
	public void deleteCheckTalk(TalkVO talk) throws Exception{
		dao.deleteCheckTalk(talk);
	}
	public void deleteTalk(int no) throws Exception{
		dao.deleteTalk(no);
	}
	public void realDeleteCheckTalk(int tNo) throws Exception{
		dao.realDeleteCheckTalk(tNo);
	}
	public void reviveCheckTalk(int tNo) throws Exception{
		dao.reviveCheckTalk(tNo);		
	}
}
