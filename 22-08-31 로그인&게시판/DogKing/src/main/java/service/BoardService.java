package service;


import domain.BoardVO;
import java.util.List;

public interface BoardService {

	int register(BoardVO bvo); // bvo로 변경

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	int remove(int bnot);

	

}
