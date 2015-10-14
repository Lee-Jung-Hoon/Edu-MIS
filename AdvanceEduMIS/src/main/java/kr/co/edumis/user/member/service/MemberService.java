package kr.co.edumis.user.member.service;

import java.util.List;

import kr.co.edumis.user.member.vo.MemberVO;

public interface MemberService {

	public void insertMember(MemberVO member) throws Exception;
	public List<MemberVO> selectMember() ;
	public void resetLeader() ;
	public void updateLeader(MemberVO member) ;
	
}
