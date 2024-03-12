package com.example.PruebaTecnica.dao.rowmapper;

import com.example.PruebaTecnica.model.Producto;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoRowMapper implements RowMapper<ProductosBean> {
  @Override
  public ProductosBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    ProductosBean producto = new ProductosBean();

    producto.setId(rs.getLong("ID")); // Asume que hay una columna 'ID' en tu ResultSet
    producto.setNombre(rs.getString("NOMBRE")); // Asume que hay una columna 'NOMBRE'
    producto.setFecRegistro(rs.getDate("FEC_REGISTRO")); // Asume que hay una columna 'FEC_REGISTRO'

    // Agrega aquí el mapeo para otros campos que tu modelo Producto pueda tener

    return producto;
  }
}
