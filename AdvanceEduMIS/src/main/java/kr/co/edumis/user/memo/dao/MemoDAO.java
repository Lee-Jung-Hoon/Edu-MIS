package kr.co.edumis.user.memo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.memo.vo.MemoVO;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<MemoVO> selectMemo(String no) throws Exception{
		return session.selectList("Memo.dao.selectMemo",no);
	}
	
	public void insertMemo(MemoVO memo) throws Exception{
		session.insert("Memo.dao.insertMemo",memo);
	}

	public void deleteMemo(String memoNo) {
		session.delete("Memo.dao.deleteMemo", memoNo);
		
	}

	public void updateMemo(MemoVO memo) {
		session.update("Memo.dao.updateMemo",memo);
	}

	public int selectMemoNo() {
		return session.selectOne("Memo.dao.selectMemoNo");
	}
}
