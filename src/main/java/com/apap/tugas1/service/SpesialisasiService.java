package com.apap.tugas1.service;

import com.apap.tugas1.model.SpesialisasiModel;

import java.util.List;

/**
 * Spesialisasi Service Interface
 */

public interface SpesialisasiService {

    SpesialisasiModel getSpesialisasiById (long id);

    void addSpesialisasi (SpesialisasiModel spesialisasi);

    List<SpesialisasiModel> getAllSpesialisasi();
}
