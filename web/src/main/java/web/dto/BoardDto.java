package web.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data //set,get,toString 자동처리 (lombok)
public class BoardDto {
	
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private LocalDateTime createdDatetime;
	private String updateId;
	private LocalDateTime updatedDatetime;
}
