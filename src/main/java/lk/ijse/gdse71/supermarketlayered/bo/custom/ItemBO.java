package lk.ijse.gdse71.supermarketlayered.bo.custom;

import lk.ijse.gdse71.supermarketlayered.bo.SuperBO;
import lk.ijse.gdse71.supermarketlayered.dto.ItemDTO;
import lk.ijse.gdse71.supermarketlayered.dto.OrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
    public ItemDTO findById(String id) throws SQLException, ClassNotFoundException;
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException, ClassNotFoundException;
}
