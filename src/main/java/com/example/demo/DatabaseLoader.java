package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryP;
	private final VentaRepository repositoryV;
	private final VentadetalleRepository repositoryVD;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryP,
		 VentaRepository repositoryV,
		 VentadetalleRepository repositoryVD) {


		this.repositoryP = repositoryP;
		this.repositoryV = repositoryV;
		this.repositoryVD = repositoryVD;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		

		//Datos iniciales de las tabla Producto
 
		Producto pEjemProducto1 = new Producto("Producto Ejemplo 1",250);
		Producto pEjemProducto2 = new Producto("Producto Ejemplo 2",300);
		Producto pEjemProducto3 = new Producto("Producto Ejemplo 3",428);
		this.repositoryP.save(pEjemProducto1);
		this.repositoryP.save(pEjemProducto2);
		this.repositoryP.save(pEjemProducto3);
		this.repositoryP.save(new Producto("Producto Ejemplo 4",428));

		//Datos iniciales de las tabla Venta

		Venta pEjemVenta1 = new Venta(2250);
		Venta pEjemVenta2 = new Venta(2312);
		this.repositoryV.save(pEjemVenta1);
		this.repositoryV.save(pEjemVenta2);


		//Datos iniciales de las tabla Detalle de Venta

		//PRIMER DETALLE DE VENTAS
		Ventadetalle pEjemVentaDetalle1 = new Ventadetalle(pEjemVenta1,pEjemProducto1,3);
		Ventadetalle pEjemVentaDetalle2 = new Ventadetalle(pEjemVenta1,pEjemProducto2,5);
		this.repositoryVD.save(pEjemVentaDetalle1);
		this.repositoryVD.save(pEjemVentaDetalle2);

		//SEGUNDO DETALLE DE VENTAS

		Ventadetalle pEjemVentaDetalle3 = new Ventadetalle(pEjemVenta2,pEjemProducto2,2);
		Ventadetalle pEjemVentaDetalle4 = new Ventadetalle(pEjemVenta2,pEjemProducto3,4);
		this.repositoryVD.save(pEjemVentaDetalle3);
		this.repositoryVD.save(pEjemVentaDetalle4);


	}

	
}