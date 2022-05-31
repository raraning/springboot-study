package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@GetMapping("/")
	public ModelAndView openindex() throws Exception{
		
		ModelAndView mv = new ModelAndView("/index");
		
		return mv;
	}
}
