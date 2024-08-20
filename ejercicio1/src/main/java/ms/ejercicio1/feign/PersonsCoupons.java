package ms.ejercicio1.feign;

import ms.ejercicio1.model.Coupons;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "personsCoupons", url = "https://6331c39d3ea4956cfb66c90d.mockapi.io/persons")
public interface PersonsCoupons {

    @GetMapping("/coupons")
    List<Coupons> getData();

//    @PostMapping("/endpoint")
//    ResponseEntity<MyResponse> postData(@RequestBody MyRequest request);
}
