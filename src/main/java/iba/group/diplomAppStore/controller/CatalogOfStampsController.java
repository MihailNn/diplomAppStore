package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Cart;
import iba.group.diplomAppStore.domain.Stamp;
import iba.group.diplomAppStore.repository.StampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("addToCart")
public class CatalogOfStampsController {
    private final StampRepository stampRepository;
    @Autowired
    public CatalogOfStampsController(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @RequestMapping("/catalog")
    public String showCatalog(Model model) {
        Iterable<Stamp> stamps = stampRepository.findAll();
        model.addAttribute("stamps", stamps);
        return "catalogOfStamps";
    }

    @GetMapping("/cart")
    public String addToCart() {
//        Optional<Stamp> stampAddToCart = stampRepository.findById((Long) model.getAttribute("id"));
//        model.addAttribute("toCart", stampAddToCart);
        return "cart";
    }
}
