package com.example.springtech.controller;

import com.example.springtech.entity.PC;
import com.example.springtech.service.PCinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PCController {
    @Autowired
    private PCinterface pcinterface;
    @PostMapping("/add")
    public ResponseEntity<PC> addPC(@RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("price") double price,
                                        @RequestParam("image") MultipartFile file) {

           PC pc = new PC();
           pc.setName(name);
           pc.setDescription(description);
           pc.setPrice(price);
           try{
               pc.setImage(file.getBytes());
           }catch (IOException e){
               return new ResponseEntity<PC>(HttpStatus.BAD_REQUEST);
           }

       return new ResponseEntity<PC>(pcinterface.savePC(pc),HttpStatus.CREATED);
    }
    @GetMapping("/api/allpcdata")
    public List<PC> sendPCdata(){
        return pcinterface.sendAllPC();
    }
}
