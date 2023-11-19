package com.example.springtech.controller;



import com.example.springtech.entity.Watch; // Updated import statement
import com.example.springtech.service.Watchinterface; // Updated import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class WatchController { // Renamed class to WatchController
    @Autowired
    private Watchinterface watchinterface; // Renamed interface to WatchInterface

    @PostMapping("/api/addSmartwatch") // Changed endpoint to /addwatch
    public ResponseEntity<Watch> addWatch(@RequestParam("name") String name, // Changed parameter name to 'name'
                                          @RequestParam("description") String description,
                                          @RequestParam("price") double price,
                                          @RequestParam("image") MultipartFile file) {

        Watch watch = new Watch(); // Changed object type to Watch
        watch.setWatchName(name); // Changed method call to setName
        watch.setDescription(description);
        watch.setPrice(price);
        try {
            watch.setImage(file.getBytes()); // Changed method call to setImage
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(watchinterface.saveWatch(watch), HttpStatus.CREATED); // Changed method call to saveWatch
    }

    @GetMapping("/api/allwatchdata") // Changed endpoint to /api/allwatchdata
    public List<Watch> sendWatchData() { // Changed return type and method name
        return watchinterface.sendAllWatches(); // Changed method call to sendAllWatches
    }
}
