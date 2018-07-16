package com.talan.byblos.feedback.controllers;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.service.AvisUtileService;
import com.talan.byblos.feedback.controllers.uri.*;
import com.talan.byblos.feedback.dto.AvisUtile;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class UtileControllers {
	
	/***
	 * Logger
	 */
	public static  final Logger logger= LoggerFactory.getLogger(UtileControllers.class);
	
	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(UtileControllers.class); 
	
	@Autowired
	AvisUtileService utileService;
	
	
	@PostMapping(AvisControllerUriConstants.ADD_NEW_UTILE)
	@ResponseBody
	public AvisUtileDTO addUtile(@Valid @RequestBody AvisUtileDTO utileDTO) throws ByblosException{
		return utileService.addUile(utileDTO);
		
	}
	
	/**
	 * load all utile
	 */
	@GetMapping(AvisControllerUriConstants.LOAD_ALL_UTILE)
	@ResponseBody
	public List<AvisUtileDTO> loadAllUtile(){
		List<AvisUtileDTO> utileList;
		utileList = utileService.loadAllUtile();
		
		return utileList;
	}
	
	@GetMapping(AvisControllerUriConstants.LOAD_NBR_UTILE_BY_AVIS)
	@ResponseBody
	public List<AvisUtile> loadNbrUtileByAvis(){
		List<AvisUtile> nbrUtilList;
		nbrUtilList = utileService.loadNbrUtileByAvis();
		return nbrUtilList;
		
	}
	
  @DeleteMapping(AvisControllerUriConstants.DELETE_UTILE)
  @ResponseBody
  public Boolean deleteUtile(@PathVariable("id") Long idUtile) throws ByblosException {
	  
	  utileService.deleteUtileAvis(idUtile);
	  
	  return true;
  }


	
	
}


