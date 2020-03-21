package com.apap.tugas1.repository;
/**
 * Spesialisasi Db
 */

import com.apap.tugas1.model.SpesialisasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SpesialisasiDB extends JpaRepository<SpesialisasiModel, Long>{

    void deleteById(long id);

    SpesialisasiModel findById(long id);


}
