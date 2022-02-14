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
import com.asml.training.model.Student;
import com.asml.training.model.Trainer;
import com.asml.training.model.TrainingEvent;
import com.asml.training.repository.AbstarctDao;




@Repository
public class TrainerDaoImpl extends AbstarctDao<Trainer>{
	
public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
/* 
 * @author binduniharika
 * 
 * This  method
 * will  return list  of Trainer
 * 
 * @since 2022-02-11
 * 
 *  @return named query This will return list of Trainers
 *  
 *  @exception emptyList On List is empty
 */
	public List<Trainer> getAll(){
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 TypedQuery<Trainer> typedQuery = manager.createNamedQuery("Trainer.findall",Trainer.class);
		 return Optional.ofNullable(typedQuery.getResultList()).orElse(Collections.emptyList());
		
	}
	/* 
	 * @author binduniharika
	 * 
	 *  This  method
	 * will return  list  of
	 *  Trainer by email
	 *  
	 *  @since 2022-02-11
	 *  
     * @return named query This will return list of trainers
     * 
     * @exception emptyList On List is empty
	 */
	
	public List<Trainer> getByEmail(String trainerEmail) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Trainer> namedQuery = manager.createNamedQuery("Trainer.findbyemail",Trainer.class);
        namedQuery.setParameter("trainerEmail",trainerEmail);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
	
	/* 
	 * @author binduniharika
	 * 
	 * This method
	 * will add the details of trainer
	 * into table
	 * 
	 * @since 2022-02-11
	 */
	
public void add(Trainer trainer) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(trainer);
        tx.commit();

	}

}