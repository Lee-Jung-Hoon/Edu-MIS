package kr.co.edumis.user.videoLecture.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;

public class LecCommentDAO {
	private SqlSession session = null;

	public LecCommentDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void lecCommentRegist(LecCommentVO lecComment) {
		// System.out.println(lecComment);
		session.insert("videoLecture.dao.LectureMapper.lecCommentRegist", lecComment);
		session.commit();
	}

	public List<LecCommentVO> lecCommentList(int no) {
		List<LecCommentVO> list = session.selectList("videoLecture.dao.LectureMapper.lecCommentList", no);
		return list;
	}

	public void lecCommentDelete(int comno) {
		session.delete("videoLecture.dao.LectureMapper.lecCommentDelete", comno);
		session.commit();
	}
}
