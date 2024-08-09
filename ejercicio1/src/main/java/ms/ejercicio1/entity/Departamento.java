package ms.ejercicio1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
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

    public Departamento() {
    }

    public Departamento(Long id, Double m2, Double precio, String direccion) {
        this.id = id;
        this.m2 = m2;
        this.precio = precio;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getM2() {
        return m2;
    }

    public void setM2(Double m2) {
        this.m2 = m2;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
