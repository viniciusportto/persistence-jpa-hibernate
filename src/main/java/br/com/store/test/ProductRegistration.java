package br.com.store.test;

import br.com.store.dao.CategoryDao;
import br.com.store.dao.ProductDao;
import br.com.store.model.Category;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Category cellphones = new Category("CELLPHONES");
        Product cellphone = new Product("IPhone 12", "PRO MAX", new BigDecimal("800"), cellphones);

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao produtoDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);


        em.getTransaction().begin();

        categoryDao.register(cellphones);
        produtoDao.register(cellphone);

        em.getTransaction().commit();
        em.close();
    }

}
