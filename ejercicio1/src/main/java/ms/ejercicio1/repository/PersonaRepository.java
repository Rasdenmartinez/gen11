package ms.ejercicio1.repository;

import ms.ejercicio1.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByEdadLessThan(Long edad);

    @Query(value = "select pe.id, pe.nombre, pe.edad, pe.id_departamento, pe.create_date, pe.update_date  from persona pe\n" +
            "inner join departamento de on pe.id_departamento = de.id \n" +
            "where de.precio <= :precio and pe.edad <= :edad;",nativeQuery = true)
    List<Persona> edadPrecio (Long edad, Double precio);
}
