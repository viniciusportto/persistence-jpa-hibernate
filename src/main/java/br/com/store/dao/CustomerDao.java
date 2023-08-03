package br.com.store.dao;

import br.com.store.model.Customer;
import br.com.store.model.Order;
import br.com.store.model.Product;

import javax.persistence.EntityManager;

public class CustomerDao {

    private EntityManager em;

    public CustomerDao(EntityManager em){
        this.em = em;
    }

    public void register(Customer customer){
        this.em.persist(customer);
    }

    public Customer findById(Long id){
        return em.find(Customer.class, id);
    }

}