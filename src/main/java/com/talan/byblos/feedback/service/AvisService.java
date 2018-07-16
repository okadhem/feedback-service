package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface AvisService {
	
	/**
	 * ajouter un avis
	 */
 AvisDTO ajouterAvis(AvisDTO avisDTO) throws ByblosException;
 
 /**
  * afficher les avis
  */
 List<AvisDTO> loadAllAvis();
 
 /**
  * load avis par id Theme 
  */
 List<AvisDTO> loadAvisByIdTheme(Long id);
 
 /**
  * Calculer moyene rate by id theme
  */
 List<Double> moyenneRate(Long idTheme);

 public Long NombreParticipants();
}

