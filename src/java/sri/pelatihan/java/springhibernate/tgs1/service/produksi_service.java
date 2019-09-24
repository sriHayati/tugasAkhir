/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.produksi_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.produksi;

/**
 *
 * @author acer v5
 */
public interface produksi_service {
    public void saveDataProduksi(produksi_dto produksiDto) throws Exception;
    public List <produksi_dto> getListProduksi()throws Exception;
    public produksi getProduksiById(String id);
    public void deleteDataProduksi(String kode_produksi) throws Exception;
    public produksi_dto getUpdateDataProduksi(String kode_produksi) throws Exception;
    public void doUpdateDataProduksi(produksi_dto produksiDto) throws Exception;
}
