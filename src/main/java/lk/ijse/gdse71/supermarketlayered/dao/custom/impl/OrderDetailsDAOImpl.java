package lk.ijse.gdse71.supermarketlayered.dao.custom.impl;

import lk.ijse.gdse71.supermarketlayered.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse71.supermarketlayered.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException, ClassNotFoundException {
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
    public OrderDetails findById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
