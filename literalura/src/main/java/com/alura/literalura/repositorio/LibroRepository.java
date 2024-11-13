package com.alura.literalura.repositorio;

import com.alura.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l ")
    List<Libro> obtenerLibrosRegistrados();
}
