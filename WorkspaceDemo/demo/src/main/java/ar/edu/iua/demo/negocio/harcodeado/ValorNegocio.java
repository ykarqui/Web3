package ar.edu.iua.demo.negocio.harcodeado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.iua.demo.model.Valor;

@Component
public class ValorNegocio implements ar.edu.iua.demo.negocio.IValorNegocio {

	private static List<Valor> lista = null;
	
	@Override
	public List<Valor> todos() {
		if(lista == null) {
			lista = new ArrayList<>();
			for(int t=0; t<100; t++) {
				lista.add(new Valor(t, "Valor "+t));
			}
		}
		
		return lista;
	}

	@Override
	public Valor uno(int id) {
		List<Valor> l = todos();
		for (Valor valor : l) {
			if(valor.getId()==id) {
				return valor;
			}
		}
		return null;
	}

}
