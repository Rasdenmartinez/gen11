package ms.ejercicio1.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1.constantes.DepartamentoConstantes;
import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.repository.DepartamentoRepository;
import ms.ejercicio1.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {

        return departamentoRepository.findAll().stream().filter(s->s.getIsActive()!= DepartamentoConstantes.Filtrado).toList();
    }

    @Override
    public Departamento readById(Long id) {
        Optional<Departamento> departamentoOptional=departamentoRepository.findById(id);
        if(departamentoOptional.isPresent() && departamentoOptional.get().getIsActive()!=DepartamentoConstantes.Filtrado){
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
    public Boolean delete(Long id) {
        Boolean bandera=false;
            Optional<Departamento> departamentoOptional=departamentoRepository.findById(id);
            if(departamentoOptional.isPresent()){
                Departamento departamento=departamentoOptional.get();
                departamento.setIsActive(false);
                departamentoRepository.save(departamento);
                log.info("Departamento {} deleted", id);
                bandera=true;
            }else{
                log.error("El id de departamento no existe");
            }
            return bandera;
    }

    @Override
    public List<Departamento> buscarDireccion(String direccion,Double graterThan) {
        return departamentoRepository.findByDireccionContainingIgnoreCaseAndM2GreaterThanEqual(direccion,graterThan);
    }

    @Override
    public List<Departamento> precioLower(Double precio) {
        return departamentoRepository.findByPrecioLessThan(precio);
    }

    public Double sumar(Double... numeros){
        Double sum=0.0;
        for(Double numero:numeros){
            sum+=numero;
        }
        return sum;
    }


}
