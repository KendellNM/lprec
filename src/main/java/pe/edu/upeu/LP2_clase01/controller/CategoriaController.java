package pe.edu.upeu.LP2_clase01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.LP2_clase01.entity.Categoria;
import pe.edu.upeu.LP2_clase01.service.CategoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> readAll(){
		try {
			List<Categoria> categorias = categoriaService.readAll();
			if(categorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria cat){
		try {
			Categoria c = categoriaService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaId(@PathVariable("id") Long id){
		try {
			Categoria c = categoriaService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Categoria> delCategoria(@PathVariable("id") Long id){
		try {
			categoriaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategoria(@PathVariable("id") Long id, @Valid @RequestBody Categoria cat){

			Optional<Categoria> c = categoriaService.read(id);
			if(!c.isEmpty()) {
				return new ResponseEntity<>(categoriaService.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
