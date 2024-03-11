package com.example.PruebaTecnica.dao.impl;

import com.example.PruebaTecnica.dao.ProductosDao;
import com.example.PruebaTecnica.dao.rowmapper.ProductoRowMapper;
import com.example.PruebaTecnica.model.bean.ProductosBean;
import com.example.PruebaTecnica.model.request.ProductosRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@AllArgsConstructor
public class ProductoDaoImpl implements ProductosDao {
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<ProductosBean> consultar(ProductosRequest request) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withCatalogName("IDO_PLATAFORMA_EXPE")
            .withProcedureName("SP_EJEMPLO")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(
                    new SqlParameter("P_VID", Types.VARCHAR),
                    new SqlParameter("P_VNOMBRE", Types.VARCHAR),
                    new SqlParameter("P_VFEC_REGISTRO", Types.VARCHAR),
                    new SqlOutParameter("C_CRRESULT", Types.REF_CURSOR,
                            new ProductoRowMapper()));
    SqlParameterSource prm = new MapSqlParameterSource()
            .addValue("P_VDNI", request.getDni());
    Map<String, Object> result = simpleJdbcCall.execute(prm);
    List<ProductosBean> beanList = (List) result.get("C_CRRESULT");
    return beanList;
  }

}
