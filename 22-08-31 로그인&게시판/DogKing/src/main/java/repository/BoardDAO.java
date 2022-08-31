package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO selectDetail(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

}
