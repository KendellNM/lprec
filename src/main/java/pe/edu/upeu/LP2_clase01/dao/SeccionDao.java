package pe.edu.upeu.LP2_clase01.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.LP2_clase01.entity.Seccion;



public interface SeccionDao {
	Seccion create(Seccion c);
	Seccion update(Seccion c);
	void delete(Long id);
	Optional<Seccion> read(Long id);
	List<Seccion> readAll();
}
