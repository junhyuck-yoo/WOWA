package com.pjt.wowa.crawling;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/crawling/*")
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);

	@RequestMapping("/wepcrawling")
	public String WepCrawling(Model model, HttpSession session) throws IOException {
		
		String userName = (String)session.getAttribute("login");
		Date today = new Date();		
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		model.addAttribute("user", userName);
		model.addAttribute("year", year.format(today));
		model.addAttribute("month", month.format(today));
		logger.info("crawling!!!!");
		String URL = "https://www.ygfamily.com/artist/Schedule.asp?LANGDIV=K&ATYPE=2&ARTIDX=53&intYear="+year.format(today)+"&intMonth="+month.format(today);

		try {
			Document doc = Jsoup.connect(URL).get();
			//System.out.println(doc.html());
			//System.out.println("===========================================================================");
			doc.select("img").remove();
			Elements elem = doc.select("table#scheduleChart");
			
			model.addAttribute("scheduleChart", elem);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "crawling/wepcrawling";

	}
	
	@RequestMapping("/changedate")
	public String ChangDate(@RequestParam("year")int year, @RequestParam("month")int month, HttpSession session, Model model) throws Exception {
		logger.info("ChangDate");
		
		String userName = (String)session.getAttribute("login");
		model.addAttribute("user", userName);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		String URL = "https://www.ygfamily.com/artist/Schedule.asp?LANGDIV=K&ATYPE=2&ARTIDX=53&intYear="+year+"&intMonth="+month;
		logger.info(URL);
		//System.out.println(v);
		try {
			Document doc = Jsoup.connect(URL).get();
			//System.out.println(doc.html());
			//System.out.println("===========================================================================");
			doc.select("img").remove();
			Elements elem = doc.select("table#scheduleChart");
			
			model.addAttribute("scheduleChart", elem);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "crawling/wepcrawling";
	}


}
