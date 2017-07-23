package com.rubel.sms.dao;

import com.rubel.sms.model.Cart;
import com.rubel.sms.model.CartItem;
import com.rubel.sms.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rubel on 7/22/17.
 */
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    SessionFactory session;

    public void create(Cart cart) {
        session.getCurrentSession().save(cart);
    }

    public Cart read(Long id) {
        return (Cart) session.getCurrentSession()
                .createQuery("from Cart where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    public void update(Long id, Cart cart) {

        session.getCurrentSession().update(cart);

    }

    public void delete(Long id) {
        Cart cart = session.getCurrentSession().load(Cart.class, id);
        session.getCurrentSession().delete(cart);
    }

    public void addItem(Long cartId, Long productId) {
        Cart cart = (Cart) session.getCurrentSession()
                .createQuery("from Cart where id := id")
                .setParameter("id", cartId)
                .getSingleResult();

        Product product = (Product) session.getCurrentSession()
                .createQuery("from Product where id := id")
                .setParameter("id", productId)
                .getSingleResult();

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setCart(cart);
        session.getCurrentSession().saveOrUpdate(item);
    }

    public void removeItem(Long cartId, Long productId) {
        CartItem item = (CartItem) session.getCurrentSession()
                .createQuery("from Cart where productId := productId and cart_id := cart_id")
                .setParameter("cart_id", cartId)
                .setParameter("productId", productId)
                .getSingleResult();
        session.getCurrentSession().remove(item);
    }
}
