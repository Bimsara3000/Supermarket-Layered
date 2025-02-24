package lk.ijse.gdse71.supermarketlayered.dao.custom.impl;

import lk.ijse.gdse71.supermarketlayered.dao.CrudUtil;
import lk.ijse.gdse71.supermarketlayered.dao.custom.ItemDAO;
import lk.ijse.gdse71.supermarketlayered.entity.Item;
import lk.ijse.gdse71.supermarketlayered.entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select item_id from item");

        ArrayList<String> itemIds = new ArrayList<>();

        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }

        return itemIds;
    }

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public Item findById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from item where item_id=?", id);

        if (rst.next()) {
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
        }

        return null;
    }

    @Override
    public boolean reduceQty(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update item set quantity = quantity - ? where item_id = ?",
                orderDetails.getQuantity(),
                orderDetails.getItemId()
        );
    }
}
