package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Stamp;
import iba.group.diplomAppStore.domain.StampOrder;
import iba.group.diplomAppStore.domain.User;
import iba.group.diplomAppStore.repository.OrderRepository;
import iba.group.diplomAppStore.repository.StampRepository;
import iba.group.diplomAppStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/myOrder")
public class MyOrderControler {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public MyOrderControler(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

//    @GetMapping
//    public String getMyOrder(Model model, @AuthenticationPrincipal User user, StampOrder stampOrder) {
//        Iterable<StampOrder> myOrder = orderRepository.findByUserId(user.getId());
//        model.addAttribute("myOrder", myOrder);
////        model.addAttribute("myOderedStamps", myOderedStamps);
//        return "Myorder";
//    }
}
