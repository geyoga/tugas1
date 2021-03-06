package com.apap.tugas1.model;

/*
* Pustakawan Model
* */

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 13)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @NotNull
    @Size(max = 100)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempat_lahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenis_kelamin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pustakawan_spesialisasi",
            joinColumns = {
                    @JoinColumn(name = "pustakawan_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "spesialisasi_id", referencedColumnName = "id", nullable = false, updatable = false)})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SpesialisasiModel> listSpesialisasi;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pustakawan_perpustakaan",
            joinColumns = {
                    @JoinColumn(name = "pustakawan_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "perpustakaan_id", referencedColumnName = "id", nullable = false, updatable = false)})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PerpustakaanModel> listPerpustakaan = new HashSet<>();

    /**
    * param all Set Method
    */

    public void setId(long id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNip(String nip){
        this.nip = nip;
    }
    public void setTempat_lahir(String tempat_lahir){
        this.tempat_lahir = tempat_lahir;
    }
    public void setTanggal_lahir(Date tanggal_lahir){
        this.tanggal_lahir = tanggal_lahir;
    }
    public void setJenis_kelamin(int jenis_kelamin){
        this.jenis_kelamin = jenis_kelamin;
    }
    public void setListSpesialisasi(List<SpesialisasiModel> listSpesialisasi){
        this.listSpesialisasi = listSpesialisasi;
    }
    public void setListPerpustakaan(Set<PerpustakaanModel> listPerpustakaan){
        this.listPerpustakaan = listPerpustakaan;
    }
    public void addSpesialisasi(SpesialisasiModel spesialisasi){
        listSpesialisasi.add(spesialisasi);
    }
    public void addPerpustakaan(PerpustakaanModel perpustakaan){
        listPerpustakaan.add(perpustakaan);
    }

    /**
     * return all get Method
     */

    public long getId(){
        return id;
    }
    public String getNama(){
        return  nama;
    }
    public String getNip(){
        return nip;
    }
    public String getTempat_lahir(){
        return tempat_lahir;
    }
    public Date getTanggal_lahir(){
        return tanggal_lahir;
    }
    public int getJenis_kelamin(){
        return  jenis_kelamin;
    }
    public List<SpesialisasiModel> getListSpesialisasi(){
        return listSpesialisasi;
    }
    public Set<PerpustakaanModel> getListPerpustakaan(){
        return listPerpustakaan;
    }
}