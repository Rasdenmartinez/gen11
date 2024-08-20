package ms.ejercicio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupons {
    private Long id;
    private String name;
    private String edad;
    private String direccion;
    private String city;
    private String animals;
    private String time;
}
