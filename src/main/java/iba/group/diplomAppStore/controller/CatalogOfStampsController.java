package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.model.Order;
import iba.group.diplomAppStore.model.Stamp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogOfStampsController {

    @RequestMapping("/catalog")
    public String showCatalog(Model model) {
        model.addAttribute("stamps", new Stamp());
        return "catalogOfStamps";
    }
}
