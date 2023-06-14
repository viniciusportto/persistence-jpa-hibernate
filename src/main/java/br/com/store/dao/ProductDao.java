package br.com.store.dao;

import br.com.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em){
        this.em = em;
    }

    public void register(Product product){
        this.em.persist(product);
    }


}
