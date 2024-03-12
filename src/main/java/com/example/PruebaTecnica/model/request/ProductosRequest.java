package com.example.PruebaTecnica.model.request;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductosRequest {
    private Long id;
    private String nombre;
    private Date fecRegistro;
}
