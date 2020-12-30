package com.pjt.wowa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echo/*")
public class EchoController {
	private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

	@RequestMapping("/WebSocket-echo")
	public String Chating(Model model,HttpSession session, HttpServletRequest request) {
		String userName = (String)session.getAttribute("login");
		model.addAttribute("user", userName);
		logger.info("is  " + userName);
		
		
		return "echo/WebSocket-echo";
	}
}
