package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.dto.NotificationDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.NotificationEntity;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.FeedbackDAO;
import com.talan.byblos.feedback.dao.NotificationDAO;
import com.talan.byblos.feedback.utility.mapping.NotificationUtility;

@Repository("notificationDAO")
public class NotificationDAOImpl extends GenericDAOImpl<NotificationDTO, NotificationEntity> implements NotificationDAO {

	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(NotificationDAOImpl.class);
	

	/**
	 * constructeur par defaut.
	 */
	public NotificationDAOImpl() {
		super();
	}
	
	@Override
	public NotificationEntity getEntityFromDTO(NotificationDTO dto) {
		// TODO Auto-generated method stub
		return NotificationUtility.convertDtoToEntity(dto);
	}

	@Override
	public NotificationDTO getDTOFromEntity(NotificationEntity entity) {
		
		NotificationDTO notificationDTO= NotificationUtility.convertEntityToDto(entity);
		convertEntityToDto(entity, notificationDTO);
		return notificationDTO;
	}

	@Override
	public List<NotificationDTO> loadNotification() {
		List<NotificationDTO> notificationnDTOList= new ArrayList<NotificationDTO>();
		StringBuffer query = new StringBuffer("select n from NotificationEntity n ORDER BY dateCreation DESC");
		List<NotificationEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (NotificationEntity entity: resultList) {
			notificationnDTOList.add(fullConvertEntity(entity));
		}
		return notificationnDTOList;	
		
	}

	@Override
	public void updateEtatNotif(Long id, String etat) throws ByblosException {
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO = loadNotif(id);
		notificationDTO.setEtatNotif(etat);
		merge(notificationDTO);
		
	}
	
	public NotificationDTO loadNotif(Long idNotif) throws ByblosException{
		Long persId = idNotif;
		
		if(persId == null) {
			
		}
		NotificationDTO notificationDTO = null;
		notificationDTO = load(persId);
		return notificationDTO;
	}

	@Override
	public List<NotificationDTO> notifiactionNonVu() {
		
		List<NotificationDTO> notificationnDTOList= new ArrayList<NotificationDTO>();
		StringBuffer query = new StringBuffer("select n from NotificationEntity n where n.etatNotif='Non Vue'");
		List<NotificationEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (NotificationEntity entity: resultList) {
			notificationnDTOList.add(fullConvertEntity(entity));
		}
		return notificationnDTOList;	
	}

}


