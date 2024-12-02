package pe.edu.upeu.LP2_clase01.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.LP2_clase01.dao.SeccionDao;
import pe.edu.upeu.LP2_clase01.entity.Seccion;
import pe.edu.upeu.LP2_clase01.repository.SeccionRepository;

@Component
public class SeccionDaoImpl implements SeccionDao{
	
	@Autowired
	private SeccionRepository repository;

	@Override
	public Seccion create(Seccion c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public Seccion update(Seccion c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<Seccion> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Seccion> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
