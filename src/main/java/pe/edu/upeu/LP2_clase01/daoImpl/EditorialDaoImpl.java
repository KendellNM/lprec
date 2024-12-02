package pe.edu.upeu.LP2_clase01.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.LP2_clase01.dao.EditorialDao;
import pe.edu.upeu.LP2_clase01.entity.Editorial;
import pe.edu.upeu.LP2_clase01.repository.EditorialRepository;
@Component
public class EditorialDaoImpl implements EditorialDao {
	
	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	public Editorial create(Editorial c) {
		// TODO Auto-generated method stub
		return editorialRepository.save(c);
	}

	@Override
	public Editorial update(Editorial c) {
		// TODO Auto-generated method stub
		return editorialRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(id);
	}

	@Override
	public Optional<Editorial> read(Long id) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(id);
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

}
