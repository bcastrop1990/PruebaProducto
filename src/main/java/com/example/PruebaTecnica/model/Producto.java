package com.example.PruebaTecnica.model;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producto {
  private Long id;
  private String nombre;
  private Date fecRegistro;
}
