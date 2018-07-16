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

import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.common.utility.log.LogUtility;
import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;
import com.talan.byblos.feedback.service.CategorieService;

import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class CategorieControllers {

	/***
	 * Logger
	 */
	public static  final Logger logger= LoggerFactory.getLogger(CategorieControllers.class);
	
	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(CategorieControllers.class);  
	
	@Autowired
	CategorieService categorieService;
	
	@GetMapping(FeedbackControllerUriConstants.LOAD_CATEGORIE_BY_ID)
	@ResponseBody
	public CategorieDTO getCategorieById(@PathVariable("id") Long id) {
		
		CategorieDTO categorieDTO = null;
		
		try {
			categorieDTO = categorieService.loadCategorie(id);
		}catch (ByblosException e) {
			LogUtility.logError(LOG, e);
			
		}
		return categorieDTO;
	}
	
	@PostMapping(FeedbackControllerUriConstants.ADD_CATEGORIE)
	@ResponseBody
	public CategorieDTO addCategorie(@Valid @RequestBody CategorieDTO categorieDTO) {
		
		CategorieDTO addCategorie = null;
		
		try {
			addCategorie = categorieService.ajouterCategorie(categorieDTO);
		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);
		}
		return addCategorie;
	}
	
	@DeleteMapping(FeedbackControllerUriConstants.DELETE_CATEGORIE)
	@ResponseBody
	public void deleteCategorie(@PathVariable("id") Long id) {
		
		try {
			categorieService.deleteCategorieById(id);
		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);
		}
	}
	
	@GetMapping(FeedbackControllerUriConstants.LOAD_CATEGORIE)
	@ResponseBody
	public List<CategorieDTO> loadCategories(){
		List<CategorieDTO> categorieList= null;
		categorieList = categorieService.loadCategorie();
		return categorieList;
	}
	
	
}
