package ms.ejercicio1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "m2")
    private Double m2;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "is_active")
    private Boolean isActive;

}
