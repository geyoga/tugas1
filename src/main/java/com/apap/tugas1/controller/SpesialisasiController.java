package com.apap.tugas1.controller;
/**
 * Spesialisasi Controller
 */

import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.model.SpesialisasiModel;
import com.apap.tugas1.service.PustakawanService;
import com.apap.tugas1.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        SpesialisasiModel s1 = spesialisasiService.getSpesialisasiById(1);
        SpesialisasiModel s2 = spesialisasiService.getSpesialisasiById(2);
        SpesialisasiModel s3 = spesialisasiService.getSpesialisasiById(3);
        SpesialisasiModel s4 = spesialisasiService.getSpesialisasiById(4);
        SpesialisasiModel s5 = spesialisasiService.getSpesialisasiById(5);

        model.addAttribute("sp1",s1.getListPustakawan().size());
        model.addAttribute("sp2",s2.getListPustakawan().size());
        model.addAttribute("sp3",s3.getListPustakawan().size());
        model.addAttribute("sp4",s4.getListPustakawan().size());
        model.addAttribute("sp5",s5.getListPustakawan().size());
        model.addAttribute("listSpesialisasi", listSpesialisasi);


        return "view-statistik";
    }
}
