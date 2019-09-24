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
public class stok_produk {
    String kode_produk;
    int stok_gudang, stok_toko, total_stok;

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public int getStok_gudang() {
        return stok_gudang;
    }

    public void setStok_gudang(int stok_gudang) {
        this.stok_gudang = stok_gudang;
    }

    public int getStok_toko() {
        return stok_toko;
    }

    public void setStok_toko(int stok_toko) {
        this.stok_toko = stok_toko;
    }

    public int getTotal_stok() {
        return total_stok;
    }

    public void setTotal_stok(int total_stok) {
        this.total_stok = total_stok;
    }
    
}
