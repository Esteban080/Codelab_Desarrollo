package com.desarrollo.pedido_service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.pedido_service.client.ProductoClient;
import com.desarrollo.pedido_service.DTO.ProductoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ProductoClient productoClient;

    public PedidoController(ProductoClient productoClient) {
        this.productoClient = productoClient;
    }

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping("/crear")
    public ResponseEntity<?> crearPedido() {
        List<ProductoDTO> productos = productoClient.obtenerProductos();
        return ResponseEntity.ok("Pedido creado con productos: " + productos);
    }
}