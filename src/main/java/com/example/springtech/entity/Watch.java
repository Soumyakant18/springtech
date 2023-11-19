package com.example.springtech.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Data
@Entity
public class Watch { // Renamed from PC

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String watchName; // Updated field name from 'name'

    @Column
    private String description;

    @Column
    private double price;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;

    public Watch() {
    }

    // Getters and setters for the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    // Constructor with fields

    public Watch(Long id, String watchName, String description, double price, byte[] image) {
        this.id = id;
        this.watchName = watchName;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
