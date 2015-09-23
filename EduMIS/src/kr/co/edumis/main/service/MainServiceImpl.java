package kr.co.edumis.main.service;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.dao.MainDAO;
import kr.co.edumis.main.vo.MainAdminAttVO;

public class MainServiceImpl implements MainService{
	
	private static MainDAO dao;
	
	public MainServiceImpl() {
		dao = new MainDAO();
	}

	@Override
	public MainAdminAttVO selectDailyAttend() throws Exception{
		return null;
	}

	@Override
	public ScheduleVO selectDailySchedule() throws Exception{
		return null;
	}
	
}
