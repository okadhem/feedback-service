package com.talan.byblos.feedback.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.ReponseDAO;
import com.talan.byblos.feedback.service.ReponseService;

@Service("ReponseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReponseServiceImpl implements ReponseService{
	
	@Autowired
	private ReponseDAO reponseDAO;

	@Override
	public List<ReponseDTO> loadAllReponse() {
		List<ReponseDTO> reponseListe= reponseDAO.loadAllReponse();
		return reponseListe;
	}

	@Override
	public List<ReponseDTO> loadReponseByIdFeedback(Long id) {
		List<ReponseDTO> reponseListe= reponseDAO.loadReponseByIdFeedback(id);
		return reponseListe;
	}

	@Override
	public List<Long> feedbackAvecReponse() {
		List<Long> idFeedbackList = reponseDAO.feedbackAvecReponse();
		return idFeedbackList;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public ReponseDTO addReponse(ReponseDTO reponseDTO) throws ByblosException {
		
		return reponseDAO.persist(reponseDTO);
	}

	@Override
	public List<String> loadEmployes() {
	return reponseDAO.loadEmployeeNames();
	}

	@Override
	public Long loadEmployeeByNameS(String Name) throws ByblosException {
		
		return reponseDAO.loadEmployeeByName(Name);
	}

	@Override
	public List<ReponseFeedbackDTO> loadNbReponse1() {
		return reponseDAO.loadNbReponse1();

	}

	@Override
	public List<Long> feedbackPublicAvecReponse() {
		
		return reponseDAO.feedbackPublicAvecReponse();
	}

	@Override
	public List<Long> feedbackAvecReponsePersonel(Long id) {
		
		return reponseDAO.feedbackPersonelAvecReponse(id);
	}
	
	

}


