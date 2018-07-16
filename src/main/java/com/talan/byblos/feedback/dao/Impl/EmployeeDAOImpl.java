package com.talan.byblos.feedback.dao.Impl;

import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.feedback.dao.AvisDAO;
import com.talan.byblos.feedback.dao.EmployeeDAO;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends GenericDAOImpl<EmployeeDTO, EmployeeEntity> implements EmployeeDAO {

	@Override
	public EmployeeEntity getEntityFromDTO(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO getDTOFromEntity(EmployeeEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
