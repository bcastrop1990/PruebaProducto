package com.example.PruebaTecnica.service.impl;

import com.example.PruebaTecnica.dao.ProductosDao;
import com.example.PruebaTecnica.model.Producto;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import com.example.PruebaTecnica.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductoServiceImpl implements ProductoService {
  private ProductosDao productosDao;


  @Override
  @Transactional
  public List<Producto> agregarYListarProductos(Producto producto) {
    log.info("Agregando producto y obteniendo lista de productos registrados en el día");

    // Llama al método en el DAO que ejecuta el procedimiento almacenado
    List<ProductosBean> productosBeans = productosDao.agregarYListar(producto);

    // Convierte ProductosBean a Producto si tus modelos difieren
    List<Producto> productos = productosBeans.stream().map(bean -> {
      Producto prod = new Producto();
      prod.setId(bean.getId());
      prod.setNombre(bean.getNombre());
      prod.setFecRegistro(bean.getFecRegistro());
      return prod;
    }).collect(Collectors.toList());

    return productos;
  }
}
