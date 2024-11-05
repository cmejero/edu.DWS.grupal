package dtos;

import jakarta.persistence.*;

@Entity
@Table(name = "club")

/**
 * Clase que se encarga para agrupar y transferir datos básicos del club
 */
public class ClubDtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_club;
	
	
	@Column
	String nombre_club = "aaaaa";

	@Column
	String nick_club = "aaaaa";
	
	@Column
	String email_club = "aaaaa";
	
	@Column
	
	String password_club = "aaaaa";

	public long getId_club() {
		return id_club;
	}

	public void setId_club(long id_club) {
		this.id_club = id_club;
	}

	public String getNombre_club() {
		return nombre_club;
	}

	public void setNombre_club(String nombre_club) {
		this.nombre_club = nombre_club;
	}

	public String getNick_club() {
		return nick_club;
	}

	public void setNick_club(String nick_club) {
		this.nick_club = nick_club;
	}

	public String getEmail_club() {
		return email_club;
	}

	public void setEmail_club(String email_club) {
		this.email_club = email_club;
	}

	public String getPassword_club() {
		return password_club;
	}

	public void setPassword_club(String password_club) {
		this.password_club = password_club;
	}
	
	
	
	
	
	
	
	
}
