package com.apap.tugas1.repository;

/**
 * Pusatakawan Db
 */

import com.apap.tugas1.model.PustakawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PustakawanDB extends JpaRepository<PustakawanModel, Long>{

    void deleteById(long id);

    PustakawanModel findById(long id);

    PustakawanModel findByNip(String nip);

}
