package com.talan.byblos.feedback.dao;

import java.util.ArrayList;
import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.NotificationEntity;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.FeedbackApplication;

public interface NotificationDAO extends GenericDAO<NotificationDTO, NotificationEntity> {

	List<NotificationDTO> loadNotification();
	
	/**
	 * Update etat Notif
	 */
	void updateEtatNotif(Long id, String etat) throws ByblosException;
	
	List<NotificationDTO> notifiactionNonVu();
}

