package com.apap.tugas1.service;

/**
 * Pustakawan Service Implementation
 */


import com.apap.tugas1.model.PustakawanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.repository.PustakawanDB;

import java.util.List;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {

    @Autowired
    private PustakawanDB pustakawanDB;

    @Override
    public void addPustakawan(PustakawanModel pustakawan) {
        pustakawanDB.save(pustakawan);
    }

    @Override
    public PustakawanModel getPustakawanById(long id) {
        return pustakawanDB.findById(id);
    }

    @Override
    public PustakawanModel getPustakawanByNip(String nip) {
        return pustakawanDB.findByNip(nip);
    }

    @Override
    public List<PustakawanModel> getAllPustakawan() {
        return pustakawanDB.findAll();
    }

}
