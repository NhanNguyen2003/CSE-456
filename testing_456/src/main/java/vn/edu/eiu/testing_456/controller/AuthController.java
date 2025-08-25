package vn.edu.eiu.testing_456.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.eiu.testing_456.model.User;
import vn.edu.eiu.testing_456.repository.UserRepo;

public class AuthController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {

        User user = userRepo.findByUsernameAndPassword(username, password);

        if(user != null && (user.getRole() == 1 || user.getRole() == 2)) {
            session.setAttribute("user", user);
            return "redirect:/equipment";
        }
        model.addAttribute("error", "You are not authorized to access this function.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }



}
