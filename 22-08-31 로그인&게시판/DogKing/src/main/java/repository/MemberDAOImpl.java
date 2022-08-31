package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;



import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {

     //DB연결
	private SqlSession sql; // SqlSession import 해주기
	private final String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactroy().openSession();
	}
	@Override
	public int insert(MemberVO mvo) {

		int isUp = sql.insert(NS + "reg", mvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(NS+"login", mvo);
	}
	@Override
	public int updateLogin(String email) {
		int isUp = sql.update(NS+"last", email);
			sql.commit();
		return isUp;
	}
	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(NS+"list");
	}
	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(NS+"detail", email);
	}
	@Override
	public int update(MemberVO mvo) {
		int isUp = sql.update(NS+"mod",mvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public int delete(String email) {
		int isUp = sql.delete(NS+"del", email);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
		
	}
	

}
