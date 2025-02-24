package lk.ijse.gdse71.supermarketlayered.bo.custom.Impl;

import lk.ijse.gdse71.supermarketlayered.bo.custom.CustomerBO;
import lk.ijse.gdse71.supermarketlayered.dao.DAOFactory;
import lk.ijse.gdse71.supermarketlayered.dao.custom.CustomerDAO;
import lk.ijse.gdse71.supermarketlayered.dto.CustomerDTO;
import lk.ijse.gdse71.supermarketlayered.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            customerDTOs.add(new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getNic(),
                    customer.getEmail(),
                    customer.getPhone()
            ));
        }
        return customerDTOs;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllIds();
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getPhone()
        ));
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getPhone()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNextId();
    }

    @Override
    public CustomerDTO findById(String id) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.findById(id);

        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getNic(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
}
