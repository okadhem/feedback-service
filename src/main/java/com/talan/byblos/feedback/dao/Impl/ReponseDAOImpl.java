package com.talan.byblos.feedback.dao.Impl;

import static org.mockito.Matchers.longThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.dto.UserDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.ReponseEntity;
import com.talan.byblos.common.entities.UserEntity;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.ReponseDAO;
import com.talan.byblos.feedback.utility.mapping.ReponseUtility;

@Repository("ReponseDAO")
public class ReponseDAOImpl extends GenericDAOImpl<ReponseDTO, ReponseEntity> implements ReponseDAO {

	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(ReponseDAOImpl.class);
	
	ReponseEntity rep;
	
	
	/**
	 * constructeur par defaut.
	 */
	public ReponseDAOImpl() {
		super();
	}
	
	
	@Override
	public ReponseEntity getEntityFromDTO(ReponseDTO dto) {
		
		return ReponseUtility.convertDtoToEntity(dto);
	}

	@Override
	public ReponseDTO getDTOFromEntity(ReponseEntity entity) {
		
		ReponseDTO reponseDTO = ReponseUtility.convertEntityToDTO(entity);
		convertEntityToDto(entity, reponseDTO);
		return reponseDTO;
	}
	
	/**
	 * Aficher tout les reponse
	 */
	@Override
	public List<ReponseDTO> loadAllReponse() {
		
		List<ReponseDTO> reponseDTOList= new ArrayList<ReponseDTO>();
		StringBuffer query= new StringBuffer("from ReponseEntity r ");
		List<ReponseEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (ReponseEntity entity: resultList) {
			reponseDTOList.add(fullConvertEntity(entity));
		}
		
		
		
		return reponseDTOList;
	}


	@Override
	public List<ReponseDTO> loadReponseByIdFeedback(Long idFeedback) {
		
		List<ReponseDTO> reponseDTOList= new ArrayList<ReponseDTO>();
		Query query = getEntityManager().createNamedQuery("ReponseEntity.loadReponseByIdFeedback");
		query.setParameter("idFeedback", idFeedback);
		List<ReponseEntity> resultList= query.getResultList();
		for (ReponseEntity entity: resultList) {
			reponseDTOList.add(fullConvertEntity(entity));
		}
		
		return reponseDTOList;
	}



	@Override
	public List<Long> feedbackAvecReponse() {
		List<Long> idFeedbackList = new ArrayList<Long>();
		StringBuffer query = new StringBuffer("select rep.feedback.id from ReponseEntity rep group by rep.feedback.id");
		List<Long> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (Long entity: resultList) {
			idFeedbackList.add(entity);
		}
		return idFeedbackList;
	}


	@Override
	public List<String> loadEmployeeNames() {
		List<String> key = new ArrayList<String>();
		StringBuffer query = new StringBuffer("select e.login from UserEntity e where e.login like '%support%'  ");
		List<String> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (String k: resultList) {
			if(k!=null) {
			key.add(k);}
		}
		return key;	
	}


	@Override
	public Long loadEmployeeByName(String Name) throws ByblosException {
		StringBuilder buildQuery = new StringBuilder();
		Long id =0L ;
		buildQuery.append("select e.personnel.id from UserEntity e  where e.login=:Name ");
		Query query = getEntityManager().createQuery(buildQuery.toString());
		query = query.setParameter("Name", Name);
		System.out.println("aaaaa"+ query.getSingleResult());

		try {
			id = (Long) query.getSingleResult();
		} catch (NonUniqueResultException e) {
		} catch (NoResultException e) {
		}
		System.out.println("aaaaa"+id);
		return id;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReponseFeedbackDTO> loadNbReponse1() {
		List<ReponseFeedbackDTO> reponseDTOList= new ArrayList<ReponseFeedbackDTO>();
		StringBuffer query = new StringBuffer("select id_feedback, count(*) from ref_reponse group by id_feedback");
		List<Object[]> resources = getEntityManager().createNativeQuery(query.toString()).getResultList();
	
		for (Object[] obj : resources) {
			ReponseFeedbackDTO rep = new ReponseFeedbackDTO();
			rep.setFeedbackDTO(getLong(obj[0]));
			rep.setNbrRep(getLong(obj[1])); 
			reponseDTOList.add(rep);
		}
		return reponseDTOList;



	}


	@Override
	public List<Long> feedbackPublicAvecReponse() {
		List<Long> idFeedbackList = new ArrayList<Long>();
		StringBuffer query = new StringBuffer("select rep.feedback.id from ReponseEntity rep where rep.feedback.visibiliteFeedback = True  group by rep.feedback.id");
		List<Long> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (Long entity: resultList) {
			idFeedbackList.add(entity);
		}
		return idFeedbackList;
	}


	@Override
	public List<Long> feedbackPersonelAvecReponse(Long id) {
		List<Long> idFeedbackList = new ArrayList<Long>();
		StringBuilder buildQuery = new StringBuilder();
		
		buildQuery.append("select rep.feedback.id from ReponseEntity rep where rep.personnel.id= :id group by rep.feedback.id");
		Query query = getEntityManager().createQuery(buildQuery.toString());
		query = query.setParameter("id", id);
		List<Long> resultList= query.getResultList();
		for (Long entity: resultList) {
			idFeedbackList.add(entity);
		}
		return idFeedbackList;
	}
 

	
	
	

}

