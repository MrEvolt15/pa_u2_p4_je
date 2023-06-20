package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private CiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Libro l1 = new Libro();
		l1.setEditorial("Alhambra");
		l1.setTitulo("Luna de PLuton");
		
		Libro l2 = new Libro();
		l2.setEditorial("BuscadoresTM");
		l2.setTitulo("NO se que poner");
		
		Autor a1 = new Autor();
		a1.setApellido("Espinosa");
		a1.setNombre("Joel");

		Autor a2 = new Autor();
		a2.setApellido("Soria");
		a2.setNombre("Nelson");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(a2);
		autores.add(a1);
		
		Set<Libro> libros = new HashSet<>();
		libros.add(l2);
		libros.add(l1);
		
		l1.setAutores(autores);
		l2.setAutores(autores);
		a1.setLibros(libros);
		a2.setLibros(libros);
		
		this.autorService.guardar(a2);
		this.autorService.guardar(a1);
		
		//this.libroService.guardar(l2);
		//this.libroService.guardar(l1);
		
		a2.setApellido("Perez");
		a1.setNombre("Juan");
		this.autorService.actualizar(a1);
		this.autorService.actualizar(a2);
		
		this.autorService.buscarPorID(1);
		this.libroService.buscarPorID(2);
		
		this.autorService.borrar(2);
		this.libroService.borrar(1);
		
	}

}
