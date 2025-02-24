package lk.ijse.gdse71.supermarketlayered.bo.custom.Impl;

import lk.ijse.gdse71.supermarketlayered.bo.custom.OrderBO;
import lk.ijse.gdse71.supermarketlayered.dao.CrudUtil;
import lk.ijse.gdse71.supermarketlayered.db.DBConnection;
import lk.ijse.gdse71.supermarketlayered.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    @Override
    public boolean save(Order order) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            boolean isOrderSaved = CrudUtil.execute(
                    "insert into orders values (?,?,?)",
                    order.getOrderId(),
                    order.getCustomerId(),
                    order.getOrderDate()
            );
            if (isOrderSaved) {
                boolean isOrderDetailListSaved = orderDetailsModel.saveOrderDetailsList(orderDTO.getOrderDetailsDTOS());
                if (isOrderDetailListSaved) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select order_id from orders order by order_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("O%03d", newIdIndex);
        }
        return "O001";
    }
}
