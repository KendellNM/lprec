package pe.edu.upeu.LP2_clase01.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.LP2_clase01.dao.AutorDao;
import pe.edu.upeu.LP2_clase01.entity.Autor;
import pe.edu.upeu.LP2_clase01.repository.AutorRepository;
@Component
public class AutorDaoImpl implements AutorDao {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public Autor create(Autor c) {
		// TODO Auto-generated method stub
		return autorRepository.save(c);
	}

	@Override
	public Autor update(Autor c) {
		// TODO Auto-generated method stub
		return autorRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public Optional<Autor> read(Long id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id);
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

}
