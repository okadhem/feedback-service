package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.entities.FeedbackFilesEntity;
import com.talan.byblos.feedback.dao.FeedbackFileDAO;
import com.talan.byblos.feedback.utility.mapping.FeedbackFileUtility;

@Repository("FeedbackFileDAO")
public class FeedbackFileDAOimpl extends GenericDAOImpl<FeedbackFileDTO, FeedbackFilesEntity>
		implements FeedbackFileDAO {

	@Override
	public FeedbackFilesEntity getEntityFromDTO(FeedbackFileDTO dto) {
		// TODO Auto-generated method stub
		return FeedbackFileUtility.convertDtoToEntity(dto);
	}

	@Override
	public FeedbackFileDTO getDTOFromEntity(FeedbackFilesEntity entity) {
		// TODO Auto-generated method stub
		return FeedbackFileUtility.convertEntityToDto(entity);
	}

	@Override
	public List<FeedbackFileDTO> loadAllFile() {
		List<FeedbackFileDTO> feedbackFileDTOList= new ArrayList<>();
		StringBuffer query = new StringBuffer("from FeedbackFilesEntity fe ");
		List<FeedbackFilesEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (FeedbackFilesEntity entity: resultList) {
			feedbackFileDTOList.add(fullConvertEntity(entity));
		}
		return feedbackFileDTOList;
	}

	@Override
	public List<Long> feedbackAvecfile() {
		List<Long> idFeedbackList = new ArrayList<Long>();
		StringBuffer query = new StringBuffer("select f.feedbackEntity.id from FeedbackFilesEntity f group by f.feedbackEntity.id");
		List<Long> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (Long entity: resultList) {
			idFeedbackList.add(entity);
		}
		return idFeedbackList;
	}

}
