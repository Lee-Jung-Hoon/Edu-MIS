package kr.co.edumis.admin.schedule.service;

import java.util.List;

import kr.co.edumis.admin.schedule.dao.ScheduleDAO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDAO dao;
	
	public ScheduleServiceImpl(){
		dao = new ScheduleDAO();
	}
	@Override
	public void registSchedule(ScheduleVO schedule) throws Exception {
		dao.registSchedule(schedule);
	}
	@Override
	public List<ScheduleVO> listSchedule(ScheduleVO schedule) throws Exception {
		return dao.listSchedule(schedule);
	}
	@Override
	public ScheduleVO detailSchedule(ScheduleVO schedule) throws Exception {
		return dao.detailSchedule(schedule);
	}
	public void modifySchedule(ScheduleVO schedule) {
		dao.modifySchedule(schedule);
	}
	@Override
	public void delSchedule(ScheduleVO schedule) throws Exception {
		dao.delSchedule(schedule);
	}
	
	
	
}
