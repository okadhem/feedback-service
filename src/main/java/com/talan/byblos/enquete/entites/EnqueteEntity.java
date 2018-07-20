package com.talan.byblos.enquete.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.talan.byblos.common.constants.ModelConstant;
import com.talan.byblos.common.entities.SubAbstractEntity;



@Entity
@Table(name = "ref_enquete", schema = ModelConstant.SCHEMA)
public class EnqueteEntity extends SubAbstractEntity{
	    
		/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id_enquete")
	    private long id;
		

		@Column(name = "nom")
		private String name;
		@Column(name = "date_expiration" ) 
		private Date expirationDate;
		
		@OneToMany(cascade = CascadeType.ALL)
		
		private List<QuestionEntity> questionEntities = new ArrayList<>();
		
		
		
		
		
		public void addQuestion(QuestionEntity q)
		{
			questionEntities.add(q);
			
		}
		
		
		// getters and setters
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}
		public List<QuestionEntity> getQuestions() {
			return questionEntities;
		}
		public void setQuestions(List<QuestionEntity> questionEntities) {
			this.questionEntities = questionEntities;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
}
