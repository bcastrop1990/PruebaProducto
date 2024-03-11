package com.example.PruebaTecnica.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
 public class ProductosBean {
  private Long idSolicitud;
  private String idTipoRegistro;
  private LocalDateTime fechaSolicitud;
  private LocalDateTime fechaRecepcion;
  private LocalDateTime fechaAtencion;
  private LocalDateTime fechaAsignacion;
  private String codigoUsuarioRecepcion;
  private String codigoEstado;
  private String codigoAnalistaAsignado;
  private String codigoTipoArchivoSustento;
}
