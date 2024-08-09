package ms.ejercicio1.service.impl;

import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.repository.DepartamentoRepository;
import ms.ejercicio1.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {

        return departamentoRepository.findAll();
    }

    @Override
    public Departamento readById(Long id) {
        Optional<Departamento> departamentoOptional=departamentoRepository.findById(id);
        if(departamentoOptional.isPresent()){
            return departamentoOptional.get();
        }else{
            return new Departamento();
        }
    }

    @Override
    public Departamento insert(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }


}
