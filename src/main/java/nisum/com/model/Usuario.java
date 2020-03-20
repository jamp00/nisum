package nisum.com.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
//@Table(name = "Phone", schema = "STORE")
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String usuarioId;
	private String name;
	private String email;
	private String password;

	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate created;
	@JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate modified;
	@JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate lastLogin;
    private String token;
    private boolean isactive;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="usuarioId")
	private List<Phone> phones;


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

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", created=" + created + ", modified=" + modified + ", lastLogin=" + lastLogin + ", token=" + token
				+ ", isactive=" + isactive + ", phones=" + phones + "]";
	}

}
