package kr.co.edumis.main.service;

import java.util.List;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.dao.MainDAO;

public class MainServiceImpl implements MainService{
	
	private static MainDAO dao;
	
	public MainServiceImpl() {
		dao = new MainDAO();
	}

	// 일일 출석현황 결과
	@Override
	public List<String> selectDailyAttend() throws Exception{
		return dao.selectDailyAttend();
	}

	@Override
	public List<String> selectDailyLate() throws Exception{
		return dao.selectDailyLate();
	}
	
	@Override
	public List<String> selectDailyAbsent() throws Exception{
		return dao.selectDailyAbsent();
	}

	@Override
	public ScheduleVO selectDailySchedule() throws Exception {
		return null;
	}
	
}
