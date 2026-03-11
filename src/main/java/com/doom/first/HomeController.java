package com.doom.first;

import com.doom.first.model.Credentials;
import com.doom.first.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final Repository repo;

    public HomeController(Repository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String loginForm() {
        log.info("User accessed the localhost:8080/");
        return "login";
    }

    @PostMapping("/")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {


        Credentials existingUser = repo.findByUsername(username);

        if(existingUser != null){
            model.addAttribute("error","Username already exists");
            return "redirect:/dashboard";
        }

        Credentials user = repo.findByUsername(username);

        // Check if username exists
        if (user == null) {
            model.addAttribute("error", "User not registered. Please sign up first.");
            return "login";
        }

        // Check password
        if (!user.getPasskey().equals(password)) {
            model.addAttribute("error", "Invalid password.");
            return "login";
        }

        log.info("info", "Successfull login") ;
        // Successful login
        return "redirect:/dashboard";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String saveData(@ModelAttribute Credentials credential) {
        repo.save(credential);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        int balance = 0; // placeholder balance

        model.addAttribute("balance", balance);

        return "dashboard";
    }

    @GetMapping("/add-money")
    public String addMoneyPage() {
        return "addmoney";
    }

    @PostMapping("/add-money")
    public String addMoney(@RequestParam int amount) {

        System.out.println("Amount added: " + amount);

        return "redirect:/dashboard";
    }

    @GetMapping("/transfer")
    public String transferPage() {
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam String receiver,
                                @RequestParam int amount) {

        System.out.println("Transfer to: " + receiver);
        System.out.println("Amount: " + amount);

        return "redirect:/dashboard";
    }


    @GetMapping("/transactions")
    public String transactions() {
        return "transactions";
    }
}