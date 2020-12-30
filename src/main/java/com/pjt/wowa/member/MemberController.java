package com.pjt.wowa.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjt.wowa.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getlogin(MemberVO vo, Model model, HttpSession session, HttpServletResponse response) throws Exception {
		logger.info("to login");
		
		if(session.getAttribute("login") != null) {
			logger.info("reset session");
			session.removeAttribute("login");
			model.addAttribute("user", "");
		}
		
		MemberVO login = service.login(vo);
		
		if(login != null) {
			logger.info("dldldld");
			session.setAttribute("login", login.getName());
			session.setAttribute("m_no", login.getM_no());
			model.addAttribute("user", login.getName());
		}else {
			return "home";
		}
		return "mypage";
	}
	
}
