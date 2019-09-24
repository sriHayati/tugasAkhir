/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.akun_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.akun;

/**
 *
 * @author acer v5
 */
public interface akun_service {
    public void saveDataAkun(akun_dto akunDto) throws Exception;
    public List <akun_dto> getListAkun()throws Exception;
    public akun getAkunById(String id);
    public void deleteDataAkun(String kode_akun) throws Exception;
    public akun_dto getUpdateDataAkun(String kode_akun) throws Exception;
    public void doUpdateDataAkun(akun_dto akunDto) throws Exception;
}
