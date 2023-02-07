package com.banistmo.ing.reto.controladores;

import com.banistmo.ing.reto.modelos.Habilidad;
import com.banistmo.ing.reto.servicios.SaludoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/evaluar2", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaludoControlador {
    @Autowired
    SaludoServicio saludoServicio;

    @GetMapping("/saludo")
    public ResponseEntity diceHola() {
        return ResponseEntity.ok(this.saludoServicio.saludo());
    }

    @PostMapping(path = "/habilidad")
    public ResponseEntity retornarHabilidad(@RequestBody String habilidad) {
        System.out.println("Ingreso --------------------->>>>>>>>>>>>>>");
        System.out.println("Ingreso --------------------->>>>>>>>>>>>>>" + habilidad);

        return ResponseEntity.ok(this.saludoServicio.imprimirHabilidades(habilidad));

    }

    @PostMapping(path = "/habilidad2")
    public ResponseEntity retornarHabilidad2(@RequestBody Habilidad habilidad) {
        System.out.println("Ingreso --------------------->>>>>>>>>>>>>>");
        // System.out.println("Ingreso --------------------->>>>>>>>>>>>>>"+habilidad.getHabilidades().size());

        return ResponseEntity.ok(this.saludoServicio.imprimirHabilidades2(habilidad));

    }

}
