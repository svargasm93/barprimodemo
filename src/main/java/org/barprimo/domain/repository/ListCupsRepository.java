package org.barprimo.domain.repository;

import java.util.List;
import java.util.Optional;

import org.barprimo.persistance.entity.ListaVasos;

public interface ListCupsRepository {
	Optional<org.barprimo.persistance.entity.ListaVasos> getById(int id);
	
}
