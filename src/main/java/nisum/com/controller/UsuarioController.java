package nisum.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nisum.com.dto.UsuarioResponse;
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
	public UsuarioResponse agregarUsuario(@RequestBody UsuarioRequest usuarioRequest, HttpServletRequest request) throws Exception {

		final String jwtToken = request.getHeader("Authorization");

		String stringUsuario;
		UsuarioResponse response = null;
		Util util = new Util();

		if( !util.validaEmail(usuarioRequest.getEmail()) )
			return response  = new UsuarioResponse( "{ \"mensaje\" : \"Formato eMail invalido\" }", 400 );

		if( !util.validaPassword((usuarioRequest.getPassword() )) )
			return response  = new UsuarioResponse( "{ \"mensaje\" : \"Formato password invalido\" }", 400 );

		if ( usuarioImplement.existByEmail(usuarioRequest.getEmail()) )
			return response  = new UsuarioResponse( "{ \"mensaje\" : \"eMail ya registrado}", 400 );

		try {
			Usuario objUsuario = util.mapUsuarioRequestToUsuario(usuarioRequest, jwtToken);
	
			Usuario nuevoOsuario = usuarioImplement.Create(objUsuario);
			System.out.println(nuevoOsuario);
			stringUsuario = util.usuarioToStringJson( nuevoOsuario );
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response  = new UsuarioResponse( "{ \"mensaje\" : \"ERROR en servidor}", 500 );
		}
		response = new UsuarioResponse(stringUsuario, 200 );
		return response;

	}

}

























