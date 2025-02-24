package lk.ijse.gdse71.supermarketlayered.dao.custom;

import lk.ijse.gdse71.supermarketlayered.dao.CrudDAO;
import lk.ijse.gdse71.supermarketlayered.entity.Item;
import lk.ijse.gdse71.supermarketlayered.entity.OrderDetails;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item> {
    public boolean reduceQty(OrderDetails orderDetails) throws SQLException, ClassNotFoundException;
}
