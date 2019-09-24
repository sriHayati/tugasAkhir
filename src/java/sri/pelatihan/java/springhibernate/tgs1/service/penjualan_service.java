/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.penjualan_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.penjualan;

/**
 *
 * @author acer v5
 */
public interface penjualan_service {
    public void saveDataPenjualan(penjualan_dto penjualanDto) throws Exception;
    public List <penjualan_dto> getListPenjualan()throws Exception;
    public penjualan getPenjualanById(String id);
    public void deleteDataPenjualan(String kode_penjualan) throws Exception;
}
