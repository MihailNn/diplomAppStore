package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Stamp;
import iba.group.diplomAppStore.repository.StampRepository;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CartController {
    private final StampRepository stampRepository;

    @Autowired
    public CartController(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @ModelAttribute
    Cart populateCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = Cart.builder()
                    .stamps(new HashSet<>())
                    .build();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping("/cart")
    public String addToCart(@RequestParam Long stampId, Cart cart) {
        stampRepository.findById(stampId).ifPresent(stamp -> cart.getStamps().add(stamp));
        return "cart";
    }

    @Builder
    @Getter
    public static class Cart {
        Set<Stamp> stamps;
    }
}
