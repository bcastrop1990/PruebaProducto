package com.example.PruebaTecnica.controller;
import java.util.List;
import com.example.PruebaTecnica.model.Producto;


import com.example.PruebaTecnica.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class PruebaTecnicaController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<List<Producto>> agregarYListarProductos(@RequestBody Producto producto) {
        List<Producto> productos = productoService.agregarYListarProductos(producto);
        return ResponseEntity.ok(productos);
    }
}
