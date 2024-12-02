package pe.edu.upeu.LP2_clase01.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.LP2_clase01.dao.LibroDao;
import pe.edu.upeu.LP2_clase01.entity.Libro;
import pe.edu.upeu.LP2_clase01.service.LibroService;
@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroDao libroDao;
	@Override
	public Libro create(Libro c) {
		// TODO Auto-generated method stub
		return libroDao.create(c);
	}

	@Override
	public Libro update(Libro c) {
		// TODO Auto-generated method stub
		return libroDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroDao.delete(id);
	}

	@Override
	public Optional<Libro> read(Long id) {
		// TODO Auto-generated method stub
		return libroDao.read(id);
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroDao.readAll();
	}

}
