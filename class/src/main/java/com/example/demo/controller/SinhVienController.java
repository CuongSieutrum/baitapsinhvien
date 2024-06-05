package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.services.LopServices;
import com.example.demo.services.MonHocServices;
import com.example.demo.services.SinhVienServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SinhVienController {

    @Autowired
    private SinhVienServices sinhVienServices;
    @Autowired
    private LopServices lopService;
    @Autowired
    private MonHocServices monHocService;

    @GetMapping("/sinhvien")
    public String showAllSinhVien(Model model) {
        List<SinhVien> dsSinhVien = sinhVienServices.getAllSinhVien();
        model.addAttribute("dsSinhVien", dsSinhVien);
        return "sinhvien/list";
    }

    @GetMapping("/sinhvien/add")
    public String addSinhVien(Model model) {
        model.addAttribute("sinhvien", new SinhVien());
        model.addAttribute("dsLop", lopService.getAllLop());
        model.addAttribute("dsMonHoc", monHocService.getAllMonHoc());
        return "sinhvien/add";
    }

    @GetMapping("/sinhvien/edit/{id}")
    public String editSinhVienForm(@PathVariable("id") Long id, Model model) {
        SinhVien sinhVien = sinhVienServices.getSinhVienById(id);
        model.addAttribute("sinhvien", sinhVien);
        return "sinhvien/edit";
    }

    @GetMapping("/sinhvien/delete/{id}")
    public String deleteSinhVien(@PathVariable("id") Long id, Model model) {
        SinhVien sinhVien = sinhVienServices.getSinhVienById(id);
        model.addAttribute("sinhvien", sinhVien);
        return "sinhvien/delete";
    }

    @PostMapping("/sinhvien/add")
    public String addSinhVien(@ModelAttribute("sinhvien") SinhVien sinhVien) {
        sinhVienServices.addSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }


    @PostMapping("/sinhvien/edit")
    public String editSinhVien(@ModelAttribute("sinhvien") SinhVien sinhVien) {
        sinhVienServices.updateSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }

    @PostMapping("/sinhvien/delete")
    public String deleteSinhVien(@RequestParam("id") Long id) {
        sinhVienServices.deleteSinhVienById(id);
        return "redirect:/sinhvien";
    }

    // Add other mappings for adding, updating, and deleting SinhVien if needed
}
