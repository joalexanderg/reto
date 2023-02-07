package com.banistmo.ing.reto.utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Utilidad {
    public static Boolean validarEntrada(List<String> entradaSkill) {
        if (entradaSkill.size() == 6) {
            char[] vectorCaracteres;
            //Validar letras
            for (String entrada : entradaSkill) {
                vectorCaracteres = entrada.toCharArray();
                for (char letra : vectorCaracteres) {
                    if (!letraValida(letra)) {
                        return false;
                    }

                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static Boolean letraValida(char letra) {
        boolean valida;

        switch (letra) {
            case 'B':
            case 'N':
            case 'T':
            case 'M':
                valida = true;
                break;
            default:
                valida = false;
        }
        return valida;
    }

    public static String[][] convertirEnMatriz(List<String> habilidad) {
        String[][] matrizHabilidades = new String[habilidad.size()][habilidad.size()];
        System.out.println("-------------------------------------------");
        for (String fila : habilidad) {
            System.out.println(fila);
        }
        System.out.println("-------------------------------------------");

        int contadorFila = 0;
        for (String fila : habilidad) {
            char[] vectorfila = fila.toCharArray();

            String secuenciaFila = "";
            for (int i = 0; i < fila.length(); i++) {
                secuenciaFila = secuenciaFila + vectorfila[i];
                matrizHabilidades[contadorFila][i] = String.valueOf(vectorfila[i]);
            }
            contadorFila++;

        }
        System.out.println("MaTRIZ");
        imprimirMatriz(matrizHabilidades);
        return matrizHabilidades;
    }

    public static void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < 6; i++) {
            StringBuilder fila = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                fila.append(matriz[i][j]);
            }
            System.out.println(fila);
        }
    }

    public static List<String> obtenerColumnasMasDiagonales(String[][] habilidad) {
        List<String> listaColumnasMasDiagonales = new ArrayList<>();

        String diagonalPrimaria = "";
        String diagonalSecundaria = "";
        int n = 6;
        for (int j = 0; j < n; j++) {
            StringBuilder columna = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == j) {
                    diagonalPrimaria = diagonalPrimaria + habilidad[i][j];
                }
                if (j == ((n - 1) - i)) {
                    diagonalSecundaria = diagonalSecundaria + habilidad[i][j];
                }
                columna.append(habilidad[i][j]);

            }
            listaColumnasMasDiagonales.add(columna.toString());
        }
        listaColumnasMasDiagonales.add(diagonalPrimaria);
        listaColumnasMasDiagonales.add(diagonalSecundaria);
        return listaColumnasMasDiagonales;
    }

    public static <T> List<T> unirListas(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();
        Stream.of(list1, list2).forEach(list::addAll);

        return list;
    }

    public static Boolean esDesarrollador(List<String> habilidad) {
        final String[] RESULTADO_ESPERADO = {"BBBB", "NNNN", "TTTT", "MMMM"};

        for (String valorEsperado : RESULTADO_ESPERADO) {

            Optional<String> resultadoPositivo = habilidad.stream()
                    .filter(c -> c.contains(valorEsperado))
                    .findFirst();


            if (resultadoPositivo.isPresent()) {
                System.out.println("+++++++++++++++++++" + resultadoPositivo);
                return true;
            }
        }

        return false;
    }
}
