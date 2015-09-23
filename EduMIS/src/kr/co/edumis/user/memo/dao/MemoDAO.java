package kr.co.edumis.user.memo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.memo.vo.MemoVO;


public class MemoDAO {
	private static SqlSession sqlMapper;

	public MemoDAO() {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<MemoVO> selectMemo(String no) throws Exception{
		return sqlMapper.selectList("Memo.dao.selectMemo",no);
	}
	
	public void insertMemo(MemoVO memo) throws Exception{
		sqlMapper.insert("Memo.dao.insertMemo",memo);
		sqlMapper.commit();		
	}

	public void deleteMemo(String id) {
		MemoVO memo = new MemoVO();
		memo.setMemoNo(Integer.parseInt(id));
		sqlMapper.delete("Memo.dao.deleteMemo", memo);
		sqlMapper.commit();
	}

	public void updateMemo(MemoVO memo) {
		System.out.println(memo);
		
		sqlMapper.update("Memo.dao.updateMemo",memo);
		sqlMapper.commit();
	}
}
