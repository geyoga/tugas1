package com.apap.tugas1.service;

import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.model.SpesialisasiModel;

import java.util.List;

/**
 * Pustakawan Service
 */

public interface PustakawanService {

    void addPustakawan(PustakawanModel pustakawan);

    PustakawanModel getPustakawanById (long id);

    PustakawanModel getPustakawanByNip (String nip);

    List<PustakawanModel> getAllPustakawan();

    void deletePustakawan(long id);

}


