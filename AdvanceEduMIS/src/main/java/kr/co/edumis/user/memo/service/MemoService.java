package kr.co.edumis.user.memo.service;

import java.util.List;

import kr.co.edumis.user.memo.vo.MemoVO;

public interface MemoService {

	List<MemoVO> getMemoList(String no) throws Exception;

	void insertMemo(MemoVO memo) throws Exception;

	void deleteMemo(String id) throws Exception;

	void updateMemo(MemoVO memo) throws Exception;

}
