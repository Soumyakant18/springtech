package com.example.springtech.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prdid;
    @Column(name = "Name" , nullable = false)
    private String name;
    @Column(name = "Description" , nullable = false)
    private String desc;
    @Column(name = "Price" , nullable = false)
    private String price;




}
