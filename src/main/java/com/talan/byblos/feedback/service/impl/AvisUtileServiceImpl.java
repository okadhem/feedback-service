package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.AvisUtileDAO;
import com.talan.byblos.feedback.dto.AvisUtile;
import com.talan.byblos.feedback.service.AvisUtileService;
@Service("AvisUtileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AvisUtileServiceImpl implements AvisUtileService{
	@Autowired
	private AvisUtileDAO utileDAO;


	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, rollbackFor = ByblosException.class)
	public AvisUtileDTO addUile(AvisUtileDTO utileDTO) throws ByblosException {
		return utileDAO.persist(utileDTO);

	}


	@Override
	public List<AvisUtileDTO> loadAllUtile() {
		List<AvisUtileDTO> utileListe= utileDAO.loadAllUtile();
		return utileListe;



	}


	@Override
	public List<AvisUtile> loadNbrUtileByAvis() {
		
		return utileDAO.loadnbUtileByAvis();
	}


	@Modifying
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, noRollbackFor = ByblosException.class)
	public void deleteUtileAvis(Long idUtile) throws ByblosException {
		utileDAO.remove(idUtile);
		
	}
	


}
