package br.com.store.test;

import br.com.store.model.Category;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;

public class ProductRegistration {

    public static void main(String[] args) {
        Category cellphones = new Category("CELLPHONES");

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(cellphones);
        cellphones.setName("Iphone 12" );

        em.getTransaction().commit();
        em.close();
    }

}
