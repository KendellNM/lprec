package pe.edu.upeu.LP2_clase01.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.LP2_clase01.dao.AutorDao;
import pe.edu.upeu.LP2_clase01.entity.Autor;
import pe.edu.upeu.LP2_clase01.service.AutorService;
@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorDao dao;
	
	@Override
	public Autor create(Autor c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Autor update(Autor c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Autor> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
