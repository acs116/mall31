package cafe.jjdev.mall.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardFile;

@Mapper
public interface BoardFileMapper {
	public int insertBoardFile(BoardFile boardFile);
	public BoardFile selectBoardFileByFK(int boardNo);
	public int deleteBoardFile(int boardNo);
	
}
