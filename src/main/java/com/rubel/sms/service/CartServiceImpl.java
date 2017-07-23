package com.rubel.sms.service;

import com.rubel.sms.dao.CartDao;
import com.rubel.sms.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubel on 7/23/17.
 */
@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    public void create(Cart cart) {
        cartDao.create(cart);
    }

    public Cart read(Long id) {
        return cartDao.read(id);
    }

    public void update(Long id, Cart cart) {
        Cart cart1 = null;

        try {
            cart1 = cartDao.read(id);
        }catch (Exception e){
            System.out.println("No cart found.");
        }

        if(cart1 != null)
            cartDao.update(id, cart);
    }

    public void delete(Long id) {
        cartDao.delete(id);
    }

    public void addItem(Long cartId, Long productId) {
        cartDao.addItem(cartId, productId);
    }

    public void removeItem(Long cartId, Long productId) {
        cartDao.removeItem(cartId, productId);
    }
}
