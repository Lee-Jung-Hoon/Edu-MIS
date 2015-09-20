package kr.co.edumis.admin.talk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.common.db.MyAppSqlConfig;

public class TalkDAO {
	private static SqlSession session = null;
	public TalkDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<TalkVO> selectReceiveTalkList(int no) throws Exception{
		return session.selectList("talk.dao.TalkMapper.selectReceiveTalkList", no);
	}
	public List<TalkVO> selectSendTalkList(int no) throws Exception{
		return session.selectList("talk.dao.TalkMapper.selectSendTalkList", no);
	}
}
