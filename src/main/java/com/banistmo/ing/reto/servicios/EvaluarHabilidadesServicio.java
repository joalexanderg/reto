package com.banistmo.ing.reto.servicios;

import com.banistmo.ing.reto.modelos.Habilidad;
import com.banistmo.ing.reto.modelos.ResponseData;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.banistmo.ing.reto.utilidades.Constantes.*;
import static com.banistmo.ing.reto.utilidades.Utilidad.*;

@Component
public class EvaluarHabilidadesServicio {
    public ResponseData evaluarHabilidades(Habilidad habilidad) {
        ResponseData respuestaServicio = new ResponseData();

        if (validarEntrada(habilidad.getHabilidades())) {
            System.out.println("El registro del candidato tiene valores validos");
            String[][] matrizHabilidades = convertirEnMatriz(habilidad.getHabilidades());
            List<String> columnasMasdiagonales = obtenerColumnasMasDiagonales(matrizHabilidades);
            System.out.println("Columnas y diagonales");

            List<String> filasColumnasDiagonales = unirListas(habilidad.getHabilidades(), columnasMasdiagonales);

            Boolean esDesarrollador = esDesarrollador(filasColumnasDiagonales);
            if (esDesarrollador) {
                System.out.println("Es developer y bienvenido a Banistmo.");
                respuestaServicio.setCode(CODE_200);
                respuestaServicio.setMessage(MENSAJE_DE_APROBACION);
                respuestaServicio.setStatus(Boolean.TRUE);
            } else {
                System.out.println("Muchas gracias, pero no cumples con los requisitos.");
                respuestaServicio.setCode(CODE_200);
                respuestaServicio.setMessage(MENSAJE_DE_NO_APROBACION);
                respuestaServicio.setStatus(Boolean.TRUE);
            }
        } else{
            System.out.println("El registro del candidato tiene valores invalidos");
            respuestaServicio.setData(habilidad.getHabilidades());
            respuestaServicio.setCode(CODE_400);
            respuestaServicio.setMessage(MENSAJE_VALORES_DE_INGRESO_INVALIDOS);
            respuestaServicio.setStatus(Boolean.TRUE);
        }
        return respuestaServicio;
    }
}
