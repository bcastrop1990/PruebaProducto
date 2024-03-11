package com.example.PruebaTecnica.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductosRequest {
    private String dni;
    private String primerApellido;
    private String segundoApellido;
    private String preNombres;
}
