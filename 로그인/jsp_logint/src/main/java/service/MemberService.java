package service;


import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	List<MemberVO> getList();

	MemberVO login(MemberVO mvo);
	
	MemberVO getDetail(String id);

	int modify(MemberVO mvo);

	int remove(String id);

	
	




	

	



	
	
	

}
