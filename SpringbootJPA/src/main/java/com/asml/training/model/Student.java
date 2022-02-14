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
 import javax.persistence.OneToOne;
 import javax.persistence.Table;
 import javax.persistence.UniqueConstraint;

 import lombok.Data;
 import lombok.ToString;

 @Entity
 @Data
 @ToString
 @Table(name="tbl_student",
 uniqueConstraints = @UniqueConstraint(name="emailid_unique",columnNames ="student_email")
 )
 @NamedQueries({
 @NamedQuery(name="Student.findall",query = "select e from Student e "),
 @NamedQuery(name="Student.findbyid",query = "select e from Student e where e.studentName=:studentName")
 })
 /* 
  * @author binduniharika
  * 
  * student class contains
  * student information
  * 
  *@since 2022-02-09
  */
 public class Student {
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer studentId;
 	private String studentName;
 	
 	@Column(name="student_email", nullable = false)
 	private String studentEmail;
 	public Student() {
 		super();
 	}
 	
 	public Student(Integer studentId, String studentName, String studentEmail) {
 		super();
 		this.studentId = studentId;
 		this.studentName = studentName;
 		this.studentEmail = studentEmail;
 	}
 	
 	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
 	@JoinColumn(name="trainer_id",referencedColumnName = "trainerId")
 	private Trainer trainer;
 	
 	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 	@JoinColumn(name="event_id",referencedColumnName = "eventId")
 	private TrainingEvent trainingEvent;
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public TrainingEvent getTrainingEvent() {
		return trainingEvent;
	}

	public void setTrainingEvent(TrainingEvent trainingEvent) {
		this.trainingEvent = trainingEvent;
	}
	


 }