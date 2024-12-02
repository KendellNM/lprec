package pe.edu.upeu.LP2_clase01.daoImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.LP2_clase01.dao.UsuariosDao;
import pe.edu.upeu.LP2_clase01.entity.Usuario;
import pe.edu.upeu.LP2_clase01.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UsuariosDaoImpl implements UsuariosDao {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Usuario create(Usuario c) {
        return usuariosRepository.save(c);
    }

    @Override
    public Usuario update(Usuario c) {
        return usuariosRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public List<Usuario> readAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuariosRepository.findByUsername(username);
    }
}
