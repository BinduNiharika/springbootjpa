package com.asml.training.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


import com.asml.training.model.Student;
import com.asml.training.repository.AbstarctDao;



@Repository
public class StudentDaoImpl extends AbstarctDao<Student> {
	
public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    
/* 
 * @author binduniharika
 * 
 * This method
 * will  return list of
 * student details
 * 
 * @since 2022-02-10
 * @return named query This will return list of students
 * @exception emptyList On List is empty
 * 
 */

	public List<Student> getAll(){
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 TypedQuery<Student> typedQuery = manager.createNamedQuery("Student.findall",Student.class);
		 return Optional.ofNullable(typedQuery.getResultList()).orElse(Collections.emptyList());
		
	}
	
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will  return list 
	 * students details by name
	 * @since 2022-02-10
	 *  @return named query This will return list of students
	 *  @exception emptyList On List is empty
	 */
	public List<Student> getByName(String studentName) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Student> namedQuery = manager.createNamedQuery("Student.findbyid",Student.class);
        namedQuery.setParameter("studentName",studentName);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
	/* 
	 * @author binduniharika
	 * 
	 * This method will  return list  of
	 * student details by Id
	 * 
	 * @since 2022-02-10
	 *  @return named query This will return list of students
	 *   @exception emptyList On List is empty
	 */
	public List<Student> getStudentId(Integer  studentId){
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder criteriaBuilder=manager.getCriteriaBuilder();
    	CriteriaQuery criteriaQuery=criteriaBuilder.createQuery();
    	Root<Student> studentRoot = criteriaQuery.from(Student.class);
    	  criteriaQuery.select(studentRoot).where(criteriaBuilder.equal(studentRoot.get("studentId"),1));
    	TypedQuery<Student> typedQuery =manager.createQuery(criteriaQuery);
    	
    	return Optional.ofNullable(typedQuery.getResultList()).orElse(Collections.emptyList());

		
	}
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will add details of students 
	 * into the table
	 * 
	 * @since 2022-02-10
	 */
	
public void add(Student student) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(student);
        tx.commit();

	}

}