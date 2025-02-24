package lk.ijse.gdse71.supermarketlayered.bo;

import lk.ijse.gdse71.supermarketlayered.bo.custom.Impl.CustomerBOImpl;
import lk.ijse.gdse71.supermarketlayered.bo.custom.Impl.ItemBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {
    }
    public static BOFactory getInstance() {
        return boFactory==null? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,ITEM,PLACE_ORDER,Query
    }

    public SuperBO getBO(BOType type) {
        switch (type) {
            case CUSTOMER: return new CustomerBOImpl();
            case ITEM: return new ItemBOImpl();
            case PLACE_ORDER: return new PlaceOrderBOImpl();
            case Query: return new QueryBOImpl();
            default: return null;
        }
    }
}
