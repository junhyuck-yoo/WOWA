package com.pjt.wowa;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo/*")
public class EchoHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	
	//클라이언트와 연결 이후에 실행되는 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		sessionList.add(session);
		logger.info("{} Connected", session.getId());
	}
	 //클라이언트가 바로 메세지 전송을 했을 때 실행되는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("{}로 부터 {} 받음  ", session.getId(), message.getPayload());
		JSONObject object = new JSONObject(message.getPayload());
		String username = object.getString("user");
		logger.info("{} is chating username", username);
		String msg = object.getString("message");
		logger.info(msg);
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage("[ " + username + " ]"+ " : " + msg));
		}
	}
	
	//클라이언트와 연결을 끊었을 때 실행되는 메서드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김", session.getId());
	}
	
}
