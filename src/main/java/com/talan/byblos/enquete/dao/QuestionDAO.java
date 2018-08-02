package com.talan.byblos.enquete.dao;



import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.entites.QuestionEntity;

public interface QuestionDAO extends GenericDAO<QuestionDTO, QuestionEntity> {

	List<ResponseDTO> findAllAnswersByQuestionId(long id);
	
	

	
}
