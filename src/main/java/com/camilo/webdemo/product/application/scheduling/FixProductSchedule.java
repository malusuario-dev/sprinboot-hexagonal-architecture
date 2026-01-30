package com.camilo.webdemo.product.application.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductSchedule {
//    private  final ProductRepository productRepository;
//    @Scheduled(fixedRate = 5000)
//    public void ficProductPrice(){
//
//        log.info("fixing products price");
//            productRepository.findall().forEach(producto -> {
//                producto.setPrecio(producto.getPrecio()*1.1);
//                productRepository.upsert(producto);
//            });
//            log.info("finised fixing price products");
//
//
//    }
}
