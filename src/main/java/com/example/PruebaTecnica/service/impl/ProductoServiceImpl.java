package com.example.PruebaTecnica.service.impl;

import com.example.PruebaTecnica.dao.ProductosDao;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import com.example.PruebaTecnica.model.request.ProductosRequest;
import com.example.PruebaTecnica.model.response.ApiResponse;
import com.example.PruebaTecnica.model.response.ListaProductosResponse;
import com.example.PruebaTecnica.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductoServiceImpl implements ProductoService {
  private ProductosDao productosDao;

  @Override
  public ApiResponse<ListaProductosResponse> obtenerPorId(ProductosRequest request) {

    List<ProductosBean> result = productosDao.consultar(request);
    ApiResponse<ListaProductosResponse> response;
    
    return response;
  }
}
