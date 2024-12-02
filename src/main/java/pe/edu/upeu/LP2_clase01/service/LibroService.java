package pe.edu.upeu.LP2_clase01.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.LP2_clase01.entity.Libro;

public interface LibroService {
	Libro create(Libro c);
	Libro update(Libro c);
	void delete(Long id);
	Optional<Libro> read(Long id);
	List<Libro> readAll();
}
