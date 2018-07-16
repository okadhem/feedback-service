package com.talan.byblos.feedback.service.impl;




import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.hibernate.validator.constraints.Mod10Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.FeedbackDAO;
import com.talan.byblos.feedback.service.FeedBackService;



@Service("feedbackService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class FeedbackServiceImpl implements FeedBackService {
	
	/** feedback dao */
	@Autowired
	private FeedbackDAO feedbackDAO;
	
	
	/**
	 * Afficher tout les info sur un feedback choisi par son id
	 */
	@Override
	public  FeedbackDTO loadFeedback(Long feedbackId) throws ByblosException{
		//LOG.debug("Start of CollaborateurServiceImpl.loadIdentityEmployeeCardsByEmployeeId(employeeId)");
		
		Long persId= feedbackId;
		if (persId == null) {
			
		}
		
		FeedbackDTO feedbackDTO = null;
		feedbackDTO = feedbackDAO.load(persId);
				//LOG.debug("End of CollaborateurServiceImpl.loadEmployee(employeeId)");	
	
		return feedbackDTO;
	}


	/**
	 * Ajouter un nouveau Feedback
	 */
	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public FeedbackDTO ajouterFeedack(FeedbackDTO feedbackDTO) throws ByblosException {
		feedbackDTO.setEtatFeedback("non traité");
		
		return feedbackDAO.persist(feedbackDTO);
		
	}


	@Override
	public List<FeedbackDTO> loadFeedbackByIdCategorie(Long IdCategorie) {
		//LOG.debug("start loadPersonnelCostsByPersonelId " + IdCategorie);
		List<FeedbackDTO> feedbackList= feedbackDAO.loadFeedbackByIdCategorie(IdCategorie);
		return feedbackList;
	}


	@Override
	public List<FeedbackDTO> chercherFeedback(String mc) {
		List<FeedbackDTO> feedbackList= feedbackDAO.chercher(mc);
		return feedbackList;
	}



	@Override
	public List<FeedbackDTO> loadFeedbackByIdUser(Long idUser) {
		List<FeedbackDTO> feedbackList= feedbackDAO.loadFeedbackByIdUser(idUser);
		return feedbackList;
	}



	@Override
	public List<FeedbackDTO> loadFeedbackPublique() {
		List<FeedbackDTO> feedbackList= feedbackDAO.loadFeedbackPublique();
		return feedbackList;
	}


	@Override
	public Long nmbrPropositionById(Long idUser) {
		
		return feedbackDAO.nmbrPropositionByIdUser(idUser);
	}


	@Override
	public Long nmbrAnomalieById(Long idUser) {
		
		return feedbackDAO.nmbrAnomaliByIdUser(idUser);
	}

	@Override
	public Long nmbrPropositionPublique() {
		
		return feedbackDAO.nmbrPropositionPublique();
	}


	@Override
	public Long nmbrAnomaliePublique() {
		
		return feedbackDAO.nmbrAnomaliePublique();
		
	}

	@Override
	public List<FeedbackDTO> loadFeedback() throws ByblosException {
List<FeedbackDTO> feedbackList= feedbackDAO.loadFeedback();
		
		return feedbackList;
	}


	
	@Override
	public Long nmbrProposition() {
		
		return feedbackDAO.nmbrProposition();
	}


	@Override
	public Long nmbrAnomalie() {
		
		return feedbackDAO.nmbrAnomalie();
		
	}
	@Override
	public Long nmbrFeedbacks() {
		
		return feedbackDAO.nmbrFeedbacks();
		
	}


	@Override
	public List<String> getKey() {
		
		return feedbackDAO.StatPerMonthKey();
	}


	@Override
	public List<Long> getValue() {
	
		return feedbackDAO.StatPerMonthValue();
	}


	@Override
	public List<Long> getValueProposition() {
		return feedbackDAO.StatPerMonthValueProposition();
	}


	@Override
	public List<String> getKeyProp() {
	
		return feedbackDAO.StatPerMonthKeyProp();
	}


	@Override
	//@Transactional
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void LoadFeedbackByID(Long id) throws ByblosDataAccessException {
		 feedbackDAO.setFeedbackVisibilityByID(id);
         
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedback(Long id) throws ByblosDataAccessException {
		feedbackDAO.setEtatFeedback(id);
		
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedbackProposition(Long id) throws ByblosDataAccessException {
             feedbackDAO.setEtatFeedbackProposition(id);		
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedbackProposition2(Long id) throws ByblosDataAccessException {
        feedbackDAO.setEtatFeedbackProposition2(id);		
		
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedbackAnomalie(Long id) throws ByblosDataAccessException {
		feedbackDAO.setEtatFeedbackAnomalie(id);
		
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedbackAnomalie2(Long id) throws ByblosDataAccessException {
		feedbackDAO.setEtatFeedbackAnomalie2(id);
		
	}


	@Override
	@Modifying
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = ByblosDataAccessException.class)
	public void setEtatFeedbackAnomalieResolu(Long id) throws ByblosDataAccessException {
		feedbackDAO.setEtatFeedbackAnomalieResolu(id);
		
	}


	@Override
	public long nbFeedbacksTraite() {
		
		return feedbackDAO.nbFeedbacksTraite();
	}

}
