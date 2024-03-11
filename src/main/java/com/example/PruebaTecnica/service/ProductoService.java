package com.example.PruebaTecnica.service;

import com.example.PruebaTecnica.model.request.ProductosRequest;
import com.example.PruebaTecnica.model.response.ApiResponse;
import com.example.PruebaTecnica.model.response.ListaProductosResponse;

import java.util.List;

public interface ProductoService {

    ApiResponse<ListaProductosResponse> obtenerPorId(ProductosRequest request);
}
