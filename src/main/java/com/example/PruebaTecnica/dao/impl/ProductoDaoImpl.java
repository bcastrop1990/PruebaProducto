package com.example.PruebaTecnica.dao.impl;

import com.example.PruebaTecnica.dao.ProductosDao;
import com.example.PruebaTecnica.dao.rowmapper.ProductoRowMapper;
import com.example.PruebaTecnica.model.Producto;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import com.example.PruebaTecnica.model.request.ProductosRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class ProductoDaoImpl implements ProductosDao {
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<ProductosBean> agregarYListar(Producto request) {
    // Configurando SimpleJdbcCall
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
        .withCatalogName("prueba_tecnica") // Asegúrate de que el nombre del catálogo es correcto
        .withProcedureName("sp_insertar_producto_y_listar_del_dia")
        .declareParameters(
            new SqlParameter("p_id", Types.VARCHAR),
            new SqlParameter("p_nombre", Types.VARCHAR),
            new SqlParameter("p_fec_registro", Types.DATE),
            new SqlOutParameter("p_cursor", Types.REF_CURSOR, new ProductoRowMapper()))
        .withoutProcedureColumnMetaDataAccess();

    // Creando el objeto de parámetros para el procedimiento almacenado
    SqlParameterSource inParams = new MapSqlParameterSource()
        .addValue("p_id", request.getId())
        .addValue("p_nombre", request.getNombre())
        .addValue("p_fec_registro", request.getFecRegistro());

    // Ejecutando el procedimiento almacenado
    Map<String, Object> result = simpleJdbcCall.execute(inParams);

    // Obteniendo la lista de productos del cursor
    List<ProductosBean> productosList = (List<ProductosBean>) result.get("p_cursor");
    return productosList;
  }
}
