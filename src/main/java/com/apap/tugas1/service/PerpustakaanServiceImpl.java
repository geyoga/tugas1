package com.apap.tugas1.service;

/**
 * Perpustakaan Service Implementation
 */


import com.apap.tugas1.model.PerpustakaanModel;
import com.apap.tugas1.repository.PerpustakaanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService{

    @Autowired
    private PerpustakaanDB perpustakaanDB;

    @Override
    public PerpustakaanModel getPerpustakaanById(long id) {
        return perpustakaanDB.findById(id);
    }

    @Override
    public List<PerpustakaanModel> getAllPerpustakaan() {
        return perpustakaanDB.findAll();
    }

    @Override
    public void addPerpustakaan(PerpustakaanModel perpustakaan) {
        perpustakaanDB.save(perpustakaan);
    }

    @Override
    public void deletePerpustakaan(long id) {
        perpustakaanDB.deleteById(id);
    }
}
