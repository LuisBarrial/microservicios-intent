package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Carro;
import com.example.demo.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {

	
	@Autowired
	private CarroService carroService;
	
	
	@GetMapping
	public ResponseEntity<List<Carro>> listar(){
		List<Carro> carros= carroService.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscarId(@PathVariable("id") int id ){
		Carro carro = carroService.getCarroById(id);
		if(carro==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	} 
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro carroN = carroService.save(carro);
		return ResponseEntity.ok(carroN);
		
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Carro> carros = carroService.byUsuarioId(id);
		
		if(carros==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	
	
	
}
