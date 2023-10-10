package com.example.demo.repository;
import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.*;

public class BaseDatos {
	
	ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public BaseDatos() {
		libros.add(new Libro(1, "HARRY POTTER Y EL PRISIONERO DE AZKABAN", "J.K ROWINS", "SALAMANDRA","26/9/2006 0:00:0", "INFANTIL"));
		libros.add(new Libro(2, "EL GRAN LABERINTO", "FERNANDO SABATER PÉREZ", "ARIEL", "26/9/2006 0:00:0", "FICCION"));
		libros.add(new Libro(3, "ROMEO Y JULIETA", "WILLIAM SHAKESPEARE", "SALAMANDRA", "26/9/2006 0:00:0", "ROMANTICA"));
		
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	public Libro getLibro(int id) {
		return null;
		
	}
	
	public void inserta(Libro libro) {
		libros.add(libro);
	}
	
	public void borrar(int id) {
		Iterator<Libro> it = libros.iterator();
		while(it.hasNext()) {
			Libro li = it.next();
			if (li.getId() == id) {
				it.remove();
				break;
			}
		}
	}
	
	public void modifica(Libro libro) {
		Iterator<Libro> it = libros.iterator();
		while(it.hasNext()) {
			Libro li = it.next();
			if(li.getId()==libro.getId()) {
				li.setTitulo(libro.getTitulo());
				li.setAutor(libro.getAutor());
				li.setEditorial(libro.getEditorial());
				li.setFecha(libro.getFecha());
				li.setTematica(libro.getTematica());
				break;
				
			}
		}
	}
}
