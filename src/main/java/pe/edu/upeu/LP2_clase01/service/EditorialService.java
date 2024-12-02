package pe.edu.upeu.LP2_clase01.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.LP2_clase01.entity.Editorial;

public interface EditorialService {
	Editorial create(Editorial c);
	Editorial update(Editorial c);
	void delete(Long id);
	Optional<Editorial> read(Long id);
	List<Editorial> readAll();
}
