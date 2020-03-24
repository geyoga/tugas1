package com.apap.tugas1.model;

import javax.validation.constraints.NotNull;

/**
 * Buat Control form Spesialisasi Pustakawan
 */

public class addSpesialisasiForm {

    @NotNull
    private long pustakawanId;

    @NotNull
    private long spesialisasiId;

    private Iterable<SpesialisasiModel> listSpesialisasi;

    private PustakawanModel pustakawan;

    public addSpesialisasiForm(){}

    public addSpesialisasiForm(Iterable<SpesialisasiModel> listSpesialisasi, PustakawanModel pustakawan){

        this.listSpesialisasi = listSpesialisasi;
        this.pustakawan = pustakawan;

    }

    public long getPustakawanId(){
        return pustakawanId;
    }
    public void setPustakawanId(long pustakawanId){
        this.pustakawanId = pustakawanId;
    }
    public long getSpesialisasiId(){
        return spesialisasiId;
    }
    public void setSpesialisasiId(long spesialisasiId){
        this.spesialisasiId = spesialisasiId;
    }

    public Iterable<SpesialisasiModel> getListSpesialisasi() {
        return listSpesialisasi;
    }

    public void setListSpesialisasi(Iterable<SpesialisasiModel> listSpesialisasi) {
        this.listSpesialisasi = listSpesialisasi;
    }

    public PustakawanModel getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(PustakawanModel pustakawan) {
        this.pustakawan = pustakawan;
    }
}
