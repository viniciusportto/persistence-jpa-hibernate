package br.com.store.test;

import br.com.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Product cellphone = new Product();
        cellphone.setName("IPhone 12");
        cellphone.setDescription("PRO MAX");
        cellphone.setPrice(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(cellphone);
        em.getTransaction().commit();
        em.close();
    }

}
