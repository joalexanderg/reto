package com.banistmo.ing.reto.servicios;

import com.banistmo.ing.reto.modelos.Habilidad;
import com.banistmo.ing.reto.modelos.ResponseData;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.banistmo.ing.reto.utilidades.Utilidad.*;

@Component
public class EvaluarHabilidadesServicio {
  /*  public String evaluarHabilidades(Habilidad habilidad) {
        String mensaje = "";
        if (validarEntrada(habilidad.getHabilidades())) {
            System.out.println("El registro del candidato tiene valores validos");
            String[][] matrizHabilidades = convertirEnMatriz(habilidad.getHabilidades());
            List<String> columnasMasdiagonales = obtenerColumnasMasDiagonales(matrizHabilidades);
            System.out.println("Columnas y diagonales");

            for (String columnasMasDiagonales : columnasMasdiagonales) {
                System.out.println(columnasMasDiagonales);
            }

            List<String> filasColumnasDiagonales = unirListas(habilidad.getHabilidades(), columnasMasdiagonales);

            // Boolean esDesarrollador = esDesarrollador(skillsCandidato);
            Boolean esDesarrollador = esDesarrollador(filasColumnasDiagonales);
            if (esDesarrollador) {
                System.out.println("Es developer y bienvenido a Banistmo.");
                mensaje = "Es developer y bienvenido a Banistmo.";
            } else {
                System.out.println("Muchas gracias, pero no cumples con los requisitos.");
                mensaje = "Es developer y bienvenido a Banistmo.";
            }
        } else{
            System.out.println("El registro del candidato tiene valores invalidos");
            mensaje = "El registro del candidato tiene valores invalidos";
        }


        return mensaje;
    }*/

    public ResponseData evaluarHabilidades(Habilidad habilidad) {
        String mensaje = "";
        ResponseData respuestaServicio = new ResponseData();

        if (validarEntrada(habilidad.getHabilidades())) {
            System.out.println("El registro del candidato tiene valores validos");
            String[][] matrizHabilidades = convertirEnMatriz(habilidad.getHabilidades());
            List<String> columnasMasdiagonales = obtenerColumnasMasDiagonales(matrizHabilidades);
            System.out.println("Columnas y diagonales");

            for (String columnasMasDiagonales : columnasMasdiagonales) {
                System.out.println(columnasMasDiagonales);
            }

            List<String> filasColumnasDiagonales = unirListas(habilidad.getHabilidades(), columnasMasdiagonales);

            // Boolean esDesarrollador = esDesarrollador(skillsCandidato);
            Boolean esDesarrollador = esDesarrollador(filasColumnasDiagonales);
            if (esDesarrollador) {
                System.out.println("Es developer y bienvenido a Banistmo.");
                mensaje = "Es developer y bienvenido a Banistmo.";
                respuestaServicio.setCode(200);
                respuestaServicio.setMessage(mensaje);
                respuestaServicio.setStatus(Boolean.TRUE);
            } else {
                System.out.println("Muchas gracias, pero no cumples con los requisitos.");
                mensaje = "Es developer y bienvenido a Banistmo.";
                respuestaServicio.setCode(200);
                respuestaServicio.setMessage(mensaje);
                respuestaServicio.setStatus(Boolean.TRUE);
            }
        } else{
            System.out.println("El registro del candidato tiene valores invalidos");
            mensaje = "El registro del candidato tiene valores invalidos";
            respuestaServicio.setCode(400);
            respuestaServicio.setMessage(mensaje);
            respuestaServicio.setStatus(Boolean.TRUE);
        }


        return respuestaServicio;
    }

}
