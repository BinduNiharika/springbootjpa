package com.asml.training.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.asml.training.model.Course;
import com.asml.training.model.TrainingEvent;
import com.asml.training.repository.AbstarctDao;



@Repository
public class TrainingEventDaoImpl extends AbstarctDao<TrainingEvent> {
	
public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    
/* 
 * @author binduniharika
 * 
 * This method
 * will return  list  of
 * TrainingEvent
 * 
 *  @since 2022-02-11
 * 
 *  @return named query This will return list of TrainingEvent
 *  
 *  @exception emptyList On List is empty
 */
	public List<TrainingEvent> getAll(){
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 TypedQuery<TrainingEvent> typedQuery = manager.createNamedQuery("TrainingEvent.findall",TrainingEvent.class);
		 return Optional.ofNullable(typedQuery.getResultList()).orElse(Collections.emptyList());
		
	}
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will  return list  of
	 * TrainingEvent by id
	 * 
	 * @since 2022-02-11 
	 *   @return named query This will return list of TrainingEvent
	 *     @exception emptyList On List is empty
	 */
	
	public List<TrainingEvent> getByEventId(Integer eventId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<TrainingEvent> namedQuery = manager.createNamedQuery("TrainingEvent.findbyid",TrainingEvent.class);
        namedQuery.setParameter("eventId",eventId);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will add details of TrainingEvent
	 * into the table
	 */
public void add(TrainingEvent event) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(event);
        tx.commit();

	}

}