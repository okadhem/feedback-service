package com.talan.byblos.enquete.dao.impl;


import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.enquete.dao.QcmDAO;
import com.talan.byblos.enquete.dto.QcmDTO;
import com.talan.byblos.enquete.entites.QChoixMultiEntity;


public class QcmDAOImpl extends GenericDAOImpl<QcmDTO, QChoixMultiEntity> implements QcmDAO {

	@Override
	public QChoixMultiEntity getEntityFromDTO(QcmDTO dto) {
		return dto.toEntity();
		
		
	}

	@Override
	public QcmDTO getDTOFromEntity(QChoixMultiEntity entity) {
		return entity.toDTO();
	}

}
