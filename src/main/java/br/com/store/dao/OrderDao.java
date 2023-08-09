package br.com.store.dao;

import br.com.store.model.Order;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderDao {

    private EntityManager em;

    public OrderDao(EntityManager em){
        this.em = em;
    }

    public void register(Order order){
        this.em.persist(order);
    }

    public BigDecimal totalValueSold(){
        String jpql = "SELECT SUM(p.totalValue) FROM Order p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

}