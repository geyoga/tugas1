package com.apap.tugas1.repository;


import com.apap.tugas1.model.PerpustakaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerpustakaanDB extends JpaRepository<PerpustakaanModel, Long>{

    PerpustakaanModel findById(long id);
}