/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.pengeluaran;

/**
 *
 * @author acer v5
 */
public interface pengeluaran_dao {
    public void saveDataPengeluaran(pengeluaran pengeluaranModel) throws Exception;

    public List<pengeluaran> getListDataPengeluaran() throws Exception;

    public pengeluaran getPengeluaranById(String id) throws Exception;

    public void deletePengeluaran(String id);

    public void updatePengeluaran(pengeluaran pengeluaranModel);

    public List<pengeluaran> getListPegeluaranUpdate(String kode_pengeluaran);

}
