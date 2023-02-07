package com.banistmo.ing.reto.servicios;

import com.banistmo.ing.reto.modelos.Habilidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaludoServicio {
    public String saludo() {
        return "Hola Mundo";
    }
    public String imprimirHabilidades(String habilidades){
        return habilidades;
    }

    public List<String> imprimirHabilidades2(Habilidad habilidades){
        return habilidades.getHabilidades();
    }
}
