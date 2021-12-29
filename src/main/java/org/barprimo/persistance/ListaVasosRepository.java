package org.barprimo.persistance;

import java.util.List;
import java.util.Optional;

import org.barprimo.domain.repository.ListCupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ListaVasosRepository implements ListCupsRepository {

	@Autowired
	private org.barprimo.persistance.crud.ListaVasosCrudRepository listaVasosCrudRepository;

	@Override
	public Optional<org.barprimo.persistance.entity.ListaVasos> getById(int id) {
		// TODO Auto-generated method stub
		return listaVasosCrudRepository.findById(id);
	}

	
	
	

}
