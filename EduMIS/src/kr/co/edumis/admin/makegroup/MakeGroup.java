package kr.co.edumis.admin.makegroup;

import java.util.ArrayList;
import java.util.Random;

public class MakeGroup{

	public static void main(String[] args) {
		
		int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		ArrayList<String> list = new ArrayList<String>();
		for(int i =0;i<num.length;i++){
			list.add(String.valueOf(num[i]));
		}
		
		
		Random ran = new Random();
		int gNum = 9;
		int lnumber = list.size();
		int rest = list.size()%gNum;
		int quota = list.size()/gNum;
		int count = 1;
		int gcount = 0;
		
		System.out.println("몫 : "+quota);
		System.out.println("나머지 : "+rest);
		
		
		
		while(list.size()!=0){
		for(int i =0; i<list.size();i++){
			
//			System.out.println("갯수 : " +list.size());
			int number = ran.nextInt(list.size());
			list.get(number);
			System.out.print(list.get(number)+" ");
			list.remove(number);
			
				
			if((count)%(quota+1)==0&&gcount<rest){
				System.out.println();
				gcount++;
				System.out.println(gcount);
				System.out.println("카운터  : " +count);
				if(gcount==rest) count =0;
				
			}else if((count)%(quota)==0&&gcount>=rest){
				System.out.println();
				System.out.println("카운터  : " +count);
				gcount++;
				System.out.println(gcount);
			}
			
			count++;
			
//			System.out.print("갯수 : " + count+++"\t");
			}
		}

	}
	
	

}
