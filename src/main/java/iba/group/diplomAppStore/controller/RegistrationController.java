package iba.group.diplomAppStore.controller;

import iba.group.diplomAppStore.domain.RegistrationForm;
import iba.group.diplomAppStore.domain.User;
import iba.group.diplomAppStore.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }
//    RegistrationController is injected with a PasswordEncoder.
//    When processing a form submission, RegistrationController passes it to the toUser() method,
//    which uses it to encode the password before saving it to the database.
//    In this way, the submitted password is written in an encoded form, and the user details service
//    will be able to authenticate against that encoded password.
    @PostMapping
    public String processRegistration(RegistrationForm form, Errors error) {
        User nameUser = userRepo.findByUsername(form.getUsername());
        if (nameUser == null) {
            userRepo.save(form.toUser(passwordEncoder));
        }
        else  {
//            error.reject("", "Such user exist");
            return "registration";
        }
        return "redirect:/login";
    }
}