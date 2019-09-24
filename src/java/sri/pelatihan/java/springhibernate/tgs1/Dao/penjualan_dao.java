/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.penjualan;

/**
 *
 * @author acer v5
 */
public interface penjualan_dao {

    public void saveDataPenjualan(penjualan penjualanModel) throws Exception;

    public List<penjualan> getListDataPenjualan() throws Exception;

    public penjualan getPenjualanById(String id) throws Exception;

    public void deletePenjualan(String id);

}
