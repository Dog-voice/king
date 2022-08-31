package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.log.Log;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
			private BoardDAO bdao;            // interface 생성 - > repository에 생성
			private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
 
			
			public BoardServiceImpl() {
				bdao = new BoardDAOImpl(); //class 생성 - > repository에 생성
			}

	@Override
	public int register(BoardVO bvo) {
		// service - > dao db처리를 부탁
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
