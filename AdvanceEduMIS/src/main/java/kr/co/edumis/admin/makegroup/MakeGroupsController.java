package kr.co.edumis.admin.makegroup;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import kr.co.edumis.user.member.service.MemberService;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/makegroups")
public class MakeGroupsController {
	
	@Autowired
	public MemberService service;

	@RequestMapping("/makecontroller.do")
	public ModelAndView makeController() throws Exception {
	
		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroup");
		
		List<MemberVO> list = service.selectMember();
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			System.out.println(mvo.getName());

		}

		mav.addObject("mlist", list);

		return mav;

	}

	@RequestMapping("/make.do")
	public ModelAndView resultController(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroupsResult");
		int gNum = Integer.parseInt(req.getParameter("gNum"));
		System.out.println(gNum);
		
		service.resetLeader();
		
		for (int i = 1; i <= gNum; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setNo(req.getParameter("leader" + i));
			System.out.println(mvo.getNo());
			if (i <= (gNum / 2)) {
				mvo.setTechLeader("1");
			} else {
				mvo.setTechLeader("2");
			}
			mvo.setTeam("0");
			service.updateLeader(mvo);

		}
		List<MemberVO> list = service.selectMember();
		
		Execute(list, gNum);
		
		mav.addObject("mlist", service.selectMember());
		System.out.println();
		mav.addObject("gNum", gNum);

		return mav;
	}

	@RequestMapping("/result.do")
	public ModelAndView resultShowController() throws Exception {
		System.out.println("확인 : ");
		
		List<MemberVO> list = service.selectMember();
		int temp = 0;
		int team = 0;
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			team = Integer.parseInt(mvo.getTeam());
				
			if (temp < (team)) {
				temp = (team);
			}
		}
		int gNum = temp * 2;
		System.out.println(gNum);
		System.out.println("확인 : "+list.size());

		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroupShow");
		mav.addObject("mlist", list);
		mav.addObject("gNum", gNum);

		return mav;
	}

	@ResponseBody
	@RequestMapping("/remake.json")
	public List<MemberVO> remakeController() throws Exception {
				
		List<MemberVO> list = service.selectMember();
		
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			int team = Integer.parseInt(mvo.getTeam());
			if (temp < team) {
				temp = team;
			}
		}
		int gNum = temp * 2;
		System.out.println(gNum);
		
		
		Execute(list, gNum);

		return service.selectMember();
	}

	@ResponseBody
	@RequestMapping("/ajax.json")
	public List<MemberVO> MakeGroupsAjax() throws Exception {
		
		return service.selectMember();
	}
	
	
	
	
	
	public void Execute(List<MemberVO> list, int gNum) {

		ArrayList<MemberVO> list1 = new ArrayList<MemberVO>();
		ArrayList<MemberVO> list2 = new ArrayList<MemberVO>();
		ArrayList<MemberVO> list3 = new ArrayList<MemberVO>();
		try {
		
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			if (mvo.getTechLeader().equals("1")) {
				list1.add(mvo);

			} else if (mvo.getTechLeader().equals("2")) {
				list2.add(mvo);

			} else if (mvo.getTechLeader().equals("3")) {
				list3.add(mvo);

			}

		}

		Random ran = new Random();

		int rest = list3.size() % gNum;
		int quota = list3.size() / gNum;
//		int gcount = 0;
		int count = 1;
		int count2 = 1;

		System.out.println("몫 : " + quota);
		System.out.println("나머지 : " + rest);

		while (list1.size() != 0) {
		for (int i = 0; i < list1.size(); i++) {
			
			int number = ran.nextInt(list1.size());
			MemberVO mvo = list1.get(number);
			mvo.setTeam((String.valueOf(count++)));		
			System.out.println("조장 이름 : " +mvo.getName()+", 조 : "+mvo.getTeam());
			list1.remove(number);
			
			service.updateLeader(mvo);
			
		}
		
			
		
		for (int i = 0; i < list2.size(); i++) {
			
			int number = ran.nextInt(list2.size());
			MemberVO mvo = list2.get(number);
			mvo.setTeam((String.valueOf(count2++)));	
			System.out.println("부조장 이름 : " +mvo.getName()+", 조 : "+mvo.getTeam());
			list2.remove(number);
			service.updateLeader(mvo);
		}
		
		}
		count = 1;
		while (list3.size() != 0) {
			for (int i = 0; i < list3.size(); i++) {
				int number = ran.nextInt(list3.size());
				MemberVO mvo = list3.get(number);
				mvo.setTeam(String.valueOf(count++));
				System.out.println("이름 : " +mvo.getName()+", 조 : "+mvo.getTeam());
				service.updateLeader(mvo);
				list3.remove(number);
				if(count>(gNum/2)) count =1;
						

				// System.out.print("갯수 : " + count+++"\t");
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
