package ms.ejercicio1.service.impl;

import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.repository.DepartamentoRepository;
import ms.ejercicio1.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
    }
}
