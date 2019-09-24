/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.DTO;

/**
 *
 * @author acer v5
 */
public class produksi_dto {
    String kode_produksi, tanggal_produksi, kode_produk;
    int jumlah;
    String keterangan;

    public String getKode_produksi() {
        return kode_produksi;
    }

    public void setKode_produksi(String kode_produksi) {
        this.kode_produksi = kode_produksi;
    }

    public String getTanggal_produksi() {
        return tanggal_produksi;
    }

    public void setTanggal_produksi(String tanggal_produksi) {
        this.tanggal_produksi = tanggal_produksi;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
