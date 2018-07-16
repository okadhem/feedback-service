package com.talan.byblos.feedback.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface FeedbackDAO extends GenericDAO<FeedbackDTO, FeedbackEntity> {

	List<FeedbackDTO> loadFeedbackByIdCategorie(Long idCategorie);

	List<FeedbackDTO> chercher(String mc);

	/**
	 * Afficher les feedback by id User
	 * 
	 * @return
	 */

	List<FeedbackDTO> loadFeedbackByIdUser(Long idUser);

	/**
	 * Aficher les feedback publique
	 */
	List<FeedbackDTO> loadFeedbackPublique();

	/**
	 * Afficher le nombre de proposition by id user
	 */
	Long nmbrPropositionByIdUser(Long idUser);

	/**
	 * nombre d'anomalie par id user
	 */
	Long nmbrAnomaliByIdUser(Long idUser);

	/**
	 * nombe de proposition dans les feedback publique
	 */
	Long nmbrPropositionPublique();

	/**
	 * nombre d'anomalie dans les feedback publique
	 */
	Long nmbrAnomaliePublique();

	/**
	 * Afficher tout les feedback
	 * 
	 * @return
	 * @throws ByblosException 
	 */
	List<FeedbackDTO> loadFeedback() throws ByblosException;

	/**
	 * 
	 * @return
	 */
	Long nmbrProposition();

	/**
	 * 
	 * @return
	 */
	Long nmbrAnomalie();

	/**
	 * 
	 * @return
	 */
	Long nmbrFeedbacks();

	/**
	 * 
	 * @return
	 */
	List<String> StatPerMonthKey();

	/**
	 * 
	 * @return
	 */
	List<Long> StatPerMonthValue();
	/**
	 * 
	 * @return
	 */
	List<Long> StatPerMonthValueProposition();

	List<String> StatPerMonthKeyProp();

	void setFeedbackVisibilityByID(Long id) throws ByblosDataAccessException;

	void setEtatFeedback(Long id) throws ByblosDataAccessException;

	void setEtatFeedbackProposition(Long id) throws ByblosDataAccessException;

	void setEtatFeedbackProposition2(Long id) throws ByblosDataAccessException;

	void setEtatFeedbackAnomalie2(Long id) throws ByblosDataAccessException;

	void setEtatFeedbackAnomalie(Long id) throws ByblosDataAccessException;

	void setEtatFeedbackAnomalieResolu(Long id) throws ByblosDataAccessException;
	
	long nbFeedbacksTraite();



}
