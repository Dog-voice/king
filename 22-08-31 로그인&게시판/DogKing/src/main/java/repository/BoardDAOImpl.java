package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
			private SqlSession sql;
			private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);

			private final String NS = "BoardMapper.";   // namespace.id
			
			public BoardDAOImpl() {
				new DatabaseBuilder();
				sql = DatabaseBuilder.getFactroy().openSession();
			}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert >> dao");
		int isUp = sql.insert(NS+"add",bvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("list >> dao");
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectDetail(int bno) {
		log.info("detail >> dao");
		return sql.selectOne(NS+"detail",bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update >> dao");
		int isUp = sql.update(NS+"mod", bvo);
		if(isUp > 0) {
			sql.commit(); 
	}
		return isUp;
}

	public int delete(int bno) {
		log.info("delete >> dao");
		int isUp = sql.delete(NS+"del", bno);
		if(isUp >0 ) {
			sql.commit();
		}
		return isUp;
	}
}

