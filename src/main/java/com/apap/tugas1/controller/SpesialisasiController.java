package com.apap.tugas1.controller;
/**
 * Spesialisasi Controller
 */

import com.apap.tugas1.model.PerpustakaanModel;
import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.model.SpesialisasiModel;
import com.apap.tugas1.service.PustakawanService;
import com.apap.tugas1.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SpesialisasiController{

    @Autowired
    private SpesialisasiService spesialisasiService;

    @Autowired
    private PustakawanService pustakawanService;

    @RequestMapping(value = "/statistik", method = RequestMethod.GET)
    private String loadStatistik(Model model){

        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("listSpesialisasi", listSpesialisasi);

        return "view-statistik";
    }
}
