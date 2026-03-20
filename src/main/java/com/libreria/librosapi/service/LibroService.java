package com.libreria.librosapi.service;



import com.libreria.librosapi.model.Libro;
import com.libreria.librosapi.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    // Inyección por constructor (forma recomendada)
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Listar todos los libros
    public List<Libro> listAll() {
        return libroRepository.findAll();
    }

    // Buscar un libro por ID
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    // Guardar un libro nuevo
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualizar un libro existente
    public Optional<Libro> update(Long id, Libro datos) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(datos.getTitulo());
            libro.setAutor(datos.getAutor());
            libro.setAnioPublicacion(datos.getAnioPublicacion());
            libro.setPrecio(datos.getPrecio());
            libro.setDisponible(datos.isDisponible());
            return libroRepository.save(libro);
        });
    }

    // Eliminar un libro por ID
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}