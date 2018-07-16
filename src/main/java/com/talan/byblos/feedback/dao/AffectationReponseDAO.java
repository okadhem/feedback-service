package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.entities.AffectationReponseEntity;

public interface AffectationReponseDAO extends GenericDAO<AffectationReponseDTO, AffectationReponseEntity>{
List<AffectationReponseDTO> loadAffectationByFeedback(Long idFeed);

public Long CheckifExists(long feedback , long employee);

public void deleteAffectation(long feedback , long employee );

}
