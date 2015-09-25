package kr.co.edumis.user.videoLecture.service;

import java.util.List;

import kr.co.edumis.user.videoLecture.dao.VideoLectureDAO;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public class VideoLectureServiceImpl implements VideoLectureService {
	private VideoLectureDAO dao;
	
	public VideoLectureServiceImpl() {
		dao = new VideoLectureDAO();
	}

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
	public void lectureModify(int no, VideoLectureVO lecture) throws Exception {
		dao.lectureModify(no, lecture);
	}


}
