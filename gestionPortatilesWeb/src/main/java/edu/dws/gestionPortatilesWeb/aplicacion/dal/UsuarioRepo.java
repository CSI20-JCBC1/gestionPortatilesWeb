package edu.dws.gestionPortatilesWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository(value="UsuarioRepo")
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {

}
