package com.apap.tugas1.service.pustakawan;

/**
 * Pustakawan Service Implementation
 */


import com.apap.tugas1.model.PustakawanModel;
import com.apap.tugas1.service.pustakawan.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.repository.PustakawanDb;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {

    @Autowired
    private PustakawanDb pustakawanDb;

    @Override
    public PustakawanModel addPustakawan(PustakawanModel pustakawan) {
        return pustakawanDb.save(pustakawan);
    }
}
