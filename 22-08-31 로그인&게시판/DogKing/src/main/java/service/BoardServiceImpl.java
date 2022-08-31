package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.log.Log;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
			private BoardDAO bdao;        
			private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
 
			
			public BoardServiceImpl() {
				bdao = new BoardDAOImpl();
			}

	@Override
	public int register(BoardVO bvo) {
		log.info("insert >> service");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO>  getList() {
		log.info("list >> service");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail << service");
		return bdao.selectDetail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("update >> service");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info("delet >> service");
		return bdao.delete(bno);
	}

	

}
