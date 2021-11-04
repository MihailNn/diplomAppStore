package iba.group.diplomAppStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // to identify this class as a component for component scanning
public class MainPageController {
    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }
}
