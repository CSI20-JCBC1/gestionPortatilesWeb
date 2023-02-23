package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import java.util.Calendar;
import java.util.UUID;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;

public class PortatilesDTO {
	
	private Integer id_ordenador;
	private String md_uuid = UUID.randomUUID().toString();
	private Calendar md_date=Calendar.getInstance();
	private String modelo;
	private String marca;

	Alumnos alumno;
	
	//Getters & Setters
	
	public Integer getId_ordenador() {
		return id_ordenador;
	}
	public void setId_ordenador(Integer id_ordenador) {
		this.id_ordenador = id_ordenador;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Alumnos getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}
	
	//Constructores
	public PortatilesDTO(String modelo, String marca) {
		super();
		this.md_uuid = UUID.randomUUID().toString();
		this.md_date = Calendar.getInstance();
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public PortatilesDTO() {
		super();
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "GestionOrdenadores [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime()
				+ ", modelo=" + modelo + ", marca=" + marca + ", alumno=" + alumno + "]";
	}
	


}
