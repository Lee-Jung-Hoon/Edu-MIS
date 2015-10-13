package kr.co.edumis.user.main.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userMainDao")
public class MainDAO {
	
	@Autowired
	private SqlSessionTemplate session;

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

	/*
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
	*/
}
