package kr.co.edumis.admin.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.schedule.dao.ScheduleDAO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private  ScheduleDAO dao;
	
	public List<ScheduleVO> infoSchedule(String day) {
		

		return dao.infoSchedule(day);
	}

	
	
}
