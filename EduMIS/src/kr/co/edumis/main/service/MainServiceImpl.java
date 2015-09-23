package kr.co.edumis.main.service;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.dao.MainDAO;

public class MainServiceImpl implements MainService{
	
	private static MainDAO dao;
	
	public MainServiceImpl() {
		dao = new MainDAO();
	}

	@Override
	public AdminAttVO selectDailyAttend() {
		return null;
	}

	@Override
	public ScheduleVO selectDailySchedule() {
		return null;
	}
	
}
