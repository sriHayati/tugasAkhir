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
public class delivery_dto {
    String kode_delivery,tanggal_delivery, keterangan, kode_produk;
    int jumlah;

    public String getKode_delivery() {
        return kode_delivery;
    }

    public void setKode_delivery(String kode_delivery) {
        this.kode_delivery = kode_delivery;
    }

    public String getTanggal_delivery() {
        return tanggal_delivery;
    }

    public void setTanggal_delivery(String tanggal_delivery) {
        this.tanggal_delivery = tanggal_delivery;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
    
    
}
