package com.ejemplo.proyectofinal.app.model;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private int cantEjemplares;
	private String genero;


	public Libro(int id, String titulo, String autor, int cantEjemplares, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.cantEjemplares = cantEjemplares;
		this.genero = genero;
	}


	public int getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public int getCantEjemplares() {
		return cantEjemplares;
	}


	public String getGenero() {
		return genero;
	}




	
}
