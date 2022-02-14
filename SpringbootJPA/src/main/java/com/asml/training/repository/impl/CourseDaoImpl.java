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

import com.asml.training.exception.NotFoundException;
import com.asml.training.model.Course;
import com.asml.training.repository.AbstarctDao;


@Repository
public class CourseDaoImpl extends AbstarctDao<Course> {
	public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
	/* 
	 * @author binduniharika
	 * 
	 * This method 
	 * will  return list of course details
	 * 
	 *  @since 2022-02-10
	 *  @return named query This will return list of courses
	 *   @exception emptyList On List is empty
	 *
	 */
	public List<Course> getAll(){
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 TypedQuery<Course> typedQuery = manager.createNamedQuery("Course.findall", Course.class);
		 return Optional.ofNullable(typedQuery.getResultList()).orElse(Collections.emptyList());
		
	}
	
	/* 
	 * @author binduniharika
	 * 
	 * This  return list of  
	 * course details by courseId
	 * 
	 * @since 2022-02-10
	 *  
	 *  @return named query This will return list of courses
	 *  
	 * @exception emptyList On List is empty
	 *
	 *
	 */
	public List<Course> getById(Integer courseId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Course> namedQuery = manager.createNamedQuery("Course.findbyid",Course.class);
        namedQuery.setParameter("courseId",courseId);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
	
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will  return list  of
	 * course between the price
	 * 
	 * @since 2022-02-10
	 * @return named query This will return list of courses
	 *  @exception NotFoundException On List is empty
	 *
	 * 
	 */
	
public List<Course> findByCoursePrice(Integer coursePrice) throws NotFoundException {
		
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder criteriaBuilder=manager.getCriteriaBuilder();
    	CriteriaQuery criteriaQuery=criteriaBuilder.createQuery();
    	Root<Course> course=criteriaQuery.from(Course.class);
        criteriaQuery.select(course).where(criteriaBuilder.between(course.get("coursePrice"),200,300));
    	TypedQuery<Course> query=manager.createQuery(criteriaQuery);
    	return Optional.ofNullable(query.getResultList()).orElseThrow( ()-> new NotFoundException("course not found"));


	}

/* 
 * @author binduniharika
 * 
 * This method will
 * add the course details 
 * into the table
 */
public void add(Course course) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(course);
        tx.commit();

	}

}
