package service;

import java.util.List;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
    
	private BoardDAO bdao;	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		System.out.println("check 2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		System.out.println("check 2-2");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		System.out.println("check 3-2");
		return bdao.selectDetail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		System.out.println("check 4-2");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		System.out.println("check 5-2");
		return bdao.delete(bno);

	}

}
