package com.talan.byblos.feedback.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/message")
    @SendTo("/topic/reply")
	public String processMessageFromClient(@Payload String message) throws Exception {
		String name = new Gson().fromJson(message, Map.class).get("name").toString();
		return name;
	}
	
	@MessageExceptionHandler
    public String handleException(Throwable exception) {
        messagingTemplate.convertAndSend("/errors", exception.getMessage());
	    return exception.getMessage();
    }
	
	@MessageMapping("/updateTab")
	@SendTo("/topic/send")
	public Boolean sendMsg(@Payload String msg) throws Exception{
		Boolean test= (Boolean) new Gson().fromJson(msg, Map.class).get("test");
		return test;
		
	}
	
	
	@MessageMapping("/notif")
	@SendTo("/notification/notif")
	public Boolean creatNotif(@Payload String notif) throws Exception{
		Boolean testNotif= (Boolean) new Gson().fromJson(notif, Map.class).get("testNotif");
		return testNotif;
		
	}
	
	@MessageMapping("/workflow")
	@SendTo("/updateWorkflow/workflow")
	public Boolean updateWorkflow(@Payload String workflow) throws Exception{
		Boolean testWorkflow= (Boolean) new Gson().fromJson(workflow, Map.class).get("testWorkflow");
		return testWorkflow;
		
	}
	
	
	
	
}




