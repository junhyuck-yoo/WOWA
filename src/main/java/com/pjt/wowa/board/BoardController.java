package com.pjt.wowa.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjt.wowa.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping("/todo")
	public String todo(Model model, HttpSession session) {
		String userName = (String)session.getAttribute("login");
		Integer m_no = (Integer) session.getAttribute("m_no");
		model.addAttribute("m_no", m_no);
		model.addAttribute("user", userName);
		return "board/todo";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public int insert(BoardVO boardvo, HttpSession session) throws Exception {
		Integer m_no = (Integer) session.getAttribute("m_no");
		logger.info("to insert Controller!");
		//logger.info(BoardVO.toString());
		boardvo.setM_no(m_no);
		return service.create(boardvo);
	}
	
	@RequestMapping("/listJson")
	@ResponseBody
	public List<BoardVO>listJson(@RequestParam int m_no) throws Exception {
		logger.info("listjson!!!");
		List<BoardVO>list = service.list(m_no);
		
		return list;
	}
	
	@RequestMapping("/tododelete")
	@ResponseBody
	public void delete(@RequestParam int td_no) throws Exception {
		logger.info("delete list item");
		service.delete(td_no);
	}
}
