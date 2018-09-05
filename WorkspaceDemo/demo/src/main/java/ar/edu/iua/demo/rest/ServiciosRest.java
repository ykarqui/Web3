package ar.edu.iua.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.demo.model.Persona;
import ar.edu.iua.demo.model.Valor;
import ar.edu.iua.demo.negocio.IPersonaNegocio;
import ar.edu.iua.demo.negocio.IValorNegocio;

@RestController
@RequestMapping("/api/v1")
public class ServiciosRest {
	
	@Autowired
	private IValorNegocio negocio;
	
	@RequestMapping(value="/valores", method=RequestMethod.GET)
	public List<Valor> listado(){
		return negocio.todos();
	}
	
	@RequestMapping(value="/valores/{id}", method=RequestMethod.GET)
	public ResponseEntity<Valor> uno(@PathVariable("id") int id){
		Valor v = negocio.uno(id);
		if(v != null) 
			return new ResponseEntity<Valor>(v,HttpStatus.OK);
		else 
			return new ResponseEntity<Valor>(HttpStatus.NOT_FOUND);
	}
	
	@Autowired
	private IPersonaNegocio personaNegocio;
	
	@RequestMapping(value="/personas", method=RequestMethod.GET)
	public List<Persona> listadoPersona(){
		return personaNegocio.todos();
	}
	
	@RequestMapping(value="/personas/{id}", method=RequestMethod.GET)
	public ResponseEntity<Persona> unoPersona(@PathVariable("id") int id){
		Persona p = personaNegocio.uno(id);
		if(p != null) 
			return new ResponseEntity<Persona>(p,HttpStatus.OK);
		else 
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
	}
	
}
