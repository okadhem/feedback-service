package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.entities.AffectationReponseEntity;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.feedback.dao.AffectationReponseDAO;
import com.talan.byblos.feedback.dao.AvisDAO;
import com.talan.byblos.feedback.utility.mapping.AffectationReponseUtility;
import com.talan.byblos.feedback.utility.mapping.AvisUtility;

@Repository("AffectationReponseDAO")
public class AffectationReponseDAOImpl extends GenericDAOImpl<AffectationReponseDTO, AffectationReponseEntity> implements AffectationReponseDAO{

	@Override
	public AffectationReponseEntity getEntityFromDTO(AffectationReponseDTO dto) {
		return AffectationReponseUtility.convertDtoToEntity(dto);
	}

	@Override
	public AffectationReponseDTO getDTOFromEntity(AffectationReponseEntity entity) {
		return AffectationReponseUtility.convertEntityToDto(entity);
	}

	@Override
	public List<AffectationReponseDTO> loadAffectationByFeedback(Long idFeed) {
		List<AffectationReponseDTO> AffectationDTOList=  new ArrayList<AffectationReponseDTO>();
		StringBuffer query = new StringBuffer("from AffectationReponseEntity fe where fe.feedback.id= ");
		query.append(idFeed);
		List<AffectationReponseEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (AffectationReponseEntity entity: resultList) {
			AffectationDTOList.add(fullConvertEntity(entity));
		}
		
		return AffectationDTOList;
	}

	@Override
	public Long CheckifExists(long feedback, long employee) {
		
		Long  count = (long)  getEntityManager()
				.createQuery("SELECT count(rep) FROM AffectationReponseEntity rep where rep.feedback.id= :idFeedback and rep.employee.id=:employee")
				.setParameter("idFeedback", feedback ).setParameter("employee", employee)
				.getSingleResult();
		System.out.println(count);
		return  count;
	}

	
	
	@Override
	public void deleteAffectation(long feedback, long employee) {
		 getEntityManager().createQuery("DELETE from AffectationReponseEntity a where a.feedback.id= :feedback and a.employee.id= :employee").
		 setParameter("employee", employee).setParameter("feedback", feedback).executeUpdate();				
	}
	
	

}
