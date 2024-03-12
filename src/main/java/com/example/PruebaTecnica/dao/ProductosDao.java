package com.example.PruebaTecnica.dao;

import com.example.PruebaTecnica.model.Producto;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import com.example.PruebaTecnica.model.request.ProductosRequest;

import java.util.List;
import java.util.Optional;

public interface ProductosDao {
   List<ProductosBean> agregarYListar(Producto request);

}
