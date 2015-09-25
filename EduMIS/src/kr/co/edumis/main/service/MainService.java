package kr.co.edumis.main.service;

import java.util.List;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public interface MainService {

	public ScheduleVO selectDailySchedule() throws Exception;

	public List<String> selectDailyAttend() throws Exception;

	public List<String> selectDailyLate() throws Exception;

	public List<String> selectDailyAbsent() throws Exception;

	public List<BookBoardVO> selectBookBoardList() throws Exception;

	public List<AdminAssVO> selectAssList() throws Exception;

	public List<ExamGradeVO> selectGrade(String id) throws Exception;

	public List<AdminAttVO> getAttList(int month) throws Exception;

	public List<VideoLectureVO> selectVideo() throws Exception;

	public List<ScheduleVO> getScheduleList(int month, int day) throws Exception;

}
