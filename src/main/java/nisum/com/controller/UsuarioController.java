package nisum.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nisum.com.dto.UsuarioRequest;
import nisum.com.implement.UsuarioImplement;
import nisum.com.model.Usuario;
import nisum.com.util.Util;

@CrossOrigin
@RestController
@RequestMapping(path = "/Usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioImplement")
	private UsuarioImplement usuarioImplement;


	@RequestMapping(method = RequestMethod.GET,
			path = "/agregarUsuario",
			produces = "application/json",
			consumes = "application/json")
	public Usuario agregarUsuario(@RequestBody UsuarioRequest usuarioRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {

		final String jwtToken = request.getHeader("Authorization");

		Util util = new Util();
		Usuario nuevoOsuario;

		if( !util.validaEmail(usuarioRequest.getEmail()) ) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato eMail invalido");
			return null;
		}

		if( !util.validaPassword((usuarioRequest.getPassword() )) ) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato password invalido");
			return null;
		}

		if ( usuarioImplement.existByEmail(usuarioRequest.getEmail()) ) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "eMail ya registrado");
			return null;
		}

		try {
			Usuario objUsuario = util.mapUsuarioRequestToUsuario(usuarioRequest, jwtToken);
	
			nuevoOsuario = usuarioImplement.Create(objUsuario);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ERROR en servidor");
			return null;
		}

		response.setStatus(HttpServletResponse.SC_OK);
		return nuevoOsuario;


	}

}

























