package pe.edu.upeu.LP2_clase01.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.LP2_clase01.dao.LibroDao;
import pe.edu.upeu.LP2_clase01.entity.Libro;
import pe.edu.upeu.LP2_clase01.repository.LibroRepository;
@Component
public class LibroDaoImpl implements LibroDao {

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public Libro create(Libro c) {
		// TODO Auto-generated method stub
		return libroRepository.save(c);
	}

	@Override
	public Libro update(Libro c) {
		// TODO Auto-generated method stub
		return libroRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}

	@Override
	public Optional<Libro> read(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id);
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}

}
