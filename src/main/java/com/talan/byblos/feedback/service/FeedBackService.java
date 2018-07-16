package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface FeedBackService {

	/**
	 * 
	 * Load Feedback
	 * 
	 * @param feedbackId
	 * @return
	 * @throws ByblosException
	 */
	FeedbackDTO loadFeedback(Long feedbackId) throws ByblosException;

	/**
	 * Add a new feedback
	 */
	FeedbackDTO ajouterFeedack(FeedbackDTO feedbackDTO) throws ByblosException;

	List<FeedbackDTO> loadFeedbackByIdCategorie(Long Id);

	List<FeedbackDTO> chercherFeedback(String mc);

	/**
	 * Afficher les feedbacks par id Utilisateur
	 * 
	 * @param id
	 * @return
	 */
	List<FeedbackDTO> loadFeedbackByIdUser(Long id);

	/**
	 * Afficher les feedback publique
	 */
	List<FeedbackDTO> loadFeedbackPublique();

	/**
	 * Afficher tout les feedbacks
	 * 
	 * @return
	 * @throws ByblosException 
	 */
	List<FeedbackDTO> loadFeedback() throws ByblosException;

	/**
	 * nbre mes proposition
	 * 
	 */
	Long nmbrPropositionById(Long idUser);

	/**
	 * 
	 * nbr mes anomalie
	 */

	Long nmbrAnomalieById(Long idUser);

	/**
	 * nbre les propositions
	 * 
	 * @return
	 */

	Long nmbrPropositionPublique();

	/**
	 * 
	 * nbre les anomalies
	 */

	Long nmbrAnomaliePublique();

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
	List<String> getKey();

	/**
	 * 
	 * @return
	 */
	List<Long> getValue();
	/**
	 * 
	 * @return
	 */
	List<Long> getValueProposition();
	/**
	 * 
	 * @return
	 */
	List<String> getKeyProp();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ByblosDataAccessException 
	 */
	public void LoadFeedbackByID(Long id) throws ByblosDataAccessException;

	
	public void setEtatFeedback(Long id) throws ByblosDataAccessException;
	
	public void setEtatFeedbackProposition(Long id) throws ByblosDataAccessException;
	
	public void setEtatFeedbackProposition2(Long id) throws ByblosDataAccessException;
	
	public void setEtatFeedbackAnomalie(Long id) throws ByblosDataAccessException;
	
	public void setEtatFeedbackAnomalie2(Long id) throws ByblosDataAccessException;
	
	public void setEtatFeedbackAnomalieResolu(Long id) throws ByblosDataAccessException;
	public long nbFeedbacksTraite();

}
