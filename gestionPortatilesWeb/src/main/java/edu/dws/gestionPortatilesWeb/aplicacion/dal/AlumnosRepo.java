package edu.dws.gestionPortatilesWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="AlumnosRepo")
public interface AlumnosRepo extends CrudRepository<Alumnos, Integer>{

}
