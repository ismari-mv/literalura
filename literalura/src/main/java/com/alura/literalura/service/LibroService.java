package com.alura.literalura.service;

import com.alura.literalura.modelos.Libro;
import com.alura.literalura.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

        @Autowired
        private LibroRepository libroRepository;

        public  List<Libro> obtenerLibrosRegistrados() {
            return libroRepository.obtenerLibrosRegistrados();
        }
}
