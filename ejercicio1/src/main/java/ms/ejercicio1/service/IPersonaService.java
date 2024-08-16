package ms.ejercicio1.service;

import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.model.ResponsePersona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll();
    public List<Persona> findByEdadPrecio(Long edad,Double precio);
    public List<ResponsePersona> responsePersona(Long edad, Double precio);
}
