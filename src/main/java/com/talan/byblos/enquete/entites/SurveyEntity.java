package com.talan.byblos.enquete.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.talan.byblos.common.constants.ModelConstant;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.SubAbstractEntity;



@Entity
@Table(name = "ref_survey", schema = ModelConstant.SCHEMA)
public class SurveyEntity extends SubAbstractEntity{
	    
		/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
		

		
		private String title;
		
		private String description;
		
		@ManyToMany
		private List<EmployeeEntity> visibility;
		
		private Date expirationDate;
		
		@ManyToOne
		private EmployeeEntity owner;
		
		@OneToMany(cascade = CascadeType.ALL)
		private List<QuestionEntity> questions = new ArrayList<>();
		
		
		
		
		
		public void addQuestion(QuestionEntity q)
		{
			questions.add(q);
			
		}
		
		
		// getters and setters
		
		
		public Date getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}
		public List<QuestionEntity> getQuestions() {
			return questions;
		}
		public void setQuestions(List<QuestionEntity> questionEntities) {
			this.questions = questionEntities;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public List<EmployeeEntity> getVisibility() {
			return visibility;
		}


		public void setVisibility(List<EmployeeEntity> visibility) {
			this.visibility = visibility;
		}


		public EmployeeEntity getOwner() {
			return owner;
		}


		public void setOwner(EmployeeEntity owner) {
			this.owner = owner;
		}


		public List<QuestionEntity> getQuestionEntities() {
			return questions;
		}


		public void setQuestionEntities(List<QuestionEntity> questionEntities) {
			this.questions = questionEntities;
		}
		
}
