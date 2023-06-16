package br.com.store.dao;

import br.com.store.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em){
        this.em = em;
    }

    public void register(Product product){
        this.em.persist(product);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        String jpql = "SELECT p FROM Product p";
        return em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findByName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findByCategory(String name){
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }


}
