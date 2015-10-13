package kr.co.edumis.user.talk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.talk.dao.TalkUserDAO;
import kr.co.edumis.user.talk.vo.TalkUserVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Service
public class TalkUserServiceImpl implements TalkService {

	@Autowired
	private TalkUserDAO dao;
	
	public int selectAdminNo() throws Exception {
		
		return dao.selectAdminNo();
	}

	public List<TalkUserVO> selectReList(int no) throws Exception {

		return dao.selectReList(no);
	}

	
	public int selectReCount(int no) throws Exception {
		return dao.selectReCount(no);
	}
	
	public List<MemberVO> selectMemberList(int no) throws Exception {
		return dao.selectMemberList(no);
	}

	public TalkUserVO selectNo(int no) throws Exception {
		return dao.selectNo(no);
	}

	public void insertTalk(TalkUserVO talk) throws Exception {
		dao.insertTalk(talk);
	}

	public void updateCheck(int no) throws Exception {
		dao.updateCheck(no);
	}

	public int selectSeq() throws Exception {
		return dao.selectSeq();
	}

	public void insertNewTalk(TalkUserVO talk) throws Exception {
		dao.insertNewTalk(talk);
	}
	public List<TalkUserVO> selectReceiveTalkList(int no) throws Exception{
		return dao.selectReceiveTalkList(no);
	}
	
	public List<TalkUserVO> selectSendTalkList(int no) throws Exception{
		return dao.selectSendTalkList(no);
	}

	public TalkUserVO selectDetailTalk(int tNo) throws Exception {
		return dao.selectDetailTalk(tNo);
	}
	public void insertSendTalk(TalkUserVO talk) throws Exception{
		dao.insertSendTalk(talk);
	}
	public void setCheck(int tNo) throws Exception{
		dao.setCheck(tNo);
	}
	
	public List<TalkUserVO> searchTalk(TalkUserVO talk)throws Exception{
		return dao.searchTalk(talk);
	}
	public List<TalkUserVO> searchNameTalk(TalkUserVO talk) throws Exception{
		return dao.searchNameTalk(talk);
	}
	public List<TalkUserVO> searchTalk2(TalkUserVO talk) throws Exception{
		return dao.searchTalk2(talk);
	}
	public List<TalkUserVO> searchNameTalk2(TalkUserVO talk) throws Exception {
		return dao.searchNameTalk2(talk);
	}
	
	public List<TalkUserVO> talkTrash(int no) throws Exception{
		return dao.talkTrash(no);
	}
	
	public void deleteCheckTalk(TalkUserVO talk) throws Exception{
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
