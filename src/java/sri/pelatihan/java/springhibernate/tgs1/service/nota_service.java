/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.nota_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.nota;

/**
 *
 * @author acer v5
 */
public interface nota_service {

    public void saveDataNota(nota_dto notaDto) throws Exception;

    public List<nota_dto> getListNota() throws Exception;

    public nota getNotaById(String id);

    public void deleteDataNota(String nama_produk) throws Exception;
}
