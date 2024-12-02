package pe.edu.upeu.LP2_clase01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.LP2_clase01.entity.Editorial;
import pe.edu.upeu.LP2_clase01.service.EditorialService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/editoriales")
public class EditorialController {
	@Autowired
	private EditorialService editorialService;
	
	@GetMapping
	public ResponseEntity<List<Editorial>> readAll(){
		try {
			List<Editorial> Editorials = editorialService.readAll();
			if(Editorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Editorials, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Editorial> crear(@Valid @RequestBody Editorial cat){
		try {
			Editorial c = editorialService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Editorial> getEditorialId(@PathVariable("id") Long id){
		try {
			Editorial c = editorialService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Editorial> delEditorial(@PathVariable("id") Long id){
		try {
			editorialService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEditorial(@PathVariable("id") Long id, @Valid @RequestBody Editorial cat){

			Optional<Editorial> c = editorialService.read(id);
			if(!c.isEmpty()) {
				return new ResponseEntity<>(editorialService.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
