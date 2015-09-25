package kr.co.edumis.main.service;

import java.util.List;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.dao.MainDAO;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public class MainServiceImpl implements MainService {

	private static MainDAO dao;

	public MainServiceImpl() {
		dao = new MainDAO();
	}

	// 일일 출석현황 결과
	@Override
	public List<String> selectDailyAttend() throws Exception {
		return dao.selectDailyAttend();
	}

	@Override
	public List<String> selectDailyLate() throws Exception {
		return dao.selectDailyLate();
	}

	@Override
	public List<String> selectDailyAbsent() throws Exception {
		return dao.selectDailyAbsent();
	}

	@Override
	public ScheduleVO selectDailySchedule() throws Exception {
		return null;
	}

	@Override
	public List<BookBoardVO> selectBookBoardList() throws Exception {
		return dao.selectBookBoard();
	}

	@Override
	public List<AdminAssVO> selectAssList() throws Exception {
		return dao.selectAssList();
	}

	@Override
	public List<ExamGradeVO> selectGrade(String id) throws Exception {
		return dao.selectGrade(id);
	}

	@Override
	public List<AdminAttVO> getAttList(int month) throws Exception {
		return dao.selectAttList(month);
	}

	@Override
	public List<VideoLectureVO> selectVideo() throws Exception {
		return dao.selectVideo();
	}

	@Override
	public List<ScheduleVO> getScheduleList(int month, int day) throws Exception {
		return dao.selectSchedule(month, day);
	}

}
