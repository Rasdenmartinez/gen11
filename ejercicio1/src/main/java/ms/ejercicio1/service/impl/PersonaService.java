package ms.ejercicio1.service.impl;

import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.model.ResponsePersona;
import ms.ejercicio1.repository.PersonaRepository;
import ms.ejercicio1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

//    @Override
//    public List<Persona> findByEdadPrecio(Long edad,Double precio) {
//        return personaRepository.findByEdadLessThan(edad).stream().filter(s->s.getIdDepartamento().getPrecio()<=precio).toList();
//    }

    @Override
    public List<Persona> findByEdadPrecio(Long edad,Double precio) {
        return personaRepository.edadPrecio(edad,precio);
    }

    @Override
    public List<ResponsePersona> responsePersona(Long edad, Double precio) {
        //DTO - DATA TRANSFER OBJECT
        List<Persona> personaList=personaRepository.edadPrecio(edad,precio);
        return  personaList.stream().map(s->{
            ResponsePersona responsePersona=new ResponsePersona();
            responsePersona.setIdPersona(s.getId());
            responsePersona.setNombre(s.getNombre());
            responsePersona.setEdad(s.getEdad());
            responsePersona.setIdDepartamento(s.getIdDepartamento().getId());
            responsePersona.setDireccio(s.getIdDepartamento().getDireccion());
            return responsePersona;
        }).toList();
    }


}
