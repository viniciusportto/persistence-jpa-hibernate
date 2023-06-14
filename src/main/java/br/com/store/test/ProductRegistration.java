package br.com.store.test;

import br.com.store.dao.ProductDao;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Product cellphone = new Product();
        cellphone.setName("IPhone 12");
        cellphone.setDescription("PRO MAX");
        cellphone.setPrice(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);

        dao.register(cellphone);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }

}
