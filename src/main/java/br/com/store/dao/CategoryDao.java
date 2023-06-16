package br.com.store.dao;

import br.com.store.model.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager em;

    public CategoryDao(EntityManager em){
        this.em = em;
    }

    public void register(Category category){
        this.em.persist(category);
    }

    public void update(Category category){
        this.em.merge(category);
    }

    public void remove(Category category){
        this.em.remove(category);
    }
}