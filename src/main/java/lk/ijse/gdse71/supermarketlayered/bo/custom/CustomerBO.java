package lk.ijse.gdse71.supermarketlayered.bo.custom;

import lk.ijse.gdse71.supermarketlayered.bo.SuperBO;
import lk.ijse.gdse71.supermarketlayered.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public String generateNextId() throws SQLException, ClassNotFoundException;
    public CustomerDTO findById(String id) throws SQLException, ClassNotFoundException;
}
