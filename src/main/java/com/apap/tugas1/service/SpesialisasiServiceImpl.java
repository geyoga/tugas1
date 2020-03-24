package com.apap.tugas1.service;

import com.apap.tugas1.model.SpesialisasiModel;
import com.apap.tugas1.repository.SpesialisasiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    /*
    * @PostConstruct
    public void loadData() {
        SpesialisasiModel sp1 = new SpesialisasiModel();
        sp1.setNama("Archival Studies");
        sp1.setId(1);
        sp1.setDeskripsi("Studi Arsip");
        spesialisasiDB.save(sp1);

        SpesialisasiModel sp2 = new SpesialisasiModel();
        sp2.setNama("Information Architecture");
        sp2.setId(2);
        sp2.setDeskripsi("Arsitektur Informasi");
        spesialisasiDB.save(sp2);

        SpesialisasiModel sp3 = new SpesialisasiModel();
        sp3.setNama("Public Librarianship");
        sp3.setId(3);
        sp3.setDeskripsi("Kepustakawanan Publik");
        spesialisasiDB.save(sp3);

        SpesialisasiModel sp4 = new SpesialisasiModel();
        sp4.setNama("Academic Librarianship");
        sp4.setId(4);
        sp4.setDeskripsi("Kepustakawanan Akademik");
        spesialisasiDB.save(sp4);

        SpesialisasiModel sp5 = new SpesialisasiModel();
        sp5.setNama("School Librarianship");
        sp5.setId(5);
        sp5.setDeskripsi("Kepustakawanan Sekolah");
        spesialisasiDB.save(sp5);
    }

    @PreDestroy
    public void removeData() {
        spesialisasiDB.deleteAll();
    }*/


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
        return spesialisasiDB.findAll();
    }

}
