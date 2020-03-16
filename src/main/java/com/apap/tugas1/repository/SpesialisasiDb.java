package com.apap.tugas1.repository;

/**
 * Spesialisasi Db
 */

import com.apap.tugas1.model.SpesialisasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Long>{

    void deleteById(long id);
}
