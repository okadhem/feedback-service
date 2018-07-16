package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.FeedbackDAO;
import com.talan.byblos.feedback.dao.NotificationDAO;
import com.talan.byblos.feedback.service.NotificationService;

@Service("notificationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotificationServiceImpl implements NotificationService{
	
	/** notification dao */
	@Autowired
	private NotificationDAO notificationDAO;

	@Override
	public List<NotificationDTO> loadNotif() {
		
		return notificationDAO.loadNotification();
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosException.class)
	public NotificationDTO createNotif(NotificationDTO notificationDTO) throws ByblosException {
		notificationDTO.setEtatNotif("Non Vue");
		
		return notificationDAO.persist(notificationDTO);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public void updateEtatNotif(Long id, String etat) throws ByblosException {
		notificationDAO.updateEtatNotif(id, etat);
		
	}

	@Override
	public List<NotificationDTO> loadNotifNonVu() {
		return notificationDAO.notifiactionNonVu();
	}

}


