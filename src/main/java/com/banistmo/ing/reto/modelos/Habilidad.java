package com.banistmo.ing.reto.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Habilidad {
    private List<String> habilidades;

    public List<String> getHabilidades() {
        return habilidades;
    }
}
