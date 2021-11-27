package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.Stamp;
import iba.group.diplomAppStore.repository.StampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
