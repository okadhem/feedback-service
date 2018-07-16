package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.EmployeeDAO;
import com.talan.byblos.feedback.dao.FeedbackDAO;
import com.talan.byblos.feedback.service.CategorieService;
import com.talan.byblos.feedback.utility.mapping.FeedbackUtility;



@Repository("feedbackDAO")
public class FeedbackDAOImpl extends GenericDAOImpl<FeedbackDTO, FeedbackEntity> implements FeedbackDAO {

	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(FeedbackDAOImpl.class);
	
	@Autowired
	CategorieService catService ;
	
	@Autowired
	private EmployeeDAO EmplDAO;
	/**
	 * constructeur par defaut.
	 */
	public FeedbackDAOImpl() {
		super();
	}

	@Override
	public FeedbackEntity getEntityFromDTO(FeedbackDTO dto) {
		
	
		
		return FeedbackUtility.convertDtoToEntity(dto);
	}

	
	
	@Override
	public FeedbackDTO getDTOFromEntity(FeedbackEntity entity) {
	
		FeedbackDTO feedbackDTO= FeedbackUtility.convertEntityToDto(entity);
		convertEntityToDto(entity, feedbackDTO);
		return feedbackDTO;
	}

	@Override
	public List<FeedbackDTO> loadFeedbackByIdCategorie(Long idCategorie) {
		
		List<FeedbackDTO> feedbackDTOList=  new ArrayList<FeedbackDTO>();
		StringBuffer query = new StringBuffer("from FeedbackEntity fe where fe.categorie.id= ");
		query.append(idCategorie);
		List<FeedbackEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (FeedbackEntity entity: resultList) {
			feedbackDTOList.add(fullConvertEntity(entity));
		}
		
		return feedbackDTOList;
	}
	
	@Override
	public void setFeedbackVisibilityByID(Long id) throws ByblosDataAccessException {	
 getEntityManager().createQuery("update FeedbackEntity fe set fe.visibiliteFeedback=false where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedback(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='affecte' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedbackProposition(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='retenir' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedbackProposition2(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='revoir' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedbackAnomalie(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='confirmer' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedbackAnomalie2(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='nonconfirmer' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void setEtatFeedbackAnomalieResolu(Long id) throws ByblosDataAccessException {	
		getEntityManager().createQuery("update FeedbackEntity fe set fe.etatFeedback='resolu' where fe.id = :id").setParameter("id", id).executeUpdate();
	}

	
	@Override
	public List<FeedbackDTO> chercher(String mc) {
		List<FeedbackDTO> chercherFeedback = new ArrayList<FeedbackDTO>();
		
		StringBuffer query= new StringBuffer("select fe from FeedbackEntity fe where fe.contenuFeedback like ");
		query.append(mc);
		List<FeedbackEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for(FeedbackEntity entity: resultList) {
			chercherFeedback.add(fullConvertEntity(entity));
		}
		return chercherFeedback;
	}

	@Override
	public List<FeedbackDTO> loadFeedbackByIdUser(Long idUser) {
		List<FeedbackDTO> feedbackDTOList= new ArrayList<FeedbackDTO>();
		Query query = getEntityManager().createNamedQuery("FeedbackEntity.loadByIdUser");
		query.setParameter("idUser", idUser);
		List<FeedbackEntity> resultList= query.getResultList();
		for (FeedbackEntity entity: resultList) {
			feedbackDTOList.add(fullConvertEntity(entity));
		}
		
		return feedbackDTOList;
	}

	/**
	 * Afficher les feedback publique
	 */
	@Override
	public List<FeedbackDTO> loadFeedbackPublique() {
		List<FeedbackDTO> feedbackDTOList= new ArrayList<FeedbackDTO>();
		StringBuffer query= new StringBuffer("from FeedbackEntity c where c.visibiliteFeedback= true");
		List<FeedbackEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (FeedbackEntity entity: resultList) {
			feedbackDTOList.add(fullConvertEntity(entity));
		}
		
		return feedbackDTOList;
	}

	@Override
	public Long nmbrPropositionByIdUser(Long idUser) {
		StringBuffer query= new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='PROPOSITION' and employee.id = ");
		query.append(idUser);
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
	
		return result;
	}

	@Override
	public Long nmbrAnomaliByIdUser(Long idUser) {
		StringBuffer query= new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='ANOMALIE' and employee.id = ");
		query.append(idUser);
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
	
		return result;
	}


	@Override
	public Long nmbrPropositionPublique() {
		StringBuffer query = new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='PROPOSITION' and fe.visibiliteFeedback='true'");
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		
		return result;
	}

	@Override
	public Long nmbrAnomaliePublique() {
		StringBuffer query = new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='ANOMALIE' and fe.visibiliteFeedback='true'");
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		
		return result;
	}

	@Override
	public List<FeedbackDTO> loadFeedback() throws ByblosException {
//		Long count;
//		List<FeedbackDTO> feedbackDTOList = new ArrayList<FeedbackDTO>();
//		StringBuilder builder = new StringBuilder();
//		builder.append("select fe.id, fe.objetFeedback, fe.contenuFeedback, fe.anonymatFeedback, fe.etatFeedback,"
//				+ " fe.visibiliteFeedback, fe.categorie, fe.employee, fe.criticite, count(rep) as nbr_resp"
//				+ " from FeedbackEntity fe " + " left join ReponseEntity rep on rep.feedback.id = fe.id "
//				+ "group by fe.id ");
//		Query query = getEntityManager().createQuery(builder.toString());
//		List<Object> result = query.getResultList();
//
//		for (Object obj : result) {
//			Object[] row = (Object[]) obj;
//			FeedbackDTO feedbackDTO = new FeedbackDTO();
//			feedbackDTO.setIdFeedback(getLong(row[IntegerNumberConstant.C_0]));
//			feedbackDTO.setObjetFeedback(getString(row[IntegerNumberConstant.C_1]));
//			feedbackDTO.setContenuFeedback(getString(row[IntegerNumberConstant.C_2]));
//			feedbackDTO.setAnonymatFeedback(getBoolean(row[IntegerNumberConstant.C_3]));
//			feedbackDTO.setEtatFeedback(getString(row[IntegerNumberConstant.C_4]));
//			feedbackDTO.setVisibiliteFeedback(getBoolean(row[IntegerNumberConstant.C_5]));
//			feedbackDTO.setCriticite(getString(row[IntegerNumberConstant.C_7]));
//			feedbackDTO.setNombreReponse(getLong(row[IntegerNumberConstant.C_9]));
//			//load emplyee
//			EmployeeDTO emp = EmplDAO.load(getLong(row[IntegerNumberConstant.C_8]));
//			feedbackDTO.setEmployee(emp);
//			//load categorie
//			CategorieDTO categ = catService.loadCategorie(getLong(row[IntegerNumberConstant.C_6]));
//			feedbackDTOList.add(feedbackDTO);
//		}
//		return feedbackDTOList;
	
			List<FeedbackDTO> feedbackDTOList= new ArrayList<FeedbackDTO>();
			StringBuffer query = new StringBuffer("select fe from FeedbackEntity fe order by fe.dateCreation desc ");
			List<FeedbackEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
			for (FeedbackEntity entity: resultList) {
				feedbackDTOList.add(fullConvertEntity(entity));
				
			
			}
//		
			return feedbackDTOList;	
	
	}
	
	private EmployeeDTO loadEmployeeById(Long empId) {
		
		return null;
	}
	

	
public Long loadNbReponse(Long idFeedback) {
	

	Long  count = (long)  getEntityManager()
			.createQuery("SELECT count(rep) FROM ReponseEntity rep where rep.feedback.id= :idFeedback")
			.setParameter("idFeedback", idFeedback)
			.getSingleResult();
	System.out.println(count);
	return  count;	}
	
	@Override
	public Long nmbrProposition() {
		StringBuffer query = new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='PROPOSITION'");
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		
		return result;
	}

	@Override
	public Long nmbrAnomalie() {
		StringBuffer query = new StringBuffer("select count(fe) from FeedbackEntity fe where fe.categorie.typeCategorie='ANOMALIE'");
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		
		return result;
	}
	@Override
	public Long nmbrFeedbacks() {
		StringBuffer query = new StringBuffer("select count(fe) from FeedbackEntity fe");
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		
		return result;
	}

	@Override
	public List<String> StatPerMonthKey() {
		List<String> key = new ArrayList<String>();
		StringBuffer query = new StringBuffer("SELECT CONCAT(to_char(f.dateCreation ,'Mon'),EXTRACT(YEAR FROM f.dateCreation)) FROM FeedbackEntity f where f.categorie.typeCategorie='ANOMALIE' GROUP BY to_char(f.dateCreation,'Mon'),EXTRACT(YEAR FROM f.dateCreation),date_part('month', f.dateCreation) ORDER BY date_part('month', f.dateCreation)");
		List<String> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (String k: resultList) {
			key.add(k);
		}
		return key;	
	}

	
	@Override
	public List<String> StatPerMonthKeyProp() {
		List<String> key = new ArrayList<String>();
		StringBuffer query = new StringBuffer("SELECT CONCAT(to_char(f.dateCreation ,'Mon'),EXTRACT(YEAR FROM f.dateCreation)) FROM FeedbackEntity f where f.categorie.typeCategorie='PROPOSITION' GROUP BY to_char(f.dateCreation,'Mon'),EXTRACT(YEAR FROM f.dateCreation),date_part('month', f.dateCreation) ORDER BY date_part('month', f.dateCreation)");
		List<String> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (String k: resultList) {
			key.add(k);
		}
		return key;	
	}

	
	@Override
	public List<Long> StatPerMonthValue() {
		List<Long> key = new ArrayList<Long>();
		StringBuffer query = new StringBuffer("SELECT COUNT(*) FROM FeedbackEntity f where f.categorie.typeCategorie='ANOMALIE' GROUP BY to_char(f.dateCreation,'Mon'),EXTRACT(YEAR FROM f.dateCreation),date_part('month', f.dateCreation) ORDER BY date_part('month', f.dateCreation)"); 
				
		List<Long> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (Long k: resultList) {
			key.add(k);
		}
		return key;	
	}

	@Override
	public List<Long> StatPerMonthValueProposition() {
		List<Long> key = new ArrayList<Long>();
		StringBuffer query = new StringBuffer("SELECT COUNT(*) FROM FeedbackEntity f where f.categorie.typeCategorie='PROPOSITION' GROUP BY to_char(f.dateCreation,'Mon'),EXTRACT(YEAR FROM f.dateCreation),date_part('month', f.dateCreation) ORDER BY date_part('month', f.dateCreation)"); 
				
		List<Long> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (Long k: resultList) {
			key.add(k);
		}
		return key;	
	}

	@Override
	public long nbFeedbacksTraite() {
		Long  count = (long)  getEntityManager()
				.createQuery("SELECT count(f) FROM FeedbackEntity f where f.etatFeedback='retenir' or f.etatFeedback='resolu'").getSingleResult();
	
		return  count;
	}




}
