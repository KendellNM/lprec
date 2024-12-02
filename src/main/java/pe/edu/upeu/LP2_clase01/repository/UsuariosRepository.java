package pe.edu.upeu.LP2_clase01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.LP2_clase01.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
	
}
