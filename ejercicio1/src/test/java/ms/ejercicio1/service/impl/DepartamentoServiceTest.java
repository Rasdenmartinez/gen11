package ms.ejercicio1.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {
    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;

    @BeforeEach
    void setUp() {
        log.info("setUp before method");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown after method");
    }

    @Test
    void sumar() {
        Double res=departamentoService.sumar(4.0,6.0,0.0);
        Assertions.assertEquals(10.0,res);
        log.info("sumar departamento");
    }

    @Test
    void delete() {
        log.info("delete departamento");
        Departamento departamento = new Departamento(5L,900.00,1500000.00,"Centro, cdmx",true, LocalDateTime.now(),LocalDateTime.now());
        Mockito.when(departamentoRepository.findById(5L)).thenReturn(Optional.of(departamento));
        Mockito.when(departamentoRepository.save(departamento)).thenReturn(departamento);
        Boolean res=departamentoService.delete(5L);
        Assertions.assertEquals(true,res);
    }

    @Test
    void deleteElse() {
        log.info("delete departamento");
        Departamento departamento = new Departamento(10L,900.00,1500000.00,"Centro, cdmx",true, LocalDateTime.now(),LocalDateTime.now());
        Mockito.when(departamentoRepository.findById(10L)).thenReturn(Optional.ofNullable(null));
//        Mockito.when(departamentoRepository.save(departamento)).thenReturn(departamento);
        Boolean res=departamentoService.delete(10L);
        Assertions.assertEquals(false,res);
    }
}