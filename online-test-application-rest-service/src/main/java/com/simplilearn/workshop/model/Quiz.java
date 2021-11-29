package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String questionnum;
	private String questiondesc;
	private String answer;
	
	public Quiz() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionnum() {
		return questionnum;
	}

	public void setQuestionnum(String questionnum) {
		this.questionnum = questionnum;
	}

	public String getQuestiondesc() {
		return questiondesc;
	}

	public void setQuestiondesc(String questiondesc) {
		this.questiondesc = questiondesc;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	

}
