package com.talan.byblos.feedback.services.security.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.talan.byblos.common.dao.security.AuthentificationUserDAO;
import com.talan.byblos.common.dto.UserDTO;
import com.talan.byblos.common.service.security.AuthentificationUserService;
import com.talan.byblos.common.utility.exception.ByblosException;


//@Service(value = "authService")
public class AuthentificationUserServiceImpl /*implements UserDetailsService, AuthentificationUserService*/ {
/*
	@Autowired
	private AuthentificationUserDAO userDao;

	@Autowired
	EntityManager em;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user;
		try {
			user = userDao.findUserByLogin(username);
			if(user == null){
				throw new UsernameNotFoundException("Invalid username or password.");
			}
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), userDao.getAuthority(user.getId(),user.getSpaceId(),user.getSocieteId()));
		} catch (ByblosException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	*//**
	 * {@inheritDoc}
	 *//*
	@Override
	public UserDTO getUserByLogin(String login) throws ByblosException {
		return userDao.findUserByLogin(login);
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthority(Long userId, Integer space, Long socId) {
		return userDao.getAuthority(userId, space, socId);
	}*/
}
