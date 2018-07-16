package com.talan.byblos.feedback.controllers.uri;

public class AvisControllerUriConstants {
	
	/** API_Feedback */
	public static final String API_FEEDBACK = "api";
	
	/**
	 * load les themes non traite by id user
	 */
	public static final String LOAD_THEME_NON_TRAITE="themeNonTraite/{id}";
	
	/**
	 * Ajoute avis
	 */
	public static final String ADD_AVIS="addAvis";
	
	/**
	 * Afficher tou les avis
	 */
	public static final String LOAD_ALL_AVIS="loadAllAvis";
	
	/**
	 * Affiche theme par id
	 */
	public static final String LOAD_THEME_BY_ID="loadThemeById/{id}";
	/**
	 * Affiche themes
	 */
	public static final String LOAD_ALL_THEMES="loadAllTheme";
	
	/**
	 * Afficher theme By id theme Avis
	 */
	public static final String  LOAD_AVIS_BY_ID_THEME="loadAvisByIdTheme/{id}";
	/**
	 * Calculer la moyenne par id theme
	 */
	public static final String LOAD_MOYENNE_BY_ID_THEME="loadMoyenneRate/{id}";

	/**
	 * Add new theme
	 */
	public static final String ADD_NEW_THEME="addNewTheme";
	/**
	 * nombre des participants 
	 */

	public static final String LOAD_NB_PARTICIPANT = "LoadNBParticipant";
	/**
	 * add new utile
	 */
	public static final String ADD_NEW_UTILE="addNewUtile";
	
	/**
	 * load All utile
	 */
	public static final String LOAD_ALL_UTILE="loadAllUtileList";

	public static final String DELETE_THEME = "DeleteTheme/{id}";

	public static final String LOAD_NBR_UTILE_BY_AVIS="loadNbrUtileByAvis";
	
	public static final String DELETE_UTILE="deleteUtile/{id}";



}

