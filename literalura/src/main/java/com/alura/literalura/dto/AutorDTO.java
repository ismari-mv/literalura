package com.alura.literalura.dto;

public record AutorDTO(
        String nombre,
        Integer fechaNacimiento,
        Integer fechaMuerte
) {
    public AutorDTO(String nombre,Integer fechaNacimiento,Integer fechaMuerte) {
        this.nombre= nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    @Override
    public String toString() {
        return "AutorDTO{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaMuerte=" + fechaMuerte +
                '}';
    }
}
