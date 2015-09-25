package kr.co.edumis.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

public class MainDAO {

	private static SqlSession session = null;

	public MainDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	// 일일 출석 현황 결과
	public List<String> selectDailyAttend() {
		return session.selectList("main.dao.mainMapper.attendance");
	}

	public List<String> selectDailyAbsent() {
		return session.selectList("main.dao.mainMapper.absent");
	}

	public List<String> selectDailyLate() {
		return session.selectList("main.dao.mainMapper.late");
	}

	public List<BookBoardVO> selectBookBoard() throws Exception {
		return session.selectList("main.dao.mainMapper.selectBookBoard");
	}

	public List<AdminAssVO> selectAssList() {
		return session.selectList("main.dao.mainMapper.selectAssList");
	}

	public List<ExamGradeVO> selectGrade(String id) {
		return session.selectList("main.dao.mainMapper.selectGrade", id);

	}

	public List<VideoLectureVO> selectVideo() {
		return session.selectList("main.dao.mainMapper.selectVideo");
	}

	public List<AdminAttVO> selectAttList(int month) {
		return session.selectList("main.dao.mainMapper.selectAtt", month);
	}

	public List<ScheduleVO> selectSchedule(int month, int day) {
		Map<String, Integer> map = new HashMap<>();
		map.put("month", month);
		map.put("day", day);
		return session.selectList("main.dao.mainMapper.selectSchedule", map);
	}
}
