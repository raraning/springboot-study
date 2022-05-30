package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.dto.BoardDto;
import web.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping("/board/list")
	public ModelAndView openlist() throws Exception{
		
		
		//① 생성자에 값이 존재 한다면 /board/list.html 찾아간다.
		ModelAndView mv = new ModelAndView();

		//② 생성자에 값이 없다면 매핑 값 /board/list.html 찾아간다.
		//ModelAndView mv = new ModelAndView();
		
		List<BoardDto> list = boardservice.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
		
	}
}
