package com.rubel.sms.service;

import com.rubel.sms.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by rubel on 7/19/17.
 */
public interface ProductService {
    List<Product> findAll();
    Product saveOrUpdate(Product product);
    List<Product> findAllByCatergory(String category);
    List<Product> getProductsByFilter(Map<String,List<String>>
                                              filterParams);
    Product findById(Long id);
}
