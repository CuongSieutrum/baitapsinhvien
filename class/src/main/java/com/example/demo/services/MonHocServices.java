package com.example.demo.services;

import com.example.demo.entity.MonHoc;
import com.example.demo.repository.IMonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonHocServices {

    @Autowired
    private IMonHocRepository monHocRepository;

    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    public MonHoc getMonHocById(Long id) {
        return monHocRepository.findById(id).orElse(null);
    }

    public void addMonHoc(MonHoc monHoc) {
        monHocRepository.save(monHoc);
    }

    public void deleteMonHoc(Long id) {
        monHocRepository.deleteById(id);
    }

    public void updateMonHoc(MonHoc monHoc) {
        monHocRepository.save(monHoc);
    }
}


