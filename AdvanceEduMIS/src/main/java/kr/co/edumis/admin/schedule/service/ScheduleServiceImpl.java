package kr.co.edumis.admin.schedule.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.edumis.admin.schedule.dao.ScheduleDAO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private  ScheduleDAO dao;
	
	public List<List<ScheduleVO>> infoSchedule(ScheduleVO scheduleVO) {
		int year = scheduleVO.getYear();
		int month = scheduleVO.getMonth();
		int lastDay = scheduleVO.getLastDay();
		List<List<ScheduleVO>> list = new ArrayList<>();
		for (int date = 1; date <= lastDay; date++) {
			List<ScheduleVO> innerList = dao.infoSchedule(pad(month) + "/" + pad(date) + "/" + year);
			System.out.println(date + " - " + innerList);
			list.add(innerList);
		}
		return list;
	}

	private String pad(int val) {
		return (val < 10) ? "0" + val : String.valueOf(val); 
	}
	
	
}
