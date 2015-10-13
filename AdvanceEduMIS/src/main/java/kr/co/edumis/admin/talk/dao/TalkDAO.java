package kr.co.edumis.admin.talk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Repository
public class TalkDAO {
	
	@Autowired
	private SqlSessionTemplate session;

	public List<TalkVO> selectReList(int no) {
		return session.selectList("talk.dao.TalkMapper.getReceiveList", no);
	}
	
	public List<MemberVO> selectMemberList() {
		return session.selectList("talk.dao.TalkMapper.getMember");
	}
	
	public TalkVO selectNo(int no) {
		return session.selectOne("talk.dao.TalkMapper.getNo", no);
	}
	
	public void insertTalk(TalkVO talk) {
		session.insert("talk.dao.TalkMapper.registTalk", talk);
	}
	
	public void updateCheck(int no) {
		session.update("talk.dao.TalkMapper.setCheck", no);
	}
	
	public int selectSeq() {
		return session.selectOne("talk.dao.TalkMapper.getSeq");
	}
	
	public void insertNewTalk(TalkVO talk) {
		session.insert("talk.dao.TalkMapper.registNewTalk", talk);
	}
	
	public List<TalkVO> selectReceiveTalkList(int no) throws Exception{
		return session.selectList("talk.dao.TalkMapper.selectReceiveTalkList", no);
	}

	public List<TalkVO> selectSendTalkList(int no) throws Exception{
		return session.selectList("talk.dao.TalkMapper.selectSendTalkList", no);
	}
	
	public TalkVO selectDetailTalk(int tNo) throws Exception{
		return session.selectOne("talk.dao.TalkMapper.selectDetailTalk", tNo);
		
	}
	public void insertSendTalk(TalkVO talk) throws Exception{
		session.insert("talk.dao.TalkMapper.insertSendTalk", talk);
	}

	public void setCheck(int tNo) throws Exception{
		session.update("talk.dao.TalkMapper.changeCheck", tNo);
	}

	public List<TalkVO> searchTalk(TalkVO talk) throws Exception {
		return session.selectList("talk.dao.TalkMapper.searchTalk", talk);
	}
	public List<TalkVO> searchNameTalk(TalkVO talk) throws Exception {
		return session.selectList("talk.dao.TalkMapper.searchNameTalk", talk);
	}

	public List<TalkVO> searchTalk2(TalkVO talk) throws Exception {
		return session.selectList("talk.dao.TalkMapper.searchTalk2", talk);
	}
	public List<TalkVO> searchNameTalk2(TalkVO talk) throws Exception {
		return session.selectList("talk.dao.TalkMapper.searchNameTalk2", talk);
	}
	
	public List<TalkVO> talkTrash(int no) throws Exception{
		return session.selectList("talk.dao.TalkMapper.talkTrash", no);
	}

	public void deleteCheckTalk(TalkVO talk) throws Exception{
		session.update("talk.dao.TalkMapper.deleteCheckTalk", talk);
	}

	public void deleteTalk(int no) {
		session.update("talk.dao.TalkMapper.deleteTalk", no);
	}

	public void realDeleteCheckTalk(int tNo) {
		session.update("talk.dao.TalkMapper.realDeleteCheckTalk", tNo);
	}

	public void reviveCheckTalk(int tNo) {
		session.update("talk.dao.TalkMapper.reviveCheckTalk", tNo);
	}
}
