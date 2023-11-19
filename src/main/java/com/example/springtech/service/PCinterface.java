package com.example.springtech.service;
import com.example.springtech.entity.PC;

import java.util.List;

public interface PCinterface {
    PC savePC(PC pc);

    List<PC> sendAllPC();
}
