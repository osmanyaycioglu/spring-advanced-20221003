package com.training.spring.advanced.customer.data;

import com.training.spring.advanced.customer.services.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

// @Service
public class CustomerEntityDao {

    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void insertCustomerSpring(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.joinTransaction();
        entityManager.persist(customer);
    }


    public void insertCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction()
                     .begin();
        try {
            entityManager.persist(customer);
            customer.setSurname("dsf");
            entityManager.getTransaction()
                         .commit();
        } catch (Exception exp) {
            entityManager.getTransaction()
                         .rollback();
        }

    }

}
