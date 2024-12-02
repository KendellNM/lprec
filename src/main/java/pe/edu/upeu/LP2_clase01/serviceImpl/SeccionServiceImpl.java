package pe.edu.upeu.LP2_clase01.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.LP2_clase01.dao.SeccionDao;
import pe.edu.upeu.LP2_clase01.entity.Seccion;
import pe.edu.upeu.LP2_clase01.service.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService{
	
	@Autowired
	private SeccionDao seccionDao;

	@Override
	public Seccion create(Seccion c) {
		// TODO Auto-generated method stub
		return seccionDao.create(c);
	}

	@Override
	public Seccion update(Seccion c) {
		// TODO Auto-generated method stub
		return seccionDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		seccionDao.delete(id);
	}

	@Override
	public Optional<Seccion> read(Long id) {
		// TODO Auto-generated method stub
		return seccionDao.read(id);
	}

	@Override
	public List<Seccion> readAll() {
		// TODO Auto-generated method stub
		return seccionDao.readAll();
	}

}
