package com.talan.byblos.feedback.controllers.uri;

public final class FeedbackControllerUriConstants {

	/** API_Feedback */
	public static final String API_FEEDBACK = "api";

	/**
	 * load
	 */
	public static final String LOAD_FEEDBACK_BY_ID = "loadFeedback/{id}";

	/**
	 * Ajouter un feedback
	 */
	public static final String ADD_FEEDBACK = "addFeedback";

	/**
	 * Load Categorie By Id
	 */
	public static final String LOAD_CATEGORIE_BY_ID = "loadCategorie/{id}";
	/**
	 * Ajouter une Categorie
	 */
	public static final String ADD_CATEGORIE = "addCategorie";

	/**
	 * delete Categorie
	 */
	public static final String DELETE_CATEGORIE = "deleteCategorie/{id}";

	/**
	 * Load Feedback by id Categorie
	 */
	public static final String LOAD_FEEDBACK_BY_ID_CATEGORIE = "loadFeedbackByIdCategorie/{id}";

	/**
	 * chercher Feedback par mot cles
	 */

	public static final String LOAD_FEEDBACK_PAR_MOT_CLES = "chercherFeedbackAvecMotCles/{mc}";

	/**
	 * Aficher tout les categorie
	 */
	public static final String LOAD_CATEGORIE = "loadAllCategorie";
	/**
	 * jointure fichier
	 */
	public static final String UPLOAD_FILE = "uploadFile/{id}";

	/**
	 * Afficher les feedbacks par id user
	 */
	public static final String LOAD_FEEDBACK_BY_ID_USER="loadFeedbackByIdUser/{id}";


	/**
	 * Load feedback publique
	 */
	public static final String LOAD_FEEDBACK_PUBLIC="loadFeedabackPubique";
	/**
	 * Nombre de proposition
	 */
	public static final String NMBR_PROPOSITION="nmbrProposition/{idUser}";
	
	/**
	 * Nombre d'anomalie
	 */
	public static final String NMBR_ANOMALIE="nmbrAnomalie/{idUser}";
	/**
	 * Nombre Proposition Publique
	 */
		public static final String NMBR_PROPOSITION_PUBLIQUE="nmbrPropostionPublique";
		
		/**
		 * Nombre Anomalie Publique
		 */
		public static final String NMBR_ANOMALIE_PUBLIQUE="nmbrAnomaliePublique";

		/**
		 * Afficher tout les feedback
		 */
		public static final String LOAD_FEEDBACK = "loadAllFeedback";

		/**
		 * Afficher tout les utilisateur
		 */
		public static final String LOAD_ALL_USER="loadAllUser";
		
		/**
		 * Load user by Loggin
		 */
		public static final String LOGIN="login";

		/**
		 * find User By Id
		 */
		public static final String LOAD_USER_BY_ID="loqdUserById/{id}";

		/**
		 *stat proposition
		 */
		public static final String StatistiquePrososition="GetStatistiqueProp";
		/**
		 *stat anomalie
		 */
		public static final String StatistiqueAnomalie="GetStatistiqueanomalie";
		/**
		 *Key anomalie
		 */
		public static final String LoadKey="KeyStatistique";
		/**
		 *Key anomalie
		 */
		public static final String LoadKeyProposition="KeyStatistiqueProposition";
		/**
		 *value anomalie
		 */
		public static final String LoadValueAnomalie="ValueAnomalieStat";
		/**
		 *value proposition
		 */
		public static final String LoadValueProposition="ValuePropositionStat";
		
		

/**
		 * Afficher tout les feedbacks
		 */
		public static final String LOAD_ALL_FEEDBACK_FILE="loadAllfile";
		
		/**
		 * Upadate etat du feedback
		 */

		public static final String UPDATE_ETAT_FEEDBACK="upadetEtatFeedback/{id}/{etat}";
		
		public static final String DOWNLOAD_FILE = "/DownloadFile/FeedbackFile/{filename:.+}";
		
		/**
		 * Les feedbacks qui ont File
		**/
		
		public static final String FEEDBACKS_AVEC_FILE="feedbackAvecFile";
		
		public static final String LOAD_FEEDBACK_BY_ID_set="SetVisiblity/{id}";

		public static final String SET_ETAT_FEEDBACK = "SetEtat/{id}";

		public static final String SET_ETAT_FEEDBACK_PROPOSITION = "SetEtatProposition/{id}";

		public static final String SET_ETAT_FEEDBACK_PROPOSITION_Revoir = "SetPropositionRevoir/{id}";

		/**
		 * load All notification
		 */
		public static final String ALL_NOTIFICATION="loadNotif";
		
		/**
		 * Add Notification
		 */
		public static final String CREATE_NOTIF="addNotif";
		
		/**
		 * update etat Notif
		 */
		public static final String UPDATE_NOTIF="updateNotif/{id}/{etat}";
		
		/**
		 * les notif non Vu
		 */
		public static final String NOTIF_NON_VU="loadNotifNonVu";
		

		public static final String SET_ETAT_FEEDBACK_ANOMALIE = "SetEtatAnomalie/{id}";

		public static final String SET_ETAT_FEEDBACK_ANOMALIE_RESOLU = "SetAnomalieResolu/{id}";

		public static final String SET_ETAT_FEEDBACK_ANOMALIE2 = "SetEtatAnomalie2/{id}";
		
		public static final String NB_FEEDBACK_TRAITE = "getNBFeedbackTraite";

	


}
