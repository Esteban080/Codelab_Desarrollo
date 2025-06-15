package com.desarrollo.pedido_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.desarrollo.pedido_service.DTO.ProductoDTO;

@FeignClient(name = "producto-service")
public interface ProductoClient {

    @GetMapping("/productos/productos")
    List<ProductoDTO> obtenerProductos();
}