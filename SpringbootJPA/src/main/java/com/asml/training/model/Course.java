package com.asml.training.model;

/* 
 * @author binduniharika
 * 
 * course class contains details 
 * 
 * @since 2022-02-09
 */

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;



import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@NamedQueries({
@NamedQuery(name="Course.findall",query = "select e from Course e "),
@NamedQuery(name="Course.findbyid",query = "select e from Course e where e.courseId=:courseId")
})
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	private String courseName;
	private Integer coursePrice;
	private Integer courseDuration;
	public Course() {
		super();
	}
	public Course(Integer courseId, String courseName, Integer coursePrice, Integer courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
	}
	@OneToOne(mappedBy = "course")
	private TrainingEvent trainingEvent;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="trainer_id",referencedColumnName = "trainerId")
	private Trainer trainer;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="student_course",
	joinColumns = @JoinColumn(name="course_id",referencedColumnName = "courseId"),
	inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "studentId"))
	private List<Student> students;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}
	public Integer getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}
	public TrainingEvent getTrainingEvent() {
		return trainingEvent;
	}
	public void setTrainingEvent(TrainingEvent trainingEvent) {
		this.trainingEvent = trainingEvent;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}