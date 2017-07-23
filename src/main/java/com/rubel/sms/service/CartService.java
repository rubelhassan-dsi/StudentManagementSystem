package com.rubel.sms.service;

import com.rubel.sms.model.Cart;

/**
 * Created by rubel on 7/23/17.
 */
public interface CartService {

    void create(Cart cart);
    Cart read(Long id);
    void update(Long id, Cart cart);
    void delete(Long id);
    void addItem(Long cartId, Long productId);
    void removeItem(Long cartId, Long productId);

}
