package edu.dws.gestionPortatilesWeb.aplicacion.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "usuario", schema= "dlk_lg_rgs_auth")
public class Usuario {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario", unique=true, nullable=false)
	private Integer id;
	@Column(name="username",nullable=false)
    private String username;
	@Column(name="email",nullable=false)
    private String email;
	@Column(name="password",nullable=false)
    private String password;
	@Column(name="role",nullable=false)
    private Integer role;

	
	//Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
}
