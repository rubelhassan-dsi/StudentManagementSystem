package com.rubel.sms.dao;

import com.rubel.sms.model.Product;
import com.rubel.sms.util.NoProductsFoundUnderCategoryException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by rubel on 7/19/17.
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory session;

    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        return session.getCurrentSession().createQuery("from Product").list();
    }

    public Product saveOrUpdate(Product product) {
        session.getCurrentSession().saveOrUpdate(product);
        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAllByCatergory(String category) {
        return session.getCurrentSession().createQuery("from Product where category = :category")
                .setParameter("category", category)
                .list();
    }

    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return  session.getCurrentSession()
                .createQuery("from Product where category in :categories and " + "manufacturer in :manufacturers")
                .setParameter("categories", filterParams.get("categories"))
                .setParameter("manufacturers", filterParams.get("manufacturers"))
                .list();
    }

    public Product findById(Long id) {
        try {
            return (Product) session.getCurrentSession().createQuery("from Product where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (Exception e){
            throw new NoProductsFoundUnderCategoryException(Long.toString(id));
        }
    }
}
