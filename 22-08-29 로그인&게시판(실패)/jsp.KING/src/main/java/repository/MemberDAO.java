package repository;

import java.util.List;

import domain.MemberVO;


public interface MemberDAO {

	int insert(MemberVO mvo);

	List<MemberVO> selectList();

	MemberVO selectOne(MemberVO mvo);   // mvo로 변경해준것
	
	MemberVO detail(String id);

	int update(MemberVO mvo);

	int delete(String id);

}
