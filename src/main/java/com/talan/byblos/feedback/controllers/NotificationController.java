package com.talan.byblos.feedback.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;
import com.talan.byblos.feedback.service.FeedBackService;
import com.talan.byblos.feedback.service.NotificationService;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class NotificationController {

/***
 * Logger
 */
public static  final Logger logger= LoggerFactory.getLogger(NotificationController.class);

/**
 * Logger
 */
private static final Log LOG = LogFactoryImpl.getLog(NotificationController.class);  
		
@Autowired
NotificationService notificationService;

@GetMapping(FeedbackControllerUriConstants.ALL_NOTIFICATION)
@ResponseBody
public List<NotificationDTO> loadNotif(){
	return notificationService.loadNotif();
}

@PostMapping(FeedbackControllerUriConstants.CREATE_NOTIF)
@ResponseBody
public NotificationDTO createNotif(@Valid @RequestBody NotificationDTO notificationDTO) throws ByblosException {
	NotificationDTO addNotif = new NotificationDTO();
	
	addNotif= notificationService.createNotif(notificationDTO);
	return addNotif;
	
}

@PutMapping(FeedbackControllerUriConstants.UPDATE_NOTIF)
@ResponseBody
public Boolean updateEtatNotif(@PathVariable("id") Long id, @PathVariable("etat") String etatNotif ) throws ByblosException {
	notificationService.updateEtatNotif(id, etatNotif);
	return true;
}

@GetMapping(FeedbackControllerUriConstants.NOTIF_NON_VU)
@ResponseBody
public List<NotificationDTO> loadNotifNonVu(){
	return notificationService.loadNotifNonVu();
}

}

