package br.com.store.test;

import br.com.store.dao.CategoryDao;
import br.com.store.dao.ProductDao;
import br.com.store.model.Category;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {

    public static void main(String[] args) {
        registerProduct();
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        Product p = productDao.findById(1L);
        System.out.println(p.getPrice());

        List<Product> all = productDao.findByCategory("CELLPHONES");
        all.forEach(p2 -> System.out.println(p.getName()));

        BigDecimal productPrice = productDao.findByPriceWithName("Iphone 13");
        System.out.println("Product price: " + productPrice);
    }

    private static void registerProduct() {
        Category cellphones = new Category("CELLPHONES");
        Category laptop = new Category("Laptop");
        Product cellphone = new Product("Iphone 13", "very cool", new BigDecimal("800"), cellphones);


        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        em.getTransaction().begin();

        categoryDao.register(cellphones);
        productDao.register(cellphone);

        em.getTransaction().commit();
        em.close();
    }
}