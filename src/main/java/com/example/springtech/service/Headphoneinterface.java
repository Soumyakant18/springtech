package com.example.springtech.service;
import com.example.springtech.entity.Headphone;
import com.example.springtech.entity.PC;

import java.util.List;

public interface Headphoneinterface {
    Headphone saveHeadphone(Headphone headphone);


    List<Headphone> sendAllHeadphones();
}
