package kr.co.edumis.user.videoLecture.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public class VideoLectureDAO {
	private SqlSession session = null;

	public VideoLectureDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void lectureRegist(VideoLectureVO lecture) {
		session.insert("videoLecture.dao.LectureMapper.lectureRegist", lecture);
		session.commit();
	}

	public List<VideoLectureVO> lectureList(int startPage, int endPage) {
		Map<String, String> num = new HashMap<String, String>();
		num.put("startPage", startPage + "");
		num.put("endPage", endPage + "");
		return session.selectList("videoLecture.dao.LectureMapper.lectureList", num);
	}

	public VideoLectureVO lectureDetail(int no) {
		return session.selectOne("videoLecture.dao.LectureMapper.lectureDetail", no);
	}

	public int lectureCount() {
		return session.selectOne("videoLecture.dao.LectureMapper.lectureCount");
	}

	public void lectureDelete(int no) {
		session.delete("videoLecture.dao.LectureMapper.lectureDelete",no);
		session.commit();
	}

	public VideoLectureVO lectureSelect(int no) {
		return session.selectOne("videoLecture.dao.LectureMapper.lectureSelect",no);
	}

	public void lectureModify(VideoLectureVO lecture) {
		Map<String, String> lec = new HashMap<String, String>();
		lec.put("title",lecture.getTitle());
		lec.put("contents",lecture.getContents());
		lec.put("video",lecture.getVideo());
		lec.put("no",lecture.getNo()+"");		
		session.update("videoLecture.dao.LectureMapper.lectureModify",lec);
		session.commit();
	}

}
