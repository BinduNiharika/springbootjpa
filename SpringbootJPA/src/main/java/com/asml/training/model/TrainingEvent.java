package com.asml.training.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@NamedQueries({
@NamedQuery(name="TrainingEvent.findall",query = "select e from TrainingEvent e "),
@NamedQuery(name="TrainingEvent.findbyid",query = "select e from TrainingEvent e where e.eventId=:eventId")
})
/* 
 * @author binduniharika
 * 
 * TrainingEvent class contains details 
 * of duration of course
 * 
 *@since 2022-02-09
 */
public class TrainingEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;
	private Integer startDate;
	private Integer endDate;
	public TrainingEvent() {
		super();
	}
	public TrainingEvent(Integer eventId, Integer startDate, Integer endDate) {
		super();
		this.eventId = eventId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",referencedColumnName = "courseId")
	private Course course;
	
	@OneToOne(mappedBy = "trainingEvent")
  private Trainer trainer;
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Integer getStartDate() {
		return startDate;
	}
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}
	public Integer getEndDate() {
		return endDate;
	}
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	
}