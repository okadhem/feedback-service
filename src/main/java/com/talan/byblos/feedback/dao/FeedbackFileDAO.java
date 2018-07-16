package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.entities.FeedbackFilesEntity;

public interface FeedbackFileDAO extends GenericDAO<FeedbackFileDTO, FeedbackFilesEntity>{
	
	
    List<FeedbackFileDTO> loadAllFile();
	
	/**
	 * Les feedback qui ont des file
	 */
	List<Long> feedbackAvecfile();


}
