package web.dto;

import lombok.Data;

@Data
public class Criteria {
	
	private int page = 1; //1페이지로 초기화
	private int perPageNum = 2; //한 페이지당 출력 게시물 수
	
	//sql 구문에서 limit 시작변수 , ? 
	public int getPageStart() {
		return (this.page-1)*this.perPageNum;
	}
}
