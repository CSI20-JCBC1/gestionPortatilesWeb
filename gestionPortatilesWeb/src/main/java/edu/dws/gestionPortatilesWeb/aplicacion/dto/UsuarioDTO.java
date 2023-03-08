package edu.dws.gestionPortatilesWeb.aplicacion.dto;

public class UsuarioDTO {

	private Integer id;
	private String username;
    private String email;
    private String password;
    private Integer role;
    
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
	
	
	public UsuarioDTO(Integer id,String username, String email, String password, Integer role) {
		super();
		this.id=id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.id = id;
	}
	
	public UsuarioDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "UsuarioDTO [username=" + username + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", id=" + id + "]";
	}
	
	
	
	
}
