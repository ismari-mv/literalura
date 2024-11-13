package com.alura.literalura.dto;

import java.util.List;
import java.util.Map;

public record LibroDTO(
        Long id,
        String titulo,
        List<AutorDTO> autores,
        List<String> generos,
        List<String> idiomas,
        Double numeroDescargas,
        Map<String, String> formatos) {


    public LibroDTO (Long id, String titulo, List<AutorDTO> autores, List<String> generos, List<String> idiomas,
                     Double numeroDescargas, Map<String, String> formatos){
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.generos = generos;
        this.idiomas = idiomas;
        this.numeroDescargas = numeroDescargas;
        this.formatos = formatos;
    }



    @Override
    public String toString() {
        return "LibroDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", generos=" + generos +
                ", idiomas=" + idiomas +
                ", numeroDescargas=" + numeroDescargas +
                ", formatos=" + formatos +
                '}';
    }
}


