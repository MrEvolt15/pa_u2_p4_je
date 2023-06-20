package com.example.demo;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
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
		
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Joel");
		ciu1.setApellido("Espinosa");
		ciu1.setCedula("1726333196");
		
		Empleado empl1 = new Empleado();
		empl1.setCargo("Barrendero");
		empl1.setSueldo(new BigDecimal(160));
		
		empl1.setCiudadano(ciu1);
		ciu1.setEmpleado(empl1);
		this.empleadoService.guardar(empl1);
		//this.ciudadanoService.guardar(ciu1);
		
		empl1.setCargo("Gerente");
		empl1.setSueldo(new BigDecimal(14000));
		this.empleadoService.actualizar(empl1);
		
		ciu1.setNombre("Juan");
		ciu1.setApellido("Salinas");
		//this.ciudadanoService.actualizar(ciu1);
		this.empleadoService.buscarPorID(1);
		this.empleadoService.borrar(1);
		
		//this.ciudadanoService.buscarPorID(1);
		//this.ciudadanoService.borrar(1);
		
	}

}
