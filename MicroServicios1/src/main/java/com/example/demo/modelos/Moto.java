package com.example.demo.modelos;

public class Moto {

	private String marca;
	
	private String modelo;
	
	private int usuarioId;
	

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public Moto(String marca, String modelo, int usuarioId) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Moto(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Moto() {
		super();
	}
	
}
