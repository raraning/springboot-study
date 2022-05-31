package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.dto.BoardDto;
import web.dto.Criteria;
import web.mapper.BoardMapper;
import web.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판목록
	@RequestMapping("/board/list")
	public ModelAndView openlist(Criteria cri) throws Exception{
		
		
		//① 생성자에 값이 존재 한다면 /board/list.html 찾아간다.
		ModelAndView mv = new ModelAndView();

		//② 생성자에 값이 없다면 매핑 값 /board/list.html 찾아간다.
		//ModelAndView mv = new ModelAndView();
		
		//List<BoardDto> list = boardService.selectBoardList(cri);
		List<BoardDto> list = boardService.selectCriList(cri);
		mv.addObject("list",list);
		
		return mv;
		
	}
	
	//게시판 글쓰기
	@GetMapping("/board/write")
	public void openwrite() throws Exception{
		
	}
	
	@PostMapping("/board/write")
	public String openwritePost(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		
		return "redirect:list";
	}
	
	//게시판 상세페이지
	@GetMapping("/board/view")
	public ModelAndView openView(@RequestParam("boardIdx") int boardIdx) throws Exception{
		BoardDto board = boardService.selectBoardDatail(boardIdx);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board",board);
		
		return mv;
	}
	
	//수정
	@PostMapping("/board/modify")
	public String openModifyPost(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		
		return"redirect:list";
	}
	
	//삭제
	@PostMapping("/board/delete")
	public String openDelte(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		
		return"redirect:list";
	}
}























