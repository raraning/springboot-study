package web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import web.dto.BoardDto;
import web.dto.Criteria;

@Mapper //메서드명과 xml 파일의 id를 매핑시켜 주는 기능
public interface BoardMapper {

	List<BoardDto> selectBoardList() throws Exception; //목록
	void insertBoard(BoardDto board) throws Exception; //글쓰기
	BoardDto selectBoardDatail(int boardIdx) throws Exception; //상세페이지
	void updateHitCount(int boardIdx) throws Exception; //조회수 + 1
	void updateBoard(BoardDto board) throws Exception; //수정
	void deleteBoard(int boardIdx) throws Exception; //삭제
	List<BoardDto> selectCriList(Criteria cri) throws Exception; //목록
}
