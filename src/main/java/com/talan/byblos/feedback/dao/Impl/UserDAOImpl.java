package com.talan.byblos.feedback.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.UserDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.SocieteEntity;
import com.talan.byblos.common.entities.UserEntity;
import com.talan.byblos.common.service.security.AuthentificationUserService;
import com.talan.byblos.common.utility.UserUtility;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.UserDAO;

//@Repository
public class UserDAOImpl /*extends GenericDAOImpl<UserDTO, UserEntity> implements UserDAO*/ {
	
	/*@Autowired
	private AuthentificationUserService authUserService;

	@Override
	public UserEntity getEntityFromDTO(UserDTO dto) {
		SocieteEntity societeEntity = null;
		EmployeeEntity personnel = null;
		if (dto.getSocieteId() != null) {
			societeEntity = getEntityManager().find(SocieteEntity.class, dto.getSocieteId());
		}
		if (dto.getPersonnelId() != null) {
			personnel = getEntityManager().find(EmployeeEntity.class, dto.getPersonnelId());
		}
		UserEntity entity = UserUtility.convertDtoToEntity(dto, societeEntity, personnel);
		return entity;
	}

	@Override
	public UserDTO getDTOFromEntity(UserEntity entity) {
		return UserUtility.convertEntityToDTO(entity);
	}

	@Override
	public UserDTO getLoggedInUser() {
		if(SecurityContextHolder.getContext().getAuthentication() != null ) {
			try {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String username;
				if (principal instanceof UserDetails) {
				username = ((UserDetails)principal).getUsername();
				} else {
				 username = principal.toString();
				}
				return authUserService.getUserByLogin(username);
			} catch (ByblosException e) {
				e.printStackTrace();
			}
		}
		return new UserDTO();
	}
*/
}
