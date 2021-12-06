package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Cart;
import iba.group.diplomAppStore.domain.StampOrder;
import iba.group.diplomAppStore.domain.User;
import iba.group.diplomAppStore.repository.OrderRepository;
import iba.group.diplomAppStore.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/order")
@SessionAttributes("stampOrder")
public class OrderController {
    private OrderRepository orderRepo;
    private UserRepository userRepository;
    public OrderController(OrderRepository orderRepo, UserRepository userRepository)
    {
        this.orderRepo = orderRepo;
        this.userRepository = userRepository;
    }

    @PostMapping
    public String addOrder(@Valid StampOrder order, Errors errors, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (errors.hasErrors()) {
            return "order";
        }
        Optional<User> userOp = userRepository.findById(user.getId());
        order.setUser(userOp.get());
        orderRepo.save(order);
        cart.getStamps().clear();
        sessionStatus.setComplete();
        return "redirect:/";
    }
    @ModelAttribute
    StampOrder populateOrder(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        StampOrder stampOrder = new StampOrder();
        stampOrder.setStamps(cart.getStamps());
        return stampOrder;
    }
    @GetMapping
    public String getOrder() {
        return "order";
     }
}