package nisum.com.dto;

import java.util.List;

public class UsuarioRequest {

	private String name;
	private String email;
	private String password;
	private List<PhoneDto> phones;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}


	@Override
	public String toString() {
		return "UsuarioDto [name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + "]";
	}


}