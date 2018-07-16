package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.AffectationReponseDAO;
import com.talan.byblos.feedback.dao.AvisDAO;
import com.talan.byblos.feedback.service.AffectationReponseService;
@Service("AffectationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AffectationReponseServiceImpl implements AffectationReponseService {

	@Autowired
	private AffectationReponseDAO affectationReponseDAO; 
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public AffectationReponseDTO ajouterAffectation(AffectationReponseDTO affectationReponseDTO) throws ByblosException {
		return affectationReponseDAO.persist(affectationReponseDTO)  ;
	}

	@Override
	public List<AffectationReponseDTO> loadAffectation(Long idFeedback) {
		
		return affectationReponseDAO.loadAffectationByFeedback(idFeedback);
	}

	@Override
	public Long CheckifExists(long feedback, long employee) {
		
		return affectationReponseDAO.CheckifExists(feedback, employee);
	}

	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void deleteAffectation(long feedback, long employee) {
		affectationReponseDAO.deleteAffectation(feedback, employee);
		
	}

}
