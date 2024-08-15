package ms.ejercicio1.controller;

import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @GetMapping("/persona")
    public List<Persona> getAllPersona()
    {
        return personaService.findAll();
    }
}
