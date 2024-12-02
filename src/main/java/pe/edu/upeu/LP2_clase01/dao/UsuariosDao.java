package pe.edu.upeu.LP2_clase01.dao;

import pe.edu.upeu.LP2_clase01.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuariosDao {

	Usuario create(Usuario c);

	Usuario update(Usuario c);
	
	void delete(Long id);
	
	Optional<Usuario> read(Long id);
	
	Optional<Usuario> findByUsername(String username);
	
	List<Usuario> readAll();
	 
}
