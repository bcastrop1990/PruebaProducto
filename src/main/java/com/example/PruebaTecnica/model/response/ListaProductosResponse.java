package com.example.PruebaTecnica.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaProductosResponse {
  private String numeroSolicitud;
  private String fechaSolicitud;
  private String tipoRegistro;
  private String oficinaAutorizada;
  private String fechaRecepcion;
  private String fechaAsignacion;
  private String fechaAtencion;
  private String estadoSolicitud;
  private String analistaAsignado;
  private String dniSolicitante;
  private String codigoAnalistaAsignado;
}
