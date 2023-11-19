package com.example.springtech.service;

import com.example.springtech.entity.PC;
import com.example.springtech.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class PCService implements PCinterface {

    @Autowired
    private PCRepository pcRepository;


    @Override
    public PC savePC(PC pc) {
        return pcRepository.save(pc);
    }

    @Override
    public List<PC> sendAllPC() {
        return pcRepository.findAll();
    }
}
