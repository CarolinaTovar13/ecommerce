package org.generation.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Old Java Object

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private long id;
	@Column (nullable = false)
	private String nombre;
	private String descricion;
	private String imagen;
	private double precio;
	//private static long total = 0;

	
	public Producto(String nombre, String descricion, String imagen, double precio) {
		super();
		this.nombre = nombre;
		this.descricion = descricion;
		this.imagen = imagen;
		this.precio = precio;
		//total ++;
		//id=Producto.total;
		
	}//1. Constructor
	
	public Producto() {
		//total ++;
		//id=Producto.total;
	}//constructor default

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getDescricion() {
		return descricion;
	}//getDescricion

	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}//setDescricion

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	//2.getterandsetter

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descricion=" + descricion + ", imagen=" + imagen + ", precio=" + precio
				+ ", id=" + id + "]";

	
	
	}//3.toString
	
	
	
}//class
