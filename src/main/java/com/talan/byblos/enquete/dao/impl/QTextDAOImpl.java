package com.talan.byblos.enquete.dao.impl;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.enquete.dao.QTextDAO;
import com.talan.byblos.enquete.dto.QTextDTO;
import com.talan.byblos.enquete.entites.QTextEntity;




@Component
public class QTextDAOImpl extends GenericDAOImpl<QTextDTO, QTextEntity> implements QTextDAO{

	@Override
	public QTextEntity getEntityFromDTO(QTextDTO dto) {
			return dto.toEntity();
	}

	@Override
	public QTextDTO getDTOFromEntity(QTextEntity entity) {
		return entity.toDTO();
	}

}
