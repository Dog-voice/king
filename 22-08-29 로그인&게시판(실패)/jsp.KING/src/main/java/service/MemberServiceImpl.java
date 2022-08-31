package service;

import java.util.List;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao; 
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();      
	}

	@Override
	public int register(MemberVO mvo) { 
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO login(MemberVO mvo) { 
		
		return mdao.selectOne(mvo);
	}
	
	@Override
	public MemberVO getDetail(String id) {
		return mdao.detail(id);
	}
	
	@Override

	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		
		return mdao.delete(id);
	}

	

	


}
