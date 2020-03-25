package com.apap.tugas1.service;

import com.apap.tugas1.model.PerpustakaanModel;

import java.util.List;

/**
 * Perpustakaan Service
 */

public interface PerpustakaanService {

    PerpustakaanModel getPerpustakaanById (long id);

    List<PerpustakaanModel> getAllPerpustakaan();

    void addPerpustakaan(PerpustakaanModel perpustakaan);

    void deletePerpustakaan(long id);

}
