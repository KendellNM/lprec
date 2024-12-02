package pe.edu.upeu.LP2_clase01.daoImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.LP2_clase01.dao.RolDao;
import pe.edu.upeu.LP2_clase01.entity.Rol;
import pe.edu.upeu.LP2_clase01.repository.RolRepository;

import java.util.List;
import java.util.Optional;

@Component
public class RolDaoImpl implements RolDao {
	
	@Autowired
	private RolRepository rolesRepository;
	
	@Override
	public Rol create(Rol c) {
		// TODO Auto-generated method stub
		return rolesRepository.save(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return rolesRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		rolesRepository.deleteById(id);
	}

	@Override
	public Optional<Rol> read(Long id) {
		// TODO Auto-generated method stub
		return rolesRepository.findById(id);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

}
