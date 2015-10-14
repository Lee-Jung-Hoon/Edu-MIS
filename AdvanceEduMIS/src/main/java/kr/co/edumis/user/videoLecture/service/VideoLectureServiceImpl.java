package kr.co.edumis.user.videoLecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.videoLecture.dao.VideoLectureDAO;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

@Service
public class VideoLectureServiceImpl implements VideoLectureService {
	@Autowired
	private VideoLectureDAO dao;

	@Override
	public void lectureRegist(VideoLectureVO lecture) {
		dao.lectureRegist(lecture);
	}

	@Override
	public List<VideoLectureVO> lectureList(int startPage, int endPage) {
		List<VideoLectureVO> list = dao.lectureList(startPage, endPage);
		return list;
	}

	@Override
	public VideoLectureVO lectureDetail(int no) {
		return dao.lectureDetail(no);
	}

	@Override
	public int lectureCount() throws Exception {
		return dao.lectureCount();
	}

	@Override
	public void lectureDelete(int no) throws Exception {
		dao.lectureDelete(no);
	}

	@Override
	public VideoLectureVO lectureSelect(int no) throws Exception {
		return dao.lectureSelect(no);
	}

	@Override
	public void lectureModify(VideoLectureVO lecture) throws Exception {
		dao.lectureModify(lecture);
	}
	
	@Override
	public void lecCommentRegist(LecCommentVO lecComment) {
		dao.lecCommentRegist(lecComment);
	}

	@Override
	public List<LecCommentVO> lecCommentList(int no) throws Exception {
		List<LecCommentVO> list = dao.lecCommentList(no);
		return list;
	}

	@Override
	public void lecCommentDelete(int comno) throws Exception {
		dao.lecCommentDelete(comno);

	}


}
