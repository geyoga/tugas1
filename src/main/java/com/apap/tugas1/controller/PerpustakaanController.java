package com.apap.tugas1.controller;

/**
 * Perpustakaan Controller
 */

import com.apap.tugas1.model.PerpustakaanModel;
import com.apap.tugas1.service.PerpustakaanService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PerpustakaanController{

    @Autowired
    private PerpustakaanService perpustakaanService;

    @RequestMapping(value = "/perpustakaan",method = RequestMethod.GET)
    private String listPerpustakaan(Model model){
        List<PerpustakaanModel> listPerpustakaan = perpustakaanService.getAllPerpustakaan();
        model.addAttribute("listPerpustakaan", listPerpustakaan);
        return "list-perpustakaan";
    }

    @RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
    private String addPerpustakaan(Model model){
        PerpustakaanModel perpustakaan = new PerpustakaanModel();
        model.addAttribute("perpustakaan", perpustakaan);
        return "add-perpustakaan";
    }

    @RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST)
    private String addPerpustakaan(@ModelAttribute PerpustakaanModel perpustakaan, Model model){
        perpustakaanService.addPerpustakaan(perpustakaan);
        return "add-perpustakaan-submit";
    }

    @RequestMapping(value = "/perpustakaan/delete/{perpustakaanId}", method = RequestMethod.GET)
    private String deletePerpustakaan(@PathVariable(value = "perpustakaanId") long perpustakaanId, Model model){
        perpustakaanService.deletePerpustakaan(perpustakaanId);
        return "delete-perpustakaan-submit";
    }



}
