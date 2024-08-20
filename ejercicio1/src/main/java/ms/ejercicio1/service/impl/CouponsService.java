package ms.ejercicio1.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1.feign.PersonsCoupons;
import ms.ejercicio1.model.Coupons;
import ms.ejercicio1.model.CouponsResponse;
import ms.ejercicio1.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CouponsService implements ICouponsService {

    @Autowired
    PersonsCoupons personsCoupons;

    @Override
    public CouponsResponse readAll() {
        try{
            CouponsResponse response = new CouponsResponse();
            response.setMensaje("Consulta exitosa");
            response.setCodigo(201L);
            response.setCouponsList(personsCoupons.getData());
            return response;
        }catch(Exception e){
            log.error(e.getMessage());
            log.error(e.getStackTrace().toString());
            CouponsResponse couponseResponse=new CouponsResponse();
            couponseResponse.setMensaje("Error al consumir el servicio");
            couponseResponse.setCodigo(404L);
            couponseResponse.setCouponsList(new ArrayList<>());
            return couponseResponse;
        }

    }
}
