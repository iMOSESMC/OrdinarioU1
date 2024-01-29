package utez.edu.mx.Libros.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import utez.edu.mx.Libros.Entity.Bean.BeanLibro;
import utez.edu.mx.Libros.Entity.Dto.DtoLibro;
import utez.edu.mx.Libros.Service.ILibro;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private ILibro libroService;

    @PostMapping("/")
    public ResponseEntity<BeanLibro> guardarLibro(@RequestBody DtoLibro libro) {
        BeanLibro libroGuardado = libroService.save(libro);
        return new ResponseEntity<>(libroGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeanLibro> obtenerLibroPorId(@PathVariable Long id) {
        BeanLibro libro = libroService.findById(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<BeanLibro>> obtenerTodosLosLibros() {
        List<BeanLibro> libros = libroService.findAll();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        BeanLibro libro = libroService.findById(id);
        if (libro != null) {
            libroService.delete(libro);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}