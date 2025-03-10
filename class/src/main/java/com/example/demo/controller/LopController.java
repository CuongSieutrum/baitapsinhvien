package com.example.demo.controller;

import com.example.demo.entity.Lop;
import com.example.demo.services.LopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class LopController {

    @Autowired
    private LopServices lopService;

    @GetMapping
    public String showAllLop(Model model) {
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Lop lop = lopService.getLopById(id);
        if (lop != null) {
            model.addAttribute("lop", lop);
            return "lop/edit";
        }
        return "redirect:/lop";
    }
    @GetMapping("/delete/{maLop}")
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        Lop lop = lopService.getLopById(id);
        model.addAttribute("lop", lop);
        return "lop/delete";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop) {
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @PostMapping("/edit")
    public String editLop(@ModelAttribute("lop") Lop lop) {
        lopService.updateLop(lop);
        return "redirect:/lop";
    }

    @PostMapping("/delete")
    public String deleteLop(@RequestParam("maLop") Long id) {
        lopService.deleteLop(id);
        return "redirect:/lop";
    }

    //mon hoc




}
