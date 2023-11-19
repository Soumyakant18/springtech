package com.example.springtech.service;

import com.example.springtech.entity.Watch; // Replaced Headphone with Watch

import java.util.List;

public interface Watchinterface { // Renamed HeadphoneInterface to WatchInterface
    Watch saveWatch(Watch watch); // Replaced Headphone with Watch

    List<Watch> sendAllWatches(); // Replaced Headphone with Watch
}
