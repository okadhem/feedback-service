package com.talan.byblos.feedback.controllers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import javax.mail.internet.MimeMessage;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class SmtpMailSender {
	/*
	 * @Autowired 
	 * public JavaMailSender emailSender;
	 * 
	 * public void sendSimpleMessage(String to, String subject, String text) {
	 * 
	 * SimpleMailMessage message = new SimpleMailMessage(); message.setTo(to);
	 * message.setSubject(subject); message.setText(text);
	 * emailSender.send(message);
	 * 
	 * }
	 */
                                                             
//	@Autowired
//	private JavaMailSender sender;
//
//	@RequestMapping(value = "/simpleemail2/{file}/{ex}", method = RequestMethod.Post)
//	@ResponseBody
//	private String sendEmail(@RequestBody("file") String fileName, @PathVariable("ex") String extension)
//			throws Exception {
//		
//		MimeMessage message = sender.createMimeMessage();
//
//		// Enable the multipart flag!
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setTo("asma.charrada@esprit.tn");
//		helper.setText("How are you?");
//		
//		
//		
//		
//		
//		
//		
//      helper.setSubject("feedback");
//	
//		File file = new File("/Feedback/src/main/resources/feedBackDocuments/" + fileName + "." + extension);
//		helper.addAttachment("/Feedback/src/main/resources/feedBackDocuments" + fileName + "." + extension, file);
//		sender.send(message);
//		System.out.println("done ");
//		return "done";
//	}

}
