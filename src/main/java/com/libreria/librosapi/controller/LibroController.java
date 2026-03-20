package com.libreria.librosapi.controller;



import com.libreria.librosapi.model.Libro;
import com.libreria.librosapi.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // GET /api/v1/libros → lista todos los libros
    @GetMapping
    public List<Libro> getAll() {
        return libroService.listAll();
    }

    // GET /api/v1/libros/{id} → obtiene un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getById(@PathVariable Long id) {
        return libroService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/v1/libros → crea un nuevo libro
    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    // PUT /api/v1/libros/{id} → actualiza un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro datos) {
        return libroService.update(id, datos)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/v1/libros/{id} → elimina un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}