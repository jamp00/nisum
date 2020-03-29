package nisum.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nisum.com.dto.UsuarioRequest;
import nisum.com.implement.UsuarioImplement;
import nisum.com.model.Usuario;
import nisum.com.util.Util;

@CrossOrigin
@RestController
@RequestMapping(path = "/User", produces = "application/json", consumes = "application/json")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioImplement")
	private UsuarioImplement usuarioImplement;


	@GetMapping("/Usuario")
	public ResponseEntity<Usuario> agregarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest, HttpServletRequest request) throws Exception {

		final String jwtToken = request.getHeader("Authorization");

		Util util = new Util();

		if ( usuarioImplement.existByEmail(usuarioRequest.getEmail()) ) {
			return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.BAD_REQUEST);
		}

		Usuario objUsuario = util.mapUsuarioRequestToUsuario(usuarioRequest, jwtToken);

		return ResponseEntity.ok(usuarioImplement.Create(objUsuario));

	}

}

























