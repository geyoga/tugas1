package com.apap.tugas1.controller;

/**
 * Pustakawan Controller
 */

import com.apap.tugas1.model.*;
import com.apap.tugas1.service.PerpustakaanService;
import com.apap.tugas1.service.PustakawanService;
import com.apap.tugas1.service.SpesialisasiService;
import com.apap.tugas1.service.SpesialisasiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PustakawanController{

    @Autowired
    PustakawanService pustakawanService;

    @Autowired
    SpesialisasiService spesialisasiService;

    @Autowired
    PerpustakaanService perpustakaanService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home(Model model) {
        List<PustakawanModel> listPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("listPustakawan", listPustakawan);
        return "home";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String addPustakawan(Model model){

        PustakawanModel newPustakawan = new PustakawanModel();
        model.addAttribute("pustakawan", newPustakawan);

        return "add-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST)
    private String addPustakawanSubmit (@ModelAttribute PustakawanModel pustakawan, Model model){

        String nip = getNipGenerator(pustakawan);
        pustakawan.setNip(nip);

        pustakawanService.addPustakawan(pustakawan);

        return "redirect:/pustakawan/tambah/view/" + pustakawan.getId();
    }

    @RequestMapping(value = "/pustakawan/tambah/view/{pustakawanId}", method = RequestMethod.GET)
    private String viewTambahPustakawan (Model model, @PathVariable long pustakawanId){

        PustakawanModel pustakawan = pustakawanService.getPustakawanById(pustakawanId);
        model.addAttribute("title", pustakawan.getNama());
        model.addAttribute("listSpesialisasi", pustakawan.getListSpesialisasi());
        model.addAttribute("pustakawanId", pustakawan.getId());

        return "view-SpesialisasiPustakawan";
    }
    @RequestMapping(value = "/pustakawan/tambah/spesialisasi/{pustakawanId}", method = RequestMethod.GET)
    private String addSpesialisasi(Model model, @PathVariable long pustakawanId){

        PustakawanModel pustakawan = pustakawanService.getPustakawanById(pustakawanId);

        addSpesialisasiForm form = new addSpesialisasiForm(spesialisasiService.getAllSpesialisasi(), pustakawan);
        form.setPustakawan(pustakawan);

        model.addAttribute("title", "Tambah Spesialisasi untuk " + pustakawan.getNama());
        model.addAttribute("form", form);
        return "add-spesialisasi";
    }
    @RequestMapping(value = "/pustakawan/tambah/spesialisasi", method = RequestMethod.POST)
    private String addSpesialisasi(Model model, @ModelAttribute addSpesialisasiForm form){

        List<SpesialisasiModel> currentList;
        Boolean condition = false;

        SpesialisasiModel spesialisasi = spesialisasiService.getSpesialisasiById(form.getSpesialisasiId());
        PustakawanModel pustakawan = pustakawanService.getPustakawanById(form.getPustakawanId());

        currentList = pustakawan.getListSpesialisasi();
        for (int i=0; i<currentList.size(); i++){
            if (spesialisasi.getId()==currentList.get(i).getId()){
                condition = true;
            }
        }

        if (condition == false){
            pustakawan.addSpesialisasi(spesialisasi);
            pustakawan.setListSpesialisasi(pustakawan.getListSpesialisasi());
            pustakawanService.addPustakawan(pustakawan);
        }

        return "redirect:/pustakawan/tambah/view/" + form.getPustakawanId();
    }

    @RequestMapping(value = "/pustakawan/tambah/berhasil", method = RequestMethod.GET)
    private String showSuccess(){
        return "add-pustakawan-submit";
    }

    @RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
    private String viewPustakawan(@RequestParam (value = "nip") String nip, Model model){
        PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
        model.addAttribute("pustakawan",pustakawan);
        return "view-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/update/{pustakawanId}", method = RequestMethod.GET)
    private String updatePustakawan(@PathVariable long pustakawanId, Model model){

        PustakawanModel pustakawan = pustakawanService.getPustakawanById(pustakawanId);
        model.addAttribute("pustakawan",pustakawan);
        model.addAttribute("listSpesialisasi", pustakawan.getListSpesialisasi());
        model.addAttribute("pustakawanId", pustakawan.getId());

        return "update-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/update/{pustakawanId}", method = RequestMethod.POST)
    private String updatePustakawan(@PathVariable long pustakawanId, @ModelAttribute PustakawanModel pustakawan,
                                    Model model){
        String nip = getNipGenerator(pustakawan);
        pustakawan.setNip(nip);
        pustakawanService.addPustakawan(pustakawan);
        return "redirect:/pustakawan/tambah/view/" + pustakawan.getId();
    }

    @RequestMapping(value = "/pustakawan/delete/{pustakawanId}", method = RequestMethod.GET)
    private String deletePustakawan(@PathVariable long pustakawanId, Model model){
        pustakawanService.deletePustakawan(pustakawanId);

        return "delete-pustakawan-submit";

    }

    @RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
    private String addJadwal(@PathVariable String nip, @ModelAttribute JadwalModel jadwal, Model model){

        JadwalModel newJadwal = new JadwalModel();
        List<PerpustakaanModel> listPerpustakaan = perpustakaanService.getAllPerpustakaan();
        PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);

        jadwal.setPustakawan(pustakawan);

        model.addAttribute("pustakawan", pustakawan);
        model.addAttribute("listPerpustakaan", listPerpustakaan);
        model.addAttribute("newJadwal",newJadwal);
        model.addAttribute("pustakawanId", pustakawan.getId());
        model.addAttribute("filteredPerpus",pustakawan.getListPerpustakaan());

        return "add-jadwal";
    }

    @RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.POST)
    private String addJadwal(@PathVariable String nip,
                             @ModelAttribute JadwalModel jadwal,
                             @RequestParam(value = "perpustakaan", required = true) PerpustakaanModel perpustakaan,
                             @RequestParam(value = "hari") String hari,
                             @RequestParam(value = "pustakawan", required = true) PustakawanModel pustakawan,
                             Model model){
        jadwal.setPustakawan(pustakawanService.getPustakawanByNip(nip));
        jadwal.setPerpustakaan(perpustakaanService.getPerpustakaanById(perpustakaan.getId()));
        jadwal.setHari(hari);
        pustakawan.addPerpustakaan(jadwal.getPerpustakaan());
        pustakawanService.addPustakawan(pustakawan);
        return "add-pustakawan-submit";
    }

    @RequestMapping(value = "/cari", method = RequestMethod.GET)
    private String cari(Model model) {
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getAllSpesialisasi();
        List<PustakawanModel> listPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("listSpesialisasi", listSpesialisasi);
        model.addAttribute("pustakawan_list", listPustakawan);
        return "cari-pustakawan";
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




