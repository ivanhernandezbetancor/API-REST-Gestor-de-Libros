package com.libreria.librosapi.repository;

import com.libreria.librosapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Sin escribir nada más tienes disponibles:
    // findAll()       → todos los libros
    // findById(id)    → uno por ID (devuelve Optional)
    // save(libro)     → guardar o actualizar
    // deleteById(id)  → eliminar por ID
    // existsById(id)  → comprobar si existe
}