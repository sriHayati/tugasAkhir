/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.delivery;

/**
 *
 * @author acer v5
 */
public interface delivery_dao {

    public void saveDataDeliveryi(delivery deliveryModel) throws Exception;

    public List<delivery> getListDataDelivery() throws Exception;

    public delivery getDeliveryById(String id) throws Exception;

    public void deleteDelivery(String id);

    public void updateDelivery(delivery deliveryModel);

    public List<delivery> getListDeliveryUpdate(String kode_delivery);
}
