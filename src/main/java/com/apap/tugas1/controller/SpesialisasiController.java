package com.apap.tugas1.controller;
/**
 * Spesialisasi Controller
 */

import com.apap.tugas1.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpesialisasiController{

    @Autowired
    private SpesialisasiService spesialisasiService;
}
