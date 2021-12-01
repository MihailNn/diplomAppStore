package iba.group.diplomAppStore.controller;

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
@RequestMapping("/")
public class CatalogOfStampsController {
    private final StampRepository stampRepository;

    public CatalogOfStampsController(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        Iterable<Stamp> stamps = stampRepository.findAll();
        model.addAttribute("stamps", stamps);
        return "catalogOfStamps";
    }

}
