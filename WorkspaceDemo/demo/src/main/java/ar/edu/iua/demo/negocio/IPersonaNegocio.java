package ar.edu.iua.demo.negocio;

import java.util.List;

import ar.edu.iua.demo.model.Persona;

public interface IPersonaNegocio {
	
	public List<Persona> todos();
	
	public Persona uno(int id);
}
