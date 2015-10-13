package kr.co.edumis.user.main.service;

import java.util.List;

public interface MainService {

	public List<String> selectDailyAttend() throws Exception;

	public List<String> selectDailyLate() throws Exception;

	public List<String> selectDailyAbsent() throws Exception;

	/*
	public ScheduleVO selectDailySchedule() throws Exception;

	public List<BookBoardVO> selectBookBoardList() throws Exception;

	public List<AdminAssVO> selectAssList() throws Exception;

	public List<ExamGradeVO> selectGrade(String id) throws Exception;

	public List<AdminAttVO> getAttList(int month) throws Exception;

	public List<VideoLectureVO> selectVideo() throws Exception;

	public List<ScheduleVO> getScheduleList(int month, int day) throws Exception;
	 */
}
