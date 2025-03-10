package lk.ijse.gdse71.supermarketlayered.entity;

import lombok.*;

/**
 * --------------------------------------------
 * Author: R.I.B. Shamodha Sahan Rathnamalala
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 10/11/2024 2:44 PM
 * Project: supermarketfx-71
 * --------------------------------------------
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String itemId;
    private int quantity;
    private double price;
}
