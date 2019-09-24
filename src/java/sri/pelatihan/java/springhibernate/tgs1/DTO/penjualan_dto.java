/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.DTO;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.customer;

/**
 *
 * @author acer v5
 */
public class penjualan_dto {
    String kode_penjualan, kode_produk, quantity, kode_customer;
    
    List<customer> listDataCustomer;

    public List<customer> getListDataCustomer() {
        return listDataCustomer;
    }

    public void setListDataCustomer(List<customer> listDataCustomer) {
        this.listDataCustomer = listDataCustomer;
    }

    public String getKode_penjualan() {
        return kode_penjualan;
    }

    public void setKode_penjualan(String kode_penjualan) {
        this.kode_penjualan = kode_penjualan;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getKode_customer() {
        return kode_customer;
    }

    public void setKode_customer(String kode_customer) {
        this.kode_customer = kode_customer;
    }
    
    
    
    
}
