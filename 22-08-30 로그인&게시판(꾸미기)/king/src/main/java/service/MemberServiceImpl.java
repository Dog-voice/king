package service;





import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class); // input 다 해주기
	private MemberDAO mdao; // repository에 MemberDAO 저장
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();  //repository에 MemberDAOImpl 저장
	}

	@Override
	public int register(MemberVO mvo) {  
		log.info(">>> register > {service}");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info(">>> login > {service}");
		return mdao.selectOne(mvo);
	}

	@Override
	public int lastLogin(String email) {
		log.info(">>> lastLogin > {service}");
		return mdao.updateLogin(email);
	}

	@Override
	public List<MemberVO> getList() {
		log.info(">>> list > {service}");
		return mdao.selectList();
	}

	@Override
	public MemberVO getDetail(String email) {
		log.info(">>> detail > {service}");
		return mdao.selectOne(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info(">>> modify > {service}");
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		log.info(">>> - > {service}");
		return mdao.delete(email);
	}

}
