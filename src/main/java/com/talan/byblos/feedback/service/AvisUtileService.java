package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dto.AvisUtile;

public interface AvisUtileService {
	AvisUtileDTO addUile(AvisUtileDTO utileDTO) throws ByblosException;
	
	/**
	 * Afficher tout les utiles
	 */
	List<AvisUtileDTO> loadAllUtile();

	List<AvisUtile> loadNbrUtileByAvis();
	


	void deleteUtileAvis(Long idUtile) throws ByblosException;

}
