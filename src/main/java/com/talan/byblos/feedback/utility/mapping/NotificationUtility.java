package com.talan.byblos.feedback.utility.mapping;
import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.NotificationEntity;

public class NotificationUtility {
	
	public static NotificationEntity convertDtoToEntity(NotificationDTO notificationDTO) {
		
		NotificationEntity notificationEntity = new NotificationEntity();
		
		notificationEntity.setIdNotification(notificationDTO.getIdNotification());
		notificationEntity.setEtatNotif(notificationDTO.getEtatNotif());
		notificationEntity.setPersonnelExpediteur(new EmployeeEntity(notificationDTO.getPersonnelExpediteur().getId()));
	
		notificationEntity.setIdFeedback(new FeedbackEntity(notificationDTO.getFeedback().getIdFeedback()));
		
		return notificationEntity;
	}

	public static NotificationDTO convertEntityToDto(NotificationEntity notificationEntity) {
		
		NotificationDTO notificationDTO = new NotificationDTO();
		
		notificationDTO.setIdNotification(notificationEntity.getIdNotification());
		notificationDTO.setEtatNotif(notificationEntity.getEtatNotif());
		
			notificationDTO.setPersonnelExpediteur(PersonneUtility.convertEntityToDto(notificationEntity.getPersonnelExpediteur()));
		
		
		
			notificationDTO.setFeedback(FeedbackUtility.convertEntityToDto(notificationEntity.getIdFeedback()));
		
		return notificationDTO;
	}
}


