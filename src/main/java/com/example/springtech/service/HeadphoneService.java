package com.example.springtech.service;

import com.example.springtech.entity.Headphone;
import com.example.springtech.repository.HeadphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadphoneService implements Headphoneinterface {

    @Autowired
    private HeadphoneRepository headphoneRepository;

    @Override
    public Headphone saveHeadphone(Headphone headphone) {
        return headphoneRepository.save(headphone);
    }

    @Override
    public List<Headphone> sendAllHeadphones() {
        return headphoneRepository.findAll();
    }


}
