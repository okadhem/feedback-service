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
import com.talan.byblos.feedback.controllers.uri.*;
import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.service.ThemeAvisService;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class ThemeAvisControllers {
	/**
	 * Logger
	 */
	public static  final Logger logger= LoggerFactory.getLogger(FeedbackControllers.class);
	
	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(FeedbackControllers.class);  
			
	@Autowired
	ThemeAvisService themeService;
	
	@GetMapping(AvisControllerUriConstants.LOAD_THEME_NON_TRAITE)
	@ResponseBody
	public List<ThemeAvisDTO> loadThemeNonTraite(@PathVariable("id") Long idUser){
		List<ThemeAvisDTO> themeList=null;
		themeList= themeService.themeNonTraiter(idUser);
		return themeList;
	}
	
	@GetMapping(AvisControllerUriConstants.LOAD_THEME_BY_ID)
	@ResponseBody
	public ThemeAvisDTO loadThemeById(@PathVariable("id") Long idTheme) {
		return themeService.loadThemeById(idTheme);
	}

	@GetMapping(AvisControllerUriConstants.LOAD_ALL_THEMES)
	@ResponseBody
	public List<ThemeAvisDTO> loadThemes() {
		List<ThemeAvisDTO> themeList=null;
		themeList= themeService.Allthemes();
		return themeList;
	}
	
	
	@PostMapping(AvisControllerUriConstants.ADD_NEW_THEME)
	@ResponseBody
	public ThemeAvisDTO addTheme(@Valid @RequestBody ThemeAvisDTO theme) throws ByblosException {
		return themeService.addTheme(theme);
	}
	
	@DeleteMapping(AvisControllerUriConstants.DELETE_THEME)
	@ResponseBody
	public Boolean DeleteTheme(@PathVariable("id") Long themeId) throws ByblosException {
		themeService.DeleteTheme(themeId);
		return true;
	}

	
}



