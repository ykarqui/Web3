package ar.edu.iua.demo.negocio;

import java.util.List;

import ar.edu.iua.demo.model.Valor;

public interface IValorNegocio {
	
	public List<Valor> todos();
	
	public Valor uno(int id);
	
}
