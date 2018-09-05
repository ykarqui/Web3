package ar.edu.iua.demo.negocio.harcodeado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.iua.demo.model.Persona;

@Component
public class PersonaNegocio implements ar.edu.iua.demo.negocio.IPersonaNegocio{
	private static List<Persona> lista = null;
	
	@Override
	public List<Persona> todos() {
		if(lista == null) {
			lista = new ArrayList<>();
			for(int t=0; t<100; t++) {
				lista.add(new Persona(t, "Persona", "Generada "+t));
			}
		}
		
		return lista;
	}

	@Override
	public Persona uno(int id) {
		List<Persona> l = todos();
		for (Persona persona : l) {
			if(persona.getDni()==id) {
				return persona;
			}
		}
		return null;
	}
}
