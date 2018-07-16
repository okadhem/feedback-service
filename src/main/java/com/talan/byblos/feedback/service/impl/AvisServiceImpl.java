package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.AvisDAO;
import com.talan.byblos.feedback.service.AvisService;

@Service("AvisService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AvisServiceImpl implements AvisService {

	
	@Autowired
	private AvisDAO avisDAO;
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public AvisDTO ajouterAvis(AvisDTO avisDTO) throws ByblosException {
		return avisDAO.persist(avisDTO);
	}

	@Override
	public List<AvisDTO> loadAllAvis() {
		List<AvisDTO> avisList= avisDAO.loadAllAvis();
		return avisList;
	}
	
	@Override
	public List<AvisDTO> loadAvisByIdTheme(Long id) {
		List<AvisDTO> avisList= avisDAO.loadAvisByIdTheme(id);
		return avisList;
	}

	@Override
	public List<Double> moyenneRate(Long idTheme) {
		List<Double> moyenne= avisDAO.moyenneRate(idTheme);
		return moyenne;
	}

	@Override
	public Long NombreParticipants() {
		
		return avisDAO.NombreParticipants();
	}



}

