package edu.dws.gestionPortatilesWeb.aplicacion.dto;

public class RegistroDTO {

	private Integer id;
	private String username;
    private String email;
    private String password;
    private String password2;
    private Integer role=1;
    
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	
	public RegistroDTO(String username, String email, String password, String password2, Integer role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.role = 1;
	}
	
	public RegistroDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "UsuarioDTO [username=" + username + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", id=" + id + "]";
	}
	
	
	
	
}
