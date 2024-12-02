package pe.edu.upeu.LP2_clase01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.LP2_clase01.entity.Libro;
import pe.edu.upeu.LP2_clase01.service.LibroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/libros")
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<Libro>> readAll(){
		try {
			List<Libro> libros = libroService.readAll();
			if(libros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(libros, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping
	public ResponseEntity<Libro> crear(@Valid @RequestBody Libro cat){
		try {
			Libro c = libroService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Libro> getLibroId(@PathVariable("id") Long id){
		try {
			Libro c = libroService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Libro> delLibro(@PathVariable("id") Long id){
		try {
			libroService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateLibro(@PathVariable("id") Long id, @Valid @RequestBody Libro cat){

			Optional<Libro> c = libroService.read(id);
			if(!c.isEmpty()) {
				return new ResponseEntity<>(libroService.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
