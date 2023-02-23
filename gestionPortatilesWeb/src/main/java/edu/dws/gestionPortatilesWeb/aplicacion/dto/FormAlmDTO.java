package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import java.util.Calendar;
import java.util.UUID;

public class FormAlmDTO {

	private Integer id_alumno;
	private String md_uuid=UUID.randomUUID().toString();
	private Calendar md_date=Calendar.getInstance();
	private String nombre;
	private String apellidos;
	private String num_telefono;
	private Integer idPortatil;
	
	public Integer getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getMd_uuid() {
		return md_uuid;
	}
	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}
	public Calendar getMd_date() {
		return md_date;
	}
	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNum_telefono() {
		return num_telefono;
	}
	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}
	public Integer getIdPortatil() {
		return idPortatil;
	}
	public void setIdPortatil(Integer idPortatil) {
		this.idPortatil = idPortatil;
	}
	
	public FormAlmDTO(String md_uuid, Calendar md_date, String nombre, String apellidos, String num_telefono,
			Integer idPortatil) {
		super();
		this.md_uuid = md_uuid;
		this.md_date = md_date;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_telefono = num_telefono;
		this.idPortatil = idPortatil;
	}
	
	public FormAlmDTO() {
		super();
	}
	@Override
	public String toString() {
		return "InsertAlmDTO [id_alumno=" + id_alumno + ", md_uuid=" + md_uuid + ", md_date=" + md_date + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", num_telefono=" + num_telefono + ", idPortatil=" + idPortatil
				+ "]";
	}
	
	
	
}
