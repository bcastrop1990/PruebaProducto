package com.example.PruebaTecnica.controller;
import com.example.PruebaTecnica.model.request.ProductosRequest;
import com.example.PruebaTecnica.model.response.ApiResponse;
import com.example.PruebaTecnica.model.response.ListaProductosResponse;


import com.example.PruebaTecnica.service.ProductoService;
import com.example.PruebaTecnica.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos")
@AllArgsConstructor
public class PruebaTecnicaController {

    @PostMapping("expedientes/consultar")
    public ResponseEntity<ApiResponse<ListaProductosResponse>> consultar(@RequestBody ProductosRequest request) {

        return ResponseEntity.ok(ApiResponse.<ListaProductosResponse>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(ProductoService.obtenerPorId(request))
                .build());
    }
}
