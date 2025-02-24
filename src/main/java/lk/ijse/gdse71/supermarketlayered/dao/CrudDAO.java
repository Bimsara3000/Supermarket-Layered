package lk.ijse.gdse71.supermarketlayered.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
    public boolean save(T dto) throws SQLException, ClassNotFoundException;
    public boolean update(T dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public String generateNextId() throws SQLException, ClassNotFoundException;
    public T findById(String id) throws SQLException, ClassNotFoundException;
}
