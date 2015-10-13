package kr.co.edumis.user.talk.dao;

import java.util.List;

import kr.co.edumis.user.member.vo.MemberVO;
import kr.co.edumis.user.talk.vo.TalkUserVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TalkUserDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int selectAdminNo() {
		return session.selectOne("user.talk.dao.TalkMapper.getAdminNo");
	}

	public List<TalkUserVO> selectReList(int no) {
		return session.selectList("user.talk.dao.TalkMapper.getReceiveList", no);
	}
	
	public int selectReCount(int no) {
		System.out.println("no --- ");
		return session.selectOne("user.talk.dao.TalkMapper.getReceiveCount", no);
	}
	
	public List<MemberVO> selectMemberList(int no) {
		return session.selectList("user.talk.dao.TalkMapper.getMember", no);
	}
	
	public TalkUserVO selectNo(int no) {
		return session.selectOne("user.talk.dao.TalkMapper.getNo", no);
	}
	
	public void insertTalk(TalkUserVO talk) {
		session.insert("user.talk.dao.TalkMapper.registTalk", talk);
	}
	
	public void updateCheck(int no) {
		session.update("user.talk.dao.TalkMapper.setCheck", no);
	}
	
	public int selectSeq() {
		return session.selectOne("user.talk.dao.TalkMapper.getSeq");
	}
	
	public void insertNewTalk(TalkUserVO talk) {
		session.insert("user.talk.dao.TalkMapper.registNewTalk", talk);
	}
	
	public List<TalkUserVO> selectReceiveTalkList(int no) throws Exception{
		return session.selectList("user.talk.dao.TalkMapper.selectReceiveTalkList", no);
	}

	public List<TalkUserVO> selectSendTalkList(int no) throws Exception{
		return session.selectList("user.talk.dao.TalkMapper.selectSendTalkList", no);
	}
	
	public TalkUserVO selectDetailTalk(int tNo) throws Exception{
		return session.selectOne("user.talk.dao.TalkMapper.selectDetailTalk", tNo);
		
	}
	public void insertSendTalk(TalkUserVO talk) throws Exception{
		session.insert("user.talk.dao.TalkMapper.insertSendTalk", talk);
	}

	public void setCheck(int tNo) throws Exception{
		session.update("user.talk.dao.TalkMapper.changeCheck", tNo);
	}

	public List<TalkUserVO> searchTalk(TalkUserVO talk) throws Exception {
		return session.selectList("user.talk.dao.TalkMapper.searchTalk", talk);
	}
	public List<TalkUserVO> searchNameTalk(TalkUserVO talk) throws Exception {
		return session.selectList("user.talk.dao.TalkMapper.searchNameTalk", talk);
	}

	public List<TalkUserVO> searchTalk2(TalkUserVO talk) throws Exception {
		return session.selectList("user.talk.dao.TalkMapper.searchTalk2", talk);
	}
	public List<TalkUserVO> searchNameTalk2(TalkUserVO talk) throws Exception {
		return session.selectList("user.talk.dao.TalkMapper.searchNameTalk2", talk);
	}
	
	public List<TalkUserVO> talkTrash(int no) throws Exception{
		return session.selectList("user.talk.dao.TalkMapper.talkTrash", no);
	}

	public void deleteCheckTalk(TalkUserVO talk) throws Exception{
		session.update("user.talk.dao.TalkMapper.deleteCheckTalk", talk);
	}

	public void deleteTalk(int no) {
		session.update("user.talk.dao.TalkMapper.deleteTalk", no);
	}

	public void realDeleteCheckTalk(int tNo) {
		session.update("user.talk.dao.TalkMapper.realDeleteCheckTalk", tNo);
	}

	public void reviveCheckTalk(int tNo) {
		session.update("user.talk.dao.TalkMapper.reviveCheckTalk", tNo);
	}
}
