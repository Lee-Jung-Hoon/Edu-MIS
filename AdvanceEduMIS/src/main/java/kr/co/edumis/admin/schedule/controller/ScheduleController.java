package kr.co.edumis.admin.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.edumis.admin.schedule.service.ScheduleService;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;



@Controller
@RequestMapping("/admin/schedule")
public class ScheduleController {
	
	
	
	@Autowired
	private ScheduleService service;
	
	@RequestMapping("/info.json")
	@ResponseBody
	public List<List<ScheduleVO>> info(ScheduleVO scheduleVO) throws Exception{
		return service.infoSchedule(scheduleVO);
	};
	
	
	@RequestMapping("/listInfo.json")
	@ResponseBody
	public List<ScheduleVO> listInfo(@RequestParam(value="day" , required=false) String day) throws Exception{
		System.out.println("day : " + day);
		return service.listInfoSchedule(day);
	};
	
	
	
}


