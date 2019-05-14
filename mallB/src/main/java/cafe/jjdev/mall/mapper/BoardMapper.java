package cafe.jjdev.mall.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Board;

@Mapper
public interface BoardMapper {
	//6개
	public int updateBoard(Board board);
	public int deleteBoard(Board board);
	public Board selectBoard(int boardNo);
	public List<Board> selectBoardList(Map<String, Integer> map);
	public int selectBoardCount();
	public int insertBoard(Board board);
	public String selectBoardPw(int boardNo);
	
}
