package com.apap.tugas1.model;

/*
* Spesialisasi Model
* */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "deskripsi")
    private String deskripsi;

    // belum ada relasi


}