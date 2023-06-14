package br.com.store.test;

import br.com.store.dao.ProductDao;
import br.com.store.model.Category;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Product cellphone = new Product("IPhone 12", "PRO MAX", new BigDecimal("800"),Category.CELLPHONES);

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);

        dao.register(cellphone);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }

}
