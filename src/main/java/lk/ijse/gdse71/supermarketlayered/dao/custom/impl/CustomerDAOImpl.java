package lk.ijse.gdse71.supermarketlayered.dao.custom.impl;

import lk.ijse.gdse71.supermarketlayered.dao.CrudUtil;
import lk.ijse.gdse71.supermarketlayered.dao.custom.CustomerDAO;
import lk.ijse.gdse71.supermarketlayered.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from customer");

        ArrayList<Customer> customers = new ArrayList<>();

        while (rst.next()) {
            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select customer_id from customer");

        ArrayList<String> customerIds = new ArrayList<>();

        while (rst.next()) {
            customerIds.add(rst.getString(1));
        }

        return customerIds;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "insert into customer values (?,?,?,?,?)",
                customer.getCustomerId(),
                customer.getName(),
                customer.getNic(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update customer set name=?, nic=?, email=?, phone=? where customer_id=?",
                customer.getName(),
                customer.getNic(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCustomerId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from customer where customer_id=?", id);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select customer_id from customer order by customer_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("C%03d", newIdIndex);
        }
        return "C001";
    }

    @Override
    public Customer findById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from customer where customer_id=?", id);

        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }
}
