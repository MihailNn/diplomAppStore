package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Cart;
import iba.group.diplomAppStore.domain.Stamp;
import iba.group.diplomAppStore.repository.StampRepository;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class CartController {
    private final StampRepository stampRepository;

    public CartController(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @ModelAttribute //вызывается Springом каждый раз перед вызовом addTocart
    Cart populateCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping("/cart")
    public String addToCart(@RequestParam(required = false) Long stampId, Cart cart) {
        if(stampId != null) {
            stampRepository.findById(stampId).ifPresent(stamp -> cart.getStamps().add(stamp));
        }
        return "cart";
    }


//    @Getter
//    @Data
//    public static class Cart {
//        Set<Stamp> stamps = new HashSet<>();
//    }
}