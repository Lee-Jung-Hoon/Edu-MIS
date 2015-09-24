package kr.co.edumis.user.videoLecture.service;

import java.util.List;

import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public interface VideoLectureService {

	void lectureRegist(VideoLectureVO lecture) throws Exception;

	List<VideoLectureVO> lectureList(int startPage, int endPage) throws Exception;

	VideoLectureVO lectureDetail(int no) throws Exception;

	int lectureCount() throws Exception;


}
