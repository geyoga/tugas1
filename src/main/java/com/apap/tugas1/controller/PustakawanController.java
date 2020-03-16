package com.apap.tugas1.controller;

/**
 * Pustakawan Controller
 */

import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.service.pustakawan.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PustakawanController{

    @Autowired
    PustakawanService pustakawanService;

    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.GET)
    private String addPustakawan(Model model){
        model.addAttribute("pustakawan", new PustakawanModel());
        return "add-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.POST)
    private String addPustakawanSubmit (@ModelAttribute PustakawanModel pustakawan){
        pustakawanService.addPustakawan(pustakawan);
        return "add-submit";
    }
}




