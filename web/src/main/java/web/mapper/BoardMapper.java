package web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import web.dto.BoardDto;

@Mapper //메서드명과 xml 파일의 id를 매핑시켜 주는 기능
public interface BoardMapper {

	List<BoardDto> selectBoardList() throws Exception;
}
