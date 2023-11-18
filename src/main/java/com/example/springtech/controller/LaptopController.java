package com.example.springtech.controller;

import com.example.springtech.entity.Laptop;
import com.example.springtech.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/laptops")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Optional<Laptop> getLaptopById(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping("/laptops")
    public Laptop saveLaptop(@RequestBody Laptop laptop) {
        return laptopService.saveLaptop(laptop);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Long id, @RequestBody Laptop updatedLaptop) {
        Optional<Laptop> existingLaptopOptional = laptopService.getLaptopById(id);

        if (existingLaptopOptional.isPresent()) {
            Laptop existingLaptop = existingLaptopOptional.get();

            // Update the existing laptop with the new data
            existingLaptop.setName(updatedLaptop.getName());
            existingLaptop.setSellingPrice(updatedLaptop.getSellingPrice());
            existingLaptop.setBuyingPrice(updatedLaptop.getBuyingPrice());
            existingLaptop.setDescription(updatedLaptop.getDescription());

            // Save the updated laptop
            Laptop savedLaptop = laptopService.saveLaptop(existingLaptop);

            return new ResponseEntity<>(savedLaptop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
