package com.talan.byblos.feedback.dao.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.security.AuthentificationUserDAO;
import com.talan.byblos.common.dto.UserDTO;
import com.talan.byblos.common.entities.FonctionEntity;
import com.talan.byblos.common.entities.UserEntity;
import com.talan.byblos.common.utility.FonctionUtility;
import com.talan.byblos.common.utility.UserUtility;
import com.talan.byblos.common.utility.exception.ByblosException;

//@Repository("authentificationUserDAO")
public class AuthentificationUserDAOImpl /*implements AuthentificationUserDAO*/ {

	/*@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDTO findUserByLogin(String login) throws ByblosException {
		
		Query query = em.createQuery("from UserEntity  where login = :login");
		query = query.setParameter("login", login);
		List<UserEntity> result = query.getResultList();
		return (null == result || result.isEmpty()) ? null : getDTOFromEntity(result.get(0));
	}

	public UserDTO getDTOFromEntity(UserEntity entity) {
		UserDTO userDTO= UserUtility.convertEntityToDTO(entity);
		userDTO.setPassword(entity.getPassword());
		return userDTO;
	}

	@Override
	public Collection<GrantedAuthority> getAuthority(Long userId, Integer space, Long socId) {
		Query query;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (userId != null && socId != null) {
			if (space != null) {
				query = em.createQuery(
														"select distinct f from FonctionEntity f,RoleEntity r, AdminRoleUserEntity a ,AdminRoleFonctionEntity af where f.id = af.function.id and af.role.id = r.id and r.id = a.role.id and a.user.id = :user and a.societe = "
														+ socId + " and r.space=" + space);
			} else {
				query = em.createQuery(
														"select distinct f from FonctionEntity f,RoleEntity r, AdminRoleUserEntity a ,AdminRoleFonctionEntity af where f.id = af.function.id and af.role.id = r.id and r.id = a.role.id and a.user.id = :user and a.societe = "
														+ socId);
			}
			query = query.setParameter("user", userId);
			@SuppressWarnings("unchecked")
			List<FonctionEntity> functions = query.getResultList();
			for (FonctionEntity fonctionEntity : functions) {
				authorities.add(FonctionUtility.convertEntityToDTO(fonctionEntity));
			}
		}
		return authorities;
	}
*/
}
