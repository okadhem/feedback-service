package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.ThemeAvisDAO;
import com.talan.byblos.feedback.service.ThemeAvisService;

@Service("ThemeAvisService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ThemeAvisServiceImpl implements ThemeAvisService {

	/** Theme Avis DAO */
	@Autowired
	private ThemeAvisDAO themeAvisDAO;

	/**
	 * Afficher tout les theme non traite by id User
	 */
	@Override
	public List<ThemeAvisDTO> themeNonTraiter(Long idUser) {

		List<ThemeAvisDTO> themeList = themeAvisDAO.loadThemeNonTraite(idUser);
		return themeList;
	}

	@Override
	public ThemeAvisDTO loadThemeById(Long id) {

		return themeAvisDAO.loadThemeById(id);
	}

	@Override
	public List<ThemeAvisDTO> Allthemes() {
		List<ThemeAvisDTO> allthemeList = themeAvisDAO.loadAllThemes();
		return allthemeList;
	}

	/**
	 * Add
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, noRollbackFor = ByblosException.class)
	public ThemeAvisDTO addTheme(ThemeAvisDTO themeDTO) throws ByblosException {

		return themeAvisDAO.persist(themeDTO);
	}

	@Modifying
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, noRollbackFor = ByblosException.class)
	public void DeleteTheme(Long idTheme) throws ByblosException {
		themeAvisDAO.remove(idTheme);
		
	}


}
