package com.ego.cart.controller;

import com.ego.cart.pojo.Cart;
import com.ego.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart)
    {
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<Cart>> queryCart()
    {
        List<Cart> result = cartService.queryCart();
        if(result==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(result);
    }


    @PutMapping
    public ResponseEntity<Void> updateNum(@RequestBody Cart cart)
    {
        cartService.updateNum(cart);
        return ResponseEntity.ok(null);
    }


}
