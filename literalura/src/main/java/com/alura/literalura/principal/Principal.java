package com.alura.literalura.principal;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.excepciones.AutorNoEncontrado;
import com.alura.literalura.excepciones.AutorVivoNoEncontrado;
import com.alura.literalura.modelos.Autor;
import com.alura.literalura.modelos.DatosLibro;
import com.alura.literalura.modelos.Libro;
import com.alura.literalura.repositorio.AutorRepository;
import com.alura.literalura.repositorio.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import com.alura.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.AuthProvider;
import java.util.*;

@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI= new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos convierteDatos= new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private List<Libro> libros;
    private Optional<Libro> libroBuscado;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroService libroService;

    public Principal() {

    }

    public void muestraMenu(){
        var opcion= -1;
        while (opcion !=0){
            var menu= """
                    1.Buscar libro por titulo
                    2.Mostrar lista de libros registrados
                    3.Mostrar lista de autores registrados
                    4.Buscar autores vivos por determinado año
                    5.Buscar libros por idioma
                    
                    0.Salir
                    """;
            System.out.println(menu);
            opcion= teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    buscarLibroTitulo();
                    break;
                case 2:
                    mostrarListaDeLibros();
                    break;
                case 3:
                    mostrarListaDeAutores();
                    break;
                case 4:
                    mostrarListaDeAutoresVivos();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("la opción ingresada es invalida");
            }
        }
   }

    private void mostrarListaDeAutoresVivos() {
        System.out.println("Ingresa el año para buscar autores vivos: ");
        var ano= teclado.nextInt();
        teclado.nextLine();
        try {
            List<AutorDTO> autoresVivos = libroService.obtenerAutoresVivosPorAno(ano);
            autoresVivos.forEach(System.out::println);
        } catch (AutorVivoNoEncontrado e){
            System.out.println(e.getMessage());
        }
    }


    private void mostrarListaDeAutores() {
        try {
            List<AutorDTO> autorDTOS= libroService.obtenerAutoresRegistrados();
            autorDTOS.forEach(System.out::println);
        } catch (AutorNoEncontrado e){
            System.out.println(e.getMessage());
        }

    }


    public void mostrarListaDeLibros() {
       List<Libro> listaLibros = libroRepository.obtenerLibrosRegistrados();
       listaLibros.forEach(libro -> System.out.println(libro));
    }


    private void buscarLibroTitulo() {
        System.out.println("Escribe el titulo (o parte del titulo )del libro que deseas encontrar");
        var tituloLibro = teclado.nextLine();
        try {
            // Codifica el título del libro en formato URL
            String tituloCodificado = URLEncoder.encode(tituloLibro, StandardCharsets.UTF_8.toString());
            var json = consumoAPI.obtenerDatos(URL_BASE + tituloCodificado);
            System.out.println(json);
            DatosLibro datosLibro = convierteDatos.obtenerDatos(json, DatosLibro.class);
            Libro libro = new Libro(datosLibro.datosLibro().get(0));
            libroRepository.save(libro);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error al codificar el título: " + e.getMessage());
        }
    }


}
