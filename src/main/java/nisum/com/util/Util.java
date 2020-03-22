package nisum.com.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nisum.com.dto.PhoneDto;
import nisum.com.dto.UsuarioRequest;
import nisum.com.model.Phone;
import nisum.com.model.Usuario;

public class Util {

	public boolean validaEmail(String eMail) {

	    Pattern pattern = Pattern.compile("^([_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3}))$");

		boolean valido = false;
        Matcher mather = pattern.matcher(eMail);
        
        if (mather.find() == true)
        	valido = true;

        return valido;
	}

	public boolean validaPassword(String password) {

	    Pattern pattern = Pattern.compile("^([A-Z]{1}([a-z])+([0-9]){2})$");

		boolean valido = false;
        Matcher mather = pattern.matcher(password);
        
        if (mather.find() == true)
        	valido = true;

        return valido;
	}

	public Usuario mapUsuarioRequestToUsuario(UsuarioRequest usuarioDto, String token) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setToken(token);
		usuario.setCreated(LocalDate.now());
		usuario.setModified(null);
		usuario.setLastLogin(LocalDate.now());
		usuario.setIsactive(true);
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setName(usuarioDto.getName());
		usuario.setPassword(usuarioDto.getPassword());

		List<PhoneDto> phonesDto = usuarioDto.getPhones();
		List<Phone> listPhones = new ArrayList<Phone>();

		for (PhoneDto phoneDto : phonesDto){
			Phone phone = new Phone();
			phone.setNumber(phoneDto.getNumber());
			phone.setCitycode(phoneDto.getCitycode());
			phone.setContrycode(phoneDto.getContrycode());
			listPhones.add(phone);
		}

		usuario.setPhones(listPhones);

		return usuario;
	}





}
