package com.example.PruebaTecnica.dao.rowmapper;

import com.example.PruebaTecnica.model.bean.ProductosBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoRowMapper implements RowMapper<ProductosBean> {
  @Override
  public ProductosBean mapRow(ResultSet rs, int i) throws SQLException {
    return ProductosBean.builder()
        .idDetalleSolicitud(rs.getLong("ID_DET_SOL_FIRMA"))
        .idSolicitud(rs.getLong("ID_SOLICITUD"))
        .idTipoSolicitud(rs.getString("ID_TIPO_SOLICITUD_FIRMA"))
        .primerApellido(rs.getString("AP_PRIMER_APELLIDO"))
        .segundoApellido(rs.getString("AP_SEGUNDO_APELLIDO"))
        .preNombres(rs.getString("NO_PRENOMBRES"))
        .numeroDocumento(rs.getString("NU_DOC_IDENTIDAD"))
        .idTipoDocumento(rs.getString("CO_TIPO_DOC_IDENTIDAD"))
        .celular(rs.getString("NU_CELULAR"))
        .email(rs.getString("DE_EMAIL"))
        .codigoEstadoFirma(rs.getString("CO_ESTADO_FIRMA"))
        .estado(rs.getString("CO_ESTADO"))
        .build();
  }
}
