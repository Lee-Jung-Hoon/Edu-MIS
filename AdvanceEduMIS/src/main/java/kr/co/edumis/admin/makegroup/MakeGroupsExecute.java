package kr.co.edumis.admin.makegroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

public class MakeGroupsExecute {

	public void Execute(List<MemberVO> list, int gNum) {

		ArrayList<MemberVO> list1 = new ArrayList<MemberVO>();
		ArrayList<MemberVO> list2 = new ArrayList<MemberVO>();
		ArrayList<MemberVO> list3 = new ArrayList<MemberVO>();
		try {
		MemberDAO mda = new MemberDAO();
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
			
				mda.updateLeader(mvo);
			
		}
		
			
		
		for (int i = 0; i < list2.size(); i++) {
			
			int number = ran.nextInt(list2.size());
			MemberVO mvo = list2.get(number);
			mvo.setTeam((String.valueOf(count2++)));	
			System.out.println("부조장 이름 : " +mvo.getName()+", 조 : "+mvo.getTeam());
			list2.remove(number);
			mda.updateLeader(mvo);
		}
		
		}
		count = 1;
		while (list3.size() != 0) {
			for (int i = 0; i < list3.size(); i++) {
				int number = ran.nextInt(list3.size());
				MemberVO mvo = list3.get(number);
				mvo.setTeam(String.valueOf(count++));
				System.out.println("이름 : " +mvo.getName()+", 조 : "+mvo.getTeam());
				mda.updateLeader(mvo);
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
