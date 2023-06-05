package com.moto.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moto.service.Servicio.MascotaService;
import com.moto.service.model.Mascota;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

	
	@Autowired
	private MascotaService mascotaService;
	
	
	@GetMapping
	public ResponseEntity<List<Mascota>> getAllMascotas(){
		
		List<Mascota> mascotas=mascotaService.obtenerMascotas();
		
		
		return ResponseEntity.ok(mascotas);
	}
	
	@PostMapping
	public ResponseEntity<Mascota> save(@RequestBody Mascota mascota ){
		
		Mascota mascotaN = mascotaService.crearMascotas(mascota);
		
		return ResponseEntity.ok(mascotaN);
	}
	
	
	
}
