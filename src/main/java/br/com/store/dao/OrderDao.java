package br.com.store.dao;

import br.com.store.model.Order;

import javax.persistence.EntityManager;

public class OrderDao {

    private EntityManager em;

    public OrderDao(EntityManager em){
        this.em = em;
    }

    public void register(Order order){
        this.em.persist(order);
    }

}