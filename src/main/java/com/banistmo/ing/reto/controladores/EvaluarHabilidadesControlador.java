package com.banistmo.ing.reto.controladores;

import com.banistmo.ing.reto.modelos.Habilidad;
import com.banistmo.ing.reto.servicios.EvaluarHabilidadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/evaluar", produces = MediaType.APPLICATION_JSON_VALUE)
public class EvaluarHabilidadesControlador {
    @Autowired
    EvaluarHabilidadesServicio evaluarHabilidadesServicio;

    @PostMapping(path = "/habilidad")
    public ResponseEntity retornarHabilidad(@RequestBody Habilidad habilidad) {
        return ResponseEntity.ok(this.evaluarHabilidadesServicio.evaluarHabilidades(habilidad));
    }
}
