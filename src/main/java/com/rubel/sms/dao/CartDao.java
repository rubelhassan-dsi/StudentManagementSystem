package com.rubel.sms.dao;

import com.rubel.sms.model.Cart;

/**
 * Created by rubel on 7/22/17.
 */
public interface CartDao {

    void create(Cart cart);
    Cart read(Long id);
    void update(Long id, Cart cart);
    void delete(Long id);
    void addItem(Long cartId, Long productId);
    void removeItem(Long cartId, Long productId);

}
