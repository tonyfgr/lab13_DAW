package com.miempresa.modelo;
import java.sql.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name="Tarea")
public class Tarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="realizado")
	private boolean realizado;
	public Tarea() {
	}
	public int getId() {
	return id;
	}
	public String getDescripcion() {
	return descripcion;
	}
	public Date getFecha() {
	return fecha;
	}
	public boolean isRealizado() {
	return realizado;
	}
	public void setId(int id) {
		this.id = id;
		}
		public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		}
		public void setFecha(Date fecha) {
		this.fecha = fecha;
		}
		public void setRealizado(boolean realizado) {
		this.realizado = realizado;
		}
}

