package com.rubel.sms.service;

import com.rubel.sms.dao.ProductDao;
import com.rubel.sms.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by rubel on 7/19/17.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);
        return product;
    }

    public List<Product> findAllByCatergory(String category) {
        return productDao.findAllByCatergory(category);
    }

    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productDao.getProductsByFilter(filterParams);
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }
}
