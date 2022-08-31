package service;



import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo); // mvo로 바꿔주기

	MemberVO login(MemberVO mvo); //mvo로 바꿔주기

	int lastLogin(String email); // email로 바꿔주기

	List<MemberVO> getList(); //MemberVO로 바꿔주기

	MemberVO getDetail(String email); // MemberVO객체로 변경 및 email로 변경하기

	int modify(MemberVO mvo);

	int remove(String email);

	

	

}
