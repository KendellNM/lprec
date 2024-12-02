package pe.edu.upeu.LP2_clase01.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upeu.LP2_clase01.dao.RolDao;
import pe.edu.upeu.LP2_clase01.dao.UsuariosDao;
import pe.edu.upeu.LP2_clase01.entity.Rol;
import pe.edu.upeu.LP2_clase01.entity.Usuario;
import pe.edu.upeu.LP2_clase01.exception.ResourceNotFoundException;
import pe.edu.upeu.LP2_clase01.service.UsuariosService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    
    @Autowired
    private UsuariosDao usuariosDao;

    @Autowired
    private RolDao rolesDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

   
    public Usuario inscribirUsuariosconRol(Long idUsuario, Long idRol) {
        Usuario usuario = usuariosDao.read(idUsuario)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Rol rol = rolesDao.read(idRol)
            .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

        usuario.getRoles().add(rol);
        rol.getUsuarios().add(usuario);

        return usuariosDao.create(usuario);
    }

    @Override
    public Usuario create(Usuario usuario) {
        // Codificar la contraseña del usuario antes de guardar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuariosDao.create(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuariosDao.update(usuario);
    }

    @Override
    public void delete(Long id) {
        usuariosDao.delete(id);
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuariosDao.read(id);
    }

    @Override
    public List<Usuario> readAll() {
        return usuariosDao.readAll();
    }
}
