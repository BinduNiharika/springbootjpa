package com.asml.training.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstarctDao<T> {
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    public void add(T e){
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();
    }

    public void update(T e){
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.merge(e);
    }


}


