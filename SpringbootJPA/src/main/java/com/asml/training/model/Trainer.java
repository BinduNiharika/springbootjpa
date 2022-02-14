package com.asml.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="tbl_trainer",
uniqueConstraints = @UniqueConstraint(name="temailid_unique",columnNames ="trainer_email")
)
@NamedQueries({
@NamedQuery(name="Trainer.findall",query = "select e from Trainer e "),
@NamedQuery(name="Trainer.findbyemail",query = "select e from Trainer e where e.trainerEmail=:trainerEmail")
})
/* 
 * @author binduniharika
 * 
 * Trainer class contains details 
 * Trainers
 * 
 *@since 2022-02-09
 */
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainerId;
	private String trainerName;
	@Column(name="trainer_email",nullable=false)
	private String trainerEmail;
	public Trainer() {
		super();
	}
	
	public Trainer(Integer trainerId, String trainerName, String trainerEmail) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
	
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="event_id",referencedColumnName = "eventId")
	private TrainingEvent trainingEvent;
	
	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public TrainingEvent getTrainingEvent() {
		return trainingEvent;
	}

	public void setTrainingEvent(TrainingEvent trainingEvent) {
		this.trainingEvent = trainingEvent;
	}

	
	
	
}