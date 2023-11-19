package com.example.springtech.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private int cartid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdid")
    private int prdid;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String desc;

    @Column(name = "Price")
    private BigDecimal price;
}
