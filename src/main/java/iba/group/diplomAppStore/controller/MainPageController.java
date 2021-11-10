package iba.group.diplomAppStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // to identify this class as a component for component scanning
@RequestMapping("/")
public class MainPageController {
    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/catalog")
    public String catalogView(){
//        model.addAttribute("stamps", new Stamp());
        return "catalogOfStamps";
    }


}
