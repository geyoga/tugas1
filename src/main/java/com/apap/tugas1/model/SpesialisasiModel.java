package com.apap.tugas1.model;

/*
* Spesialisasi Model
* */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToMany(mappedBy = "listSpesialisasi", fetch = FetchType.LAZY)
    private List<PustakawanModel> listPustakawan = new ArrayList<PustakawanModel>();

    /**
     * param set all method
     */

    public void setId(long id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public  void  setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    public void setListPustakawan(List<PustakawanModel> listPustakawan){
        this.listPustakawan = listPustakawan;
    }

    /**
     * return get all method
     */

    public long getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    public List<PustakawanModel> getListPustakawan(){
        return listPustakawan;
    }

}