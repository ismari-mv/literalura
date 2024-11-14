package com.alura.literalura.excepciones;

public class AutorVivoNoEncontrado extends RuntimeException {
    public AutorVivoNoEncontrado(String message) {
        super(message);
    }
}
