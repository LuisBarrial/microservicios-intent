package com.example.demo.usuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidades.Usuario;
import com.example.demo.feign.CarroFeignClient;
import com.example.demo.feign.MotofeignClient;
import com.example.demo.modelos.Carro;
import com.example.demo.modelos.Moto;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService{

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CarroFeignClient carroFeignClient;
	
	@Autowired
	private MotofeignClient motofeignClient;
	
	public List<Carro> getCarros(int usuarioId){
		List<Carro> carros = restTemplate.getForObject("http://MicroServicioCarro/carro/usuario/"+usuarioId,List.class);
		return carros;
	}
	public List<Moto> getMotos(int usuarioId){
		List<Moto> motos = restTemplate.getForObject("http://moto-service/moto/usuario/"+usuarioId,List.class);
		return motos;
	}
	
	public Carro saveCarro(int usuarioId,Carro carro){
		carro.setUsuarioId(usuarioId);
		Carro nuevoCarro = carroFeignClient.save(carro);
		return nuevoCarro;
	}
	
	
	public Moto saveMoto(int usuarioId,Moto moto) {
		moto.setUsuarioId(usuarioId);
		Moto nuevaMoto = motofeignClient.save(moto);
		return nuevaMoto;
		
	}
	
	public Map<String,Object> getUsuarioAndVehiculos(int usuarioId){
		Map<String,Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);
		
		if(usuario==null) {
			resultado.put("Mensaje", "resultado no existe");
		}
		
		resultado.put("Usuario", usuario);
		
		List<Carro> carros = carroFeignClient.getCarros(usuarioId);
		
		if(carros.isEmpty()) resultado.put("Carros", "El usuario no tiene carros");
		else {
		resultado.put("Carros", carros);}
		
		List<Moto> motos = motofeignClient.getMotos(usuarioId);
				
		if(motos.isEmpty()) resultado.put("Motos", "El usuario no tiene motos");
		else {
			resultado.put("Motos", motos);
		}
		return resultado;
		
	}
	
	
	public List<Usuario> getAll(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario getUsuarioById(int id){
		return usuarioRepositorio.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevoUser = usuarioRepositorio.save(usuario);
		return nuevoUser;
		
	}
	
	
}
