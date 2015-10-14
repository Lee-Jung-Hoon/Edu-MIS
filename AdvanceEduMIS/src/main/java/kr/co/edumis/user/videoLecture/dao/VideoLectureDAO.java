package kr.co.edumis.user.videoLecture.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.user.videoLecture.vo.LecCommentVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

@Repository
public class VideoLectureDAO {
	@Autowired
	private SqlSessionTemplate session;

	public void lectureRegist(VideoLectureVO lecture) {
		session.insert("videoLecture.dao.LectureMapper.lectureRegist", lecture);
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
	}
	
	public void lecCommentRegist(LecCommentVO lecComment) {
		session.insert("videoLecture.dao.LectureMapper.lecCommentRegist", lecComment);
	}

	public List<LecCommentVO> lecCommentList(int no) {
		List<LecCommentVO> list = session.selectList("videoLecture.dao.LectureMapper.lecCommentList", no);
		return list;
	}

	public void lecCommentDelete(int comno) {
		session.delete("videoLecture.dao.LectureMapper.lecCommentDelete", comno);
	}

}
