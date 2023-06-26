package com.example.demo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.RandomDateTimes;
import com.example.demo.service.ClienteService;
import com.example.demo.service.ProductoService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Instant hace365 = Instant.now().minus(Duration.ofDays(365));
		Instant now = Instant.now();
		
		Cliente cli1 = new Cliente();
		cli1.setCedula("1726333196");
		cli1.setNomCli("Joel");
		
		Producto prod1 = new Producto();
		prod1.setFecha(RandomDateTimes.between(hace365, now));
		prod1.setNombre("Paquete Caramelos 500 u");
		prod1.setPrecio(new BigDecimal(2.5));
		
		Producto prod2 = new Producto();
		prod2.setFecha(RandomDateTimes.between(hace365, now));
		prod2.setNombre("Ruflex Crema y Cebolla");
		prod2.setPrecio(new BigDecimal(0.45));
		
		Producto prod3 = new Producto();
		prod3.setFecha(RandomDateTimes.between(hace365, now));
		prod3.setNombre("Paquete Chupetes Star");
		prod3.setPrecio(new BigDecimal(2.5));
		
		Producto prod4 = new Producto();
		prod4.setFecha(RandomDateTimes.between(hace365, now));
		prod4.setNombre("Esponja de Baño");
		prod4.setPrecio(new BigDecimal(1.3));
		
		List<Producto> misProductos = new ArrayList<>();
		misProductos.add(prod4);
		misProductos.add(prod3);
		misProductos.add(prod2);
		misProductos.add(prod1);
		
		cli1.setProductos(misProductos);
		prod1.setCliente(cli1);
		prod2.setCliente(cli1);
		prod3.setCliente(cli1);
		prod4.setCliente(cli1);
		
		//this.clienteService.guardar(cli1);
		//this.productoService.guardar(prod4);
		Instant fecha1 = Instant.parse("2023-05-02 12:41:57-05");
		Instant fecha2 = Instant.parse("2022-11-03 12:23:53-05");
		
		this.productoService.buscarListaPorPrecio(new BigDecimal(2.5));
		this.productoService.buscarPorPrecio(new BigDecimal(0.45));
		this.productoService.buscarPorFecha(fecha1);
		this.productoService.buscarListaPorFecha(fecha2);
		
	}

}
