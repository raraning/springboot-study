package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dto.BoardDto;
import web.dto.Criteria;
import web.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		boardMapper.insertBoard(board);
		
	}

	@Override
	public BoardDto selectBoardDatail(int boardIdx) throws Exception {
		//view + 1
		boardMapper.updateHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDatail(boardIdx);
		return board;
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}

	@Override
	public List<BoardDto> selectCriList(Criteria cri) throws Exception {
		return boardMapper.selectCriList(cri);
	}
	
	
}











