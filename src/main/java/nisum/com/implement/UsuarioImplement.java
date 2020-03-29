package nisum.com.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.com.model.Usuario;
import nisum.com.repository.UsuarioRepository;

@Service("UsuarioImplement")
public class UsuarioImplement {

	@Autowired
	private UsuarioRepository usuarioRepository;


	public Usuario Create(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	public boolean existByEmail( String email ) {

		return usuarioRepository.existsByEmail(email);
	}

}
