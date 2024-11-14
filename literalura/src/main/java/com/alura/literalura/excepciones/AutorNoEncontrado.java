package com.alura.literalura.excepciones;

import com.alura.literalura.modelos.Autor;

public class AutorNoEncontrado extends RuntimeException {
    public AutorNoEncontrado (String mensaje){
        super(mensaje);
    }
}
