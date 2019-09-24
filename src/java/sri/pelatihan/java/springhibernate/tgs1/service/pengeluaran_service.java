/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.pengeluaran_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.pengeluaran;

/**
 *
 * @author acer v5
 */
public interface pengeluaran_service {
    public void saveDataPengeluaran(pengeluaran_dto pengeluaranDto) throws Exception;
    public List <pengeluaran_dto> getListPengeluaran()throws Exception;
    public pengeluaran getPengeluaranById(String id);
    public void deleteDataPengeluaran(String kode_pengeluaran) throws Exception;
    public pengeluaran_dto getUpdateDataPengeluaran(String kode_pengeluaran) throws Exception;
    public void doUpdateDataPengeluaran(pengeluaran_dto pengeluaranDto) throws Exception;
}
