package com.talan.byblos.feedback.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.utility.exception.ByblosException;


public interface NotificationService {

	/**
	 * Load all Notif info
	 */
	List<NotificationDTO> loadNotif();
	
	/**
	 * Add Notification
	 */
	NotificationDTO createNotif(NotificationDTO notificationDTO) throws ByblosException;
	
	/**
	 * update etat Notif
	 */
	void updateEtatNotif(Long id, String etat) throws ByblosException;
	
	/**
	 * les notification Non Vu
	 */
	List<NotificationDTO> loadNotifNonVu();
}


