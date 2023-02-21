package edu.dws.gestionPortatilesWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="PortatilesRepo")
public interface PortatilesRepo extends CrudRepository<Portatiles, Integer>{

}
