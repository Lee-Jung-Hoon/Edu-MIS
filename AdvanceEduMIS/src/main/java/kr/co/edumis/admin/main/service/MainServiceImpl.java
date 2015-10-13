package kr.co.edumis.admin.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.admin.main.dao.MainDAO;

@Service("adminMainService")
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO dao;

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

	/*
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
	*/
}
