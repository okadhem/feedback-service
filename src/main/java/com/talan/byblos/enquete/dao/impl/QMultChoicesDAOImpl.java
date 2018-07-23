package com.talan.byblos.enquete.dao.impl;


import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.enquete.dao.QMultChoicesDAO;
import com.talan.byblos.enquete.dto.QMultChoicesDTO;
import com.talan.byblos.enquete.entites.QMultChoicesEntity;


public class QMultChoicesDAOImpl extends GenericDAOImpl<QMultChoicesDTO, QMultChoicesEntity> implements QMultChoicesDAO {

	@Override
	public QMultChoicesEntity getEntityFromDTO(QMultChoicesDTO dto) {
		return dto.toEntity();
		
		
	}

	@Override
	public QMultChoicesDTO getDTOFromEntity(QMultChoicesEntity entity) {
		return entity.toDTO();
	}

}
