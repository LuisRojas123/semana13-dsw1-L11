package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	
	@GetMapping(path="/api/ventas/{id}/formacion")
	public @ResponseBody List<Map<String, Object>> formacion2(@PathVariable Integer id){
		String sql1 = "SELECT ventadetalle.id as ID, producto.nombre as NOMBRE, producto.precio as PRECIO, ventadetalle.cantidad as CANTIDAD from ventadetalle join venta on ventadetalle.id_Venta = venta.id JOIN producto on ventadetalle.id_producto = producto.id where venta.id=?";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql1,id);
		return queryResult;
	}
	

}