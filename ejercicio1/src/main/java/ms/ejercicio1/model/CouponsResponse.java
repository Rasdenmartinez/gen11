package ms.ejercicio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponsResponse {
    private String mensaje;
    private Long codigo;
    private List<Coupons> couponsList;
}
