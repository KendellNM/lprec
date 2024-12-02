package pe.edu.upeu.LP2_clase01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.LP2_clase01.entity.Seccion;
import pe.edu.upeu.LP2_clase01.service.SeccionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/secciones")
public class SeccionController {

	@Autowired
	private SeccionService seccionService;
	
	@GetMapping
	public ResponseEntity<List<Seccion>> readAll(){
		try {
			List<Seccion> Seccions = seccionService.readAll();
			if(Seccions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Seccions, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Seccion> crear(@Valid @RequestBody Seccion cat){
		try {
			Seccion c = seccionService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSeccionId(@PathVariable("id") Long id){
		try {
			Optional<Seccion> c = seccionService.read(id);
			if(c.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(c, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Seccion> delSeccion(@PathVariable("id") Long id){
		try {
			seccionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateSeccion(@PathVariable("id") Long id, @Valid @RequestBody Seccion cat){

			Optional<Seccion> c = seccionService.read(id);
			if(c.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				
				return new ResponseEntity<>(seccionService.update(cat), HttpStatus.OK);
			}		
		
	}
}
