package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleDTO {

    private Long id;
    private String numeroReferencia;
    private Long idTipoInmueble;
    private Long idEstadoInmueble;
    private Float precio;
    private Long idPropietario;
    private boolean llaves;
    private Long idOficina;
}