package br.com.store.test;

import br.com.store.dao.CategoryDao;
import br.com.store.dao.CustomerDao;
import br.com.store.dao.OrderDao;
import br.com.store.dao.ProductDao;
import br.com.store.model.*;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderRegistration {

    public static void main(String[] args) {
        registerDataBase();
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CustomerDao customerDao = new CustomerDao(em);

        Product product = productDao.findById(1l);
        Customer customer = customerDao.findById(1l);

        em.getTransaction().begin();

        Order order = new Order(customer);
        order.addOrder(new ItemOrder(10, order, product));

        OrderDao orderDao = new OrderDao(em);
        orderDao.register(order);

        em.getTransaction().commit();

        BigDecimal totalSold = orderDao.totalValueSold();
        System.out.printf("TOTAL VALUE: " + totalSold );
    }

    private static void registerDataBase() {
        Category cellphones = new Category("CELLPHONES");
        Product cellphone = new Product("Iphone 13", "very cool", new BigDecimal("800"), cellphones);
        Customer customer = new Customer("Vinicius", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        CustomerDao customerDao = new CustomerDao(em);

        em.getTransaction().begin();

        categoryDao.register(cellphones);
        productDao.register(cellphone);
        customerDao.register(customer);

        em.getTransaction().commit();
        em.close();
    }
}
