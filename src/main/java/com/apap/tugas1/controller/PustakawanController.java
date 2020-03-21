package com.apap.tugas1.controller;

/**
 * Pustakawan Controller
 */

import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.model.SpesialisasiModel;
import com.apap.tugas1.service.PustakawanService;
import com.apap.tugas1.service.SpesialisasiService;
import com.apap.tugas1.service.SpesialisasiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Controller
public class PustakawanController{

    @Autowired
    PustakawanService pustakawanService;

    @Autowired
    SpesialisasiService spesialisasiService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home(Model model) {
        List<PustakawanModel> listPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("listPustakawan", listPustakawan);
        return "home";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String addPustakawan(Model model){

        List<SpesialisasiModel> list = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("pustakawan", new PustakawanModel());
        model.addAttribute("listSpesialisasi", list);

        return "add-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST)
    private String addPustakawanSubmit (@ModelAttribute PustakawanModel pustakawan,
                                        @ModelAttribute SpesialisasiModel spesialisasi){
        List<SpesialisasiModel> list = new ArrayList<SpesialisasiModel>();
        String nip = getNipGenerator(pustakawan);

        pustakawan.setNip(nip);
        spesialisasi.setDeskripsi("");
        spesialisasi.setNama("School Librarianship");

        list.add(spesialisasi);
        pustakawan.setListSpesialisasi(list);

        spesialisasiService.addSpesialisasi(spesialisasi);
        pustakawanService.addPustakawan(pustakawan);

        System.out.println(spesialisasi.getId());
        return "add-submit";
    }



    private String getNipGenerator(PustakawanModel pustakawan){

        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        String year = String.valueOf(yearNow);

        DateFormat df = new SimpleDateFormat("ddMMyy");
        String date = df.format(pustakawan.getTanggal_lahir());

        String gender = String.valueOf(pustakawan.getJenis_kelamin());

        Random rnd = new Random();
        char firstChar = (char) (rnd.nextInt(26) + 'A');
        char secondChar = (char) (rnd.nextInt(26) + 'A');

        String result = year+date+gender+firstChar+secondChar;

        return result;
    }

}




