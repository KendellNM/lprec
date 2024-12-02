package pe.edu.upeu.LP2_clase01.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.LP2_clase01.dao.EditorialDao;
import pe.edu.upeu.LP2_clase01.entity.Editorial;
import pe.edu.upeu.LP2_clase01.service.EditorialService;
@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialDao dao;
	
	@Override
	public Editorial create(Editorial c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Editorial update(Editorial c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Editorial> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
