/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.model;

/**
 *
 * @author acer v5
 */
public class pengeluaran {
    String kode_pengeluaran, tanggal, kode_akun, deskripsi;
    int jumlah;

    public String getKode_pengeluaran() {
        return kode_pengeluaran;
    }

    public void setKode_pengeluaran(String kode_pengeluaran) {
        this.kode_pengeluaran = kode_pengeluaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_akun() {
        return kode_akun;
    }

    public void setKode_akun(String kode_akun) {
        this.kode_akun = kode_akun;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
