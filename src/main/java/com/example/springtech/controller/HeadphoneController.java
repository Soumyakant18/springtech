package com.example.springtech.controller;

import com.example.springtech.entity.Headphone;
import com.example.springtech.service.Headphoneinterface;
import com.example.springtech.service.Headphoneinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class HeadphoneController {
    @Autowired
    private Headphoneinterface headphoneinterface;

    @PostMapping("/addhp")
    public ResponseEntity<Headphone> addHeadphone(@RequestParam("name") String name,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("price") double price,
                                                  @RequestParam("image") MultipartFile file) {

        Headphone headphone = new Headphone();
        headphone.setName(name);
        headphone.setDescription(description);
        headphone.setPrice(price);
        try {
            headphone.setImage(file.getBytes());
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(headphoneinterface.saveHeadphone(headphone), HttpStatus.CREATED);
    }

    @GetMapping("/api/allheadphonedata")
    public List<Headphone> sendHeadphoneData() {
        return headphoneinterface.sendAllHeadphones();
    }
}
