package vn.edu.eiu.testing_456.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.eiu.testing_456.model.Equipment;
import vn.edu.eiu.testing_456.model.User;
import vn.edu.eiu.testing_456.repository.EquipmentRepo;
import vn.edu.eiu.testing_456.repository.EquipmentTypeRepo;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private EquipmentTypeRepo equipmentTypeRepo;

    private boolean checkAuth(HttpSession session, Model model, int ... roles) {
        User user = (User) session.getAttribute("user");

        if(user == null) {
            model.addAttribute("error", "You are not authorized to access this function" );
            return false;
        }
        for(int r : roles) {
            if(user.getRole() == r)
                return true;
        }
        model.addAttribute("error", "You are not authorized to access this function" );
        return false;
    }

    @GetMapping
    public String list(Model model, HttpSession session) {
        if(!checkAuth(session, model, 1, 2)) {
            return "login";
        }
        model.addAttribute("equipments", equipmentRepo.findAll());
        return "equipment";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Equipment equipment, BindingResult result, Model model, HttpSession session) {
        if(!checkAuth(session, model, 1)) {
            return "login";
        }
        if(result.hasErrors()) {
            model.addAttribute("types", equipmentTypeRepo.findAll());
            model.addAttribute("formMode", "new");
            return "equipment-form";
        }
        equipmentRepo.save(equipment);
        return "redirect:/equipment";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model, HttpSession session ) {
        if(!checkAuth(session, model, 1)) {
            return "login";
        }
        model.addAttribute("equipment", equipmentRepo.findById(id).orElseThrow());
        model.addAttribute("types", equipmentTypeRepo.findAll());
        model.addAttribute("formMode", "edit");
        return "equipment-form";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Equipment equipment, BindingResult result, Model model, HttpSession session) {
        if (!checkAuth(session, model, 1)) {
            return "login";
        }
        if(result.hasErrors()) {
            model.addAttribute("types", equipmentTypeRepo.findAll());
            model.addAttribute("formMode", "edit");
            return "equipment-form";
        }
        equipmentRepo.save(equipment);
        return "redirect:/equipment";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model, HttpSession session) {
        if(!checkAuth(session, model, 1)) {
            return "login";
        }
        equipmentRepo.deleteById(id);
        return "redirect:/equipment";
    }

    @GetMapping("/top3")
    public String top3(Model model, HttpSession session) {
        if(!checkAuth(session, model, 1)) {
            return "login";
        }
        model.addAttribute("equipments", equipmentRepo.findTop3ByType());
        return "equipment-top3";
    }

}
