package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
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
		Hotel h1 = new Hotel();
		h1.setDireccion("La marin");
		h1.setNombre("BuenaVista");
		
		Habitacion hab1 = new Habitacion();
		hab1.setNumero("1");
		hab1.setValor(new BigDecimal(11));
		
		Habitacion hab2 = new Habitacion();
		hab2.setNumero("2");
		hab2.setValor(new BigDecimal(10));
		
		List <Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(hab1);
		habitaciones.add(hab2);
		
		h1.setHabitaciones(habitaciones);
		hab1.setHotel(h1);
		hab2.setHotel(h1);
		
		this.hotelService.guardar(h1);
		//this.habitacionService.guardar(hab2);
		//this.habitacionService.guardar(hab1);
		
		h1.setNombre("MalaVista");
		h1.setDireccion("Villaflora");
		this.hotelService.actualizar(h1);
		
		this.hotelService.buscarPorID(1);
		//this.habitacionService.buscarPorID(2);
		//this.habitacionService.buscarPorID(1);
		this.hotelService.borrar(1);
		//this.habitacionService.borrar(2);
		
	}

}
