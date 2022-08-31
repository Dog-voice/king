package service;



import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo); 

	MemberVO login(MemberVO mvo); 

	int lastLogin(String email); 

	List<MemberVO> getList();

	MemberVO getDetail(String email); 

	int modify(MemberVO mvo);

	int remove(String email);

	

	

}
