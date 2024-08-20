package ms.ejercicio1.controller;

import ms.ejercicio1.model.Coupons;
import ms.ejercicio1.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CouponsController {
    @Autowired
    ICouponsService couponsService;

    @GetMapping("/coupons")
    public List<Coupons> readAll(){
        return couponsService.readAll();
    }
}
