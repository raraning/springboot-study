package web.service;

import java.util.List;

import web.dto.BoardDto;
import web.dto.Criteria;

public interface BoardService {
	
	List<BoardDto> selectBoardList() throws Exception; //목록
	void insertBoard(BoardDto board) throws Exception; //글쓰기
	BoardDto selectBoardDatail(int boardIdx) throws Exception; //상세페이지
	void updateBoard(BoardDto board) throws Exception; //수정
	void deleteBoard(int boardIdx) throws Exception; //삭제
	List<BoardDto> selectCriList(Criteria cri) throws Exception; //목록
	
}
