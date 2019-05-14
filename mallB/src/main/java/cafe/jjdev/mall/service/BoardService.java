package cafe.jjdev.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.mapper.BoardCommentMapper;
import cafe.jjdev.mall.mapper.BoardFileMapper;
import cafe.jjdev.mall.mapper.BoardMapper;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardFile;
import cafe.jjdev.mall.vo.BoardRequest;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private BoardCommentMapper boardCommentMapper;
	// void 를 써도 되는데 int를 쓰는 이유는 컨트롤러에서 int를 사용하기위해 쓴다
	@Autowired
	private BoardFileMapper boardFileMapper;
	
	
	public Map<String, Object> getBoardList(int currentPage){
		//요청 가공
		final int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rowPerPage",ROW_PER_PAGE);
		map.put("beginRow", beginRow);
		 
		
		List<Board> list = boardMapper.selectBoardList(map);
		int boardCount = boardMapper.selectBoardCount();
		int lastPage = boardCount/ROW_PER_PAGE;
		if(boardCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		//매퍼한테 받아온 리턴값도 하나로 가공/ 모델값 가공
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("boardCount", boardCount);
		return returnMap;		
	}
	public int modifyBoard(Board board) {
		return boardMapper.updateBoard(board);		
	}
	public void addBoard(BoardRequest boardRequest, String path) {
		//1. BoardRequest -> Board
		
			
		
		Board board = new Board();
		
		board.setBoardNo(boardRequest.getBoardNo());
		System.out.println(boardRequest.getBoardNo());		
		board.setBoardPw(boardRequest.getBoardPw());
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		board.setBoardUser(boardRequest.getBoardUser());
		board.setBoardDate(boardRequest.getBoardDate());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!" + board);
		
		boardMapper.insertBoard(board); // board.setBoardNo(ai값);
		
		
		// 2. BoardRequest -> MultipartFile -> BoardFile
		
		
		
		MultipartFile multipartFile = boardRequest.getBoardFile();
		if(multipartFile.getSize() != 0) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!" + multipartFile);
	
		String originalFileName = multipartFile.getOriginalFilename();
		int i = originalFileName.lastIndexOf(".");
		System.out.println(i);
		String originName = originalFileName.substring(0, i);
		String ext = originalFileName.substring(i+1).toLowerCase();

		UUID uuid = UUID.randomUUID();
		String savaName = uuid.toString().replace("-", "");
		
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardNo(board.getBoardNo());
		System.out.println(board.getBoardNo());
		boardFile.setBoardFileSize(multipartFile.getSize());
		boardFile.setBoardFileType(multipartFile.getContentType());
		boardFile.setBoardFileOriginName(originName);
		boardFile.setBoardFileSaveName(savaName);
		boardFile.setBoardFileExt(ext);
		//boardFile.setBoardNo(board.getBoardNo());
		System.out.println(boardFile);
		// 3. 폴더에 저장
		// c:/temp c:\\temp  \\ -> /
		File file = new File(path+"/"+savaName+"."+ext);
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		// Runtime 중요      자바에서 예외는 예외에관련 찾기 예외와에러	        일반예외와 런타임익셉션	
		
		boardFileMapper.insertBoardFile(boardFile);
		}
		
	}
	public void removeBoard(Board board) {		
		
		
		String result = boardMapper.selectBoardPw(board.getBoardNo());
		System.out.println(result);
		BoardFile boardFile = boardFileMapper.selectBoardFileByFK(board.getBoardNo());
		System.out.println(boardFile);
		if(result.equals(board.getBoardPw())) {		
			boardCommentMapper.deleteBoardComment(board.getBoardNo());
			if(boardFile != null) {
				String path = PathStr.UPLOAD_PATH;
				String saveName = boardFile.getBoardFileSaveName();
				String ext = boardFile.getBoardFileExt();
				
				File file = new File(path+"/"+saveName+"."+ext);
				file.delete();
				boardFileMapper.deleteBoardFile(board.getBoardNo());
			}			
			boardMapper.deleteBoard(board);
		}
		
		
	}
	
	public Map<String, Object> getBoardAndCommentList(int boardNo) {
			Board board = boardMapper.selectBoard(boardNo);
			List<BoardComment> boardCommentList = boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
			
			BoardFile boardFile = boardFileMapper.selectBoardFileByFK(boardNo);
			System.out.println(boardNo);
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("board", board);
			map.put("boardCommentList", boardCommentList);
			
			map.put("boardFile", boardFile);
			System.out.println(boardFile);
			return map;
		/*
		 * Board board = boardMapper.selectBoard(boardNo); List<BoardComment>
		 * boardCommentList =
		 * boardCommentMapper.selectBoardCommentListByBoardNo(boardNo); Map<String,
		 * Object> map = new HashMap<String, Object>(); map.put("board", board);
		 * map.put("boardCommentList", boardCommentList); return map;
		 */
	}
	public Board getBoard(int boardNo) {
		return boardMapper.selectBoard(boardNo);
	}
}
