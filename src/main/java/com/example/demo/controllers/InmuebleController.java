package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InmuebleDTO;
import com.example.demo.dto.InmuebleDTOlistar;
import com.example.demo.services.ServiceInmueble;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "API de inmuebles", description = "Esta api server tiene toda la funcionalidad de los inmuebles")
@RestController
@RequestMapping("/inmuebles")
@AllArgsConstructor
public class InmuebleController {

    private ServiceInmueble serviceInmueble;

    @Operation(description = "Retorna todos los datos de los inmuebles", summary = "Return 204 si no hay registros")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal error") })
    @GetMapping("/")
    public ResponseEntity<List<InmuebleDTOlistar>> findAll() {
        List<InmuebleDTOlistar> findAll = serviceInmueble.findAll();
        if (findAll == null || findAll.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(findAll);
        }
    }

    @Operation(description = "Retorna todos los datos de los inmuebles filtrados por el numero de referencia", summary = "Return 204 si no hay registros")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Exito"),
    @ApiResponse(responseCode = "500", description = "Internal error") })
    @GetMapping("/numeroReferencia/{numero}")
    public ResponseEntity<List<InmuebleDTOlistar>> findByNumeroReferencia(@PathVariable String numero) {
        List<InmuebleDTOlistar> inmuebles = serviceInmueble.findByNumeroReferencia(numero);
        if (inmuebles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(inmuebles);
        }
    }

    @Operation(description = "Añade un nuevo inmueble", summary = "Return 204 si no hay registros")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal error") })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public InmuebleDTO save(@RequestBody InmuebleDTO inmuebleDTO) {
        return serviceInmueble.save(inmuebleDTO);
    }

}
