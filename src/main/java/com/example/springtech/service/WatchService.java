package com.example.springtech.service;

import com.example.springtech.entity.Watch; // Replaced Headphone with Watch
import com.example.springtech.repository.WatchRepository; // Updated repository import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService implements Watchinterface { // Renamed HeadphoneService to WatchService

    @Autowired
    private WatchRepository watchRepository; // Updated repository type to WatchRepository

    @Override
    public Watch saveWatch(Watch watch) { // Replaced Headphone with Watch
        return watchRepository.save(watch); // Replaced Headphone with Watch
    }

    @Override
    public List<Watch> sendAllWatches() { // Replaced Headphone with Watch
        return watchRepository.findAll(); // Replaced Headphone with Watch
    }
}
