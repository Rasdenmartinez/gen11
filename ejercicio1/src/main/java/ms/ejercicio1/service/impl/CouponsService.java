package ms.ejercicio1.service.impl;

import ms.ejercicio1.feign.PersonsCoupons;
import ms.ejercicio1.model.Coupons;
import ms.ejercicio1.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponsService implements ICouponsService {

    @Autowired
    PersonsCoupons personsCoupons;

    @Override
    public List<Coupons> readAll() {
        return personsCoupons.getData();
    }
}
