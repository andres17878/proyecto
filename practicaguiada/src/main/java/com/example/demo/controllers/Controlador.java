package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.*;
import com.example.demo.repository.BaseDatos;


@Controller //Peticiones http
@RequestMapping("")
public class Controlador {
	
	BaseDatos bd = new BaseDatos();
	Usuario usuario;
	
	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}
	
	
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if(usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			ArrayList<Libro> libros = bd.getLibros();
			model.addAttribute("usuario", usuario);
			this.usuario = usuario;
			model.addAttribute("libros", libros);
			return "consulta";
		} else { 
			return "login";
		}	
		
	}
	
	@PostMapping("/insertar")
	public String insertar(Libro libro, Model model) {	
		bd.inserta(libro);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("libros", libros);
		return "consulta";
	}
	
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("libros", libros);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton", "Inserta Libro");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Libro libro = bd.getLibro(id);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("libros", libros);
		model.addAttribute("libro", libro);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton", "Actualiza Libro");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}
	
	@PostMapping("/modificar")
	public String modificar2(Libro libro, Model model) {
		bd.modifica(libro);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("libros", libros);
		model.addAttribute("libro", null);
		model.addAttribute("boton", "Inserta Libro");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
}
