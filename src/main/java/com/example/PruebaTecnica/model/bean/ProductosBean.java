package com.example.PruebaTecnica.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
 public class ProductosBean {
 private Long id;
 private String nombre;
 private Date fecRegistro;

  public ProductosBean() {

  }
}
