package com.apap.tugas1.service;

import com.apap.tugas1.model.PustakawanModel;

import java.util.List;

/**
 * Pustakawan Service
 */

public interface PustakawanService {

    void addPustakawan(PustakawanModel pustakawan);

    PustakawanModel getPustakawanById (long id);

    PustakawanModel getPustakawanByNip (String nip);

    List<PustakawanModel> getAllPustakawan();
}


