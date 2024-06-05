package com.example.demo.controller;

import com.example.demo.entity.Lop;
import com.example.demo.entity.MonHoc;
import com.example.demo.services.MonHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MonHocController {

    @Autowired
    private MonHocServices monHocServices;

    @GetMapping("/monhoc")
    public String showAllMonHoc(Model model) {
        List<MonHoc> dsMonHoc = monHocServices.getAllMonHoc();
        model.addAttribute("dsMonHoc", dsMonHoc);
        return "monhoc/list";
    }

    @GetMapping("/monhoc/add")
    public String addMonHoc(Model model) {
        model.addAttribute("monhoc", new MonHoc());
        return "monhoc/add";
    }

    @GetMapping("/monhoc/edit/{maMon}")
    public String EditForm(@PathVariable("maMon") Long maMon, Model model) {
        MonHoc monHoc = monHocServices.getMonHocById(maMon);
        model.addAttribute("monhoc", monHoc);
        return "monhoc/edit";
    }
    @GetMapping("/monhoc/delete/{maMon}")
    public String deleteMonHoc(@PathVariable("maMon") Long maMon, Model model) {
        MonHoc monHoc = monHocServices.getMonHocById(maMon);
        model.addAttribute("monhoc", monHoc);
        return "monhoc/delete";
    }






    @PostMapping("/monhoc/add")
    public String addMonHoc(@ModelAttribute("monhoc") MonHoc monHoc) {
        monHocServices.addMonHoc(monHoc);
        return "redirect:/monhoc";
    }
    @PostMapping("/monhoc/edit")
    public String editMonHoc(@ModelAttribute("monhoc") MonHoc monHoc) {
        monHocServices.updateMonHoc(monHoc);
        return "redirect:/monhoc";
    }
    @PostMapping("/monhoc/delete")
    public String deleteMonHoc(@ModelAttribute("monhoc") long maMon) {
        monHocServices.deleteMonHoc(maMon);
        return "redirect:/monhoc";
    }


}
