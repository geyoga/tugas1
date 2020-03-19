package com.apap.tugas1.controller;

/**
 * Pustakawan Controller
 */

import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.service.pustakawan.PustakawanService;
import com.apap.tugas1.model.SpesialisasiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/")
    private String home(Model model){
        
        return "home";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String addPustakawan(Model model){
        model.addAttribute("pustakawan", new PustakawanModel());
        return "add-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST)
    private String addPustakawanSubmit (@ModelAttribute PustakawanModel pustakawan){
        String nip = getNipGenerator(pustakawan);

        if(checkSameNip(nip)){
            nip = getNipGenerator(pustakawan);
        }

        pustakawan.setNip(nip);
        pustakawanService.addPustakawan(pustakawan);
        return "add-submit";
    }

    List<String> nipStore = new ArrayList<String>();

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
        nipStore.add(result);

        return result;
    }

    private Boolean checkSameNip(String nip){

        for (int counter = 0; counter < nipStore.size(); counter++) {

            if (nip == nipStore.get(counter)){
                    return true;
            }
        }
        return false;
    }
}




