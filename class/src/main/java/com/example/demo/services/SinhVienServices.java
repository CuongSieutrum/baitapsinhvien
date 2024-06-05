package com.example.demo.services;

import com.example.demo.entity.SinhVien;
import com.example.demo.repository.ISinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienServices {

    @Autowired
    private ISinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(Long id) {
        Optional<SinhVien> sinhVienOptional = sinhVienRepository.findById(id);
        return sinhVienOptional.orElse(null);
    }

    public void addSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVienById(Long id) {
        sinhVienRepository.deleteById(id);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }
}
