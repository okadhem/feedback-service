package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface AffectationReponseService {
	/**
	 * ajouter une affectation
	 */
 AffectationReponseDTO ajouterAffectation(AffectationReponseDTO affectationReponseDTO) throws ByblosException;
 List<AffectationReponseDTO> loadAffectation(Long idFeedback);
 public Long CheckifExists(long feedback , long employee);
 public void deleteAffectation(long feedback , long employee );
}
