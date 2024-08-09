package ms.ejercicio1.controller;

import lombok.Locked;
import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.service.IDepartamentoService;
import ms.ejercicio1.service.impl.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    @Autowired
    private IDepartamentoService departamentoService;

    //CRUD - Create, Read, Update, Delete;
    @GetMapping("/departamento")
    public List<Departamento> readAll() {
        return departamentoService.readAll();
    }

    @GetMapping("departamento/{id}")
    public Departamento readById(@PathVariable Long id) {
        return departamentoService.readById(id);
    }

}
