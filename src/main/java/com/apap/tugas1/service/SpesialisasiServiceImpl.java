package com.apap.tugas1.service;

import com.apap.tugas1.model.SpesialisasiModel;
import com.apap.tugas1.repository.SpesialisasiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spesialisasi Service Implementation
 */

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService {

    @Autowired
    private SpesialisasiDB spesialisasiDB;

    private static final List<SpesialisasiModel> daftarSpesialisasi = new ArrayList<SpesialisasiModel>();

    static {
        initData();
    }

    private static void initData(){
        SpesialisasiModel as = new SpesialisasiModel();
        as.setId(1);
        as.setNama("Archival Studies");


        SpesialisasiModel ia = new SpesialisasiModel();
        ia.setNama("Information Architecture");
        ia.setId(2);


        SpesialisasiModel pl = new SpesialisasiModel();
        pl.setNama("Public Librarianship");
        pl.setId(3);


        SpesialisasiModel al = new SpesialisasiModel();
        al.setNama("Academic Librarianship");
        al.setId(4);


        SpesialisasiModel sl = new SpesialisasiModel();
        sl.setNama("School Librarianship");
        sl.setId(5);


        daftarSpesialisasi.add(as);
        daftarSpesialisasi.add(ia);
        daftarSpesialisasi.add(pl);
        daftarSpesialisasi.add(al);
        daftarSpesialisasi.add(sl);



    }

    @Override
    public SpesialisasiModel getSpesialisasiById(long id) {
        return spesialisasiDB.findById(id);
    }

    @Override
    public void addSpesialisasi(SpesialisasiModel spesialisasi) {
        spesialisasiDB.save(spesialisasi);
    }

    @Override
    public List<SpesialisasiModel> getAllSpesialisasi() {
        return daftarSpesialisasi;
    }

}
