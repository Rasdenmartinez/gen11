package ms.ejercicio1.controller;

import jakarta.websocket.server.PathParam;
import lombok.Locked;
import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.service.IDepartamentoService;
import ms.ejercicio1.service.impl.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/departamento/{id}")
    public Departamento readById(@PathVariable Long id) {
        return departamentoService.readById(id);
    }

    @PostMapping("/departamento")
    public Departamento insert(@RequestBody Departamento departamento) {
        return departamentoService.insert(departamento);

    }

    @PutMapping("/departamento")
    public Departamento update(@RequestBody Departamento departamento) {
        return departamentoService.update(departamento);
    }
    @DeleteMapping("departamento/{id}")
    public void delete(@PathVariable Long id) {
        departamentoService.delete(id);
    }
    @GetMapping("departamento/direccion")
    public List<Departamento> direccion(@RequestParam String direccion, @RequestParam Double m2GreaterThan) {
        return departamentoService.buscarDireccion(direccion,m2GreaterThan);
    }
    @GetMapping("departamento/precioLowerThan")
    public List<Departamento> precioLowerThan(@RequestParam Double precio) {
        return departamentoService.precioLower(precio);
    }





}
