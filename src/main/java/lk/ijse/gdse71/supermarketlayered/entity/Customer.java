package lk.ijse.gdse71.supermarketlayered.entity;

import lombok.*;

/**
 * --------------------------------------------
 * Author: R.I.B. Shamodha Sahan Rathnamalala
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 10/4/2024 3:25 PM
 * Project: supermarketfx
 * --------------------------------------------
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}
