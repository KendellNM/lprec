package pe.edu.upeu.LP2_clase01.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.LP2_clase01.entity.Autor;

public interface AutorDao {
	Autor create(Autor c);
	Autor update(Autor c);
	void delete(Long id);
	Optional<Autor> read(Long id);
	List<Autor> readAll();
}
