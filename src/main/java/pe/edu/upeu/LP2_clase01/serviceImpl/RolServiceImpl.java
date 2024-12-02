package pe.edu.upeu.LP2_clase01.serviceImpl;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.LP2_clase01.dao.RolDao;
import pe.edu.upeu.LP2_clase01.entity.Rol;
import pe.edu.upeu.LP2_clase01.service.RolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolDao rolesDao;

	@Override
	public Rol create(Rol c) {
		// TODO Auto-generated method stub
		return rolesDao.create(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return rolesDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		rolesDao.delete(id);
	}

	@Override
	public Optional<Rol> read(Long id) {
		// TODO Auto-generated method stub
		return rolesDao.read(id);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolesDao.readAll();
	}

}
