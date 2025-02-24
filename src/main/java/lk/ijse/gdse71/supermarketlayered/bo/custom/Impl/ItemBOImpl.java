package lk.ijse.gdse71.supermarketlayered.bo.custom.Impl;

import lk.ijse.gdse71.supermarketlayered.bo.custom.ItemBO;
import lk.ijse.gdse71.supermarketlayered.dao.DAOFactory;
import lk.ijse.gdse71.supermarketlayered.dao.custom.ItemDAO;
import lk.ijse.gdse71.supermarketlayered.dto.ItemDTO;
import lk.ijse.gdse71.supermarketlayered.dto.OrderDetailsDTO;
import lk.ijse.gdse71.supermarketlayered.entity.Item;
import lk.ijse.gdse71.supermarketlayered.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllIds();
    }

    @Override
    public ItemDTO findById(String id) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.findById(id);

        return new ItemDTO(
                item.getItemId(),
                item.getItemName(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.reduceQty(new OrderDetails(orderDetailsDTO.getOrderId(),orderDetailsDTO.getItemId(),orderDetailsDTO.getQuantity(),orderDetailsDTO.getPrice()));
    }
}
