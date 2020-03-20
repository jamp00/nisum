package nisum.com.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nisum.com.model.Usuario;

@Repository("UsuarioRepository")
public interface UsuarioRepository  extends CrudRepository<Usuario, Serializable> {

	public abstract boolean existsByEmail(String email);

}
