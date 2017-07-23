package com.rubel.sms.controller;

import com.rubel.sms.model.Cart;
import com.rubel.sms.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rubel on 7/22/17.
 */
@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

    @Autowired
    CartService cartService;


    // create
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Cart cart){
        System.out.println("Cart: ");
        System.out.println(cart.getId());
        System.out.println(cart.getCartItems().size());
        cartService.create(cart);
    }

    // read
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public Cart read(@PathVariable(name = "cartId") Long cartId){
        return cartService.read(cartId);
    }

    // update
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable(name = "cartId") Long cartId, @RequestBody Cart cart){
        cartService.update(cartId, cart);
    }

    // delete
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(name = "cartId") Long cartId){
        cartService.delete(cartId);
    }

}
