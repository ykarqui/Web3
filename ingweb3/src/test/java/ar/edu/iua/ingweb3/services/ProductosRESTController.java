package ar.edu.iua.ingweb3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.ingweb3.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductosRESTController {
	
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET, produces="application/json")
	public List<Producto> lista(){
		List<Producto> r = new ArrayList<>();
		r.add(new Producto(1, "Arroz", 41.50, true, new Date()));
		r.add(new Producto(2, "Leche", 35, true, new Date()));
		r.add(new Producto(3, "Cerveza", 49.50, true, null));
		
		return r;
	}
	
	@RequestMapping(value= {"/{id}"}, method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Producto> cargar(@PathVariable("id") int id){
		List<Producto> l = lista();
		Producto r=null;
		for(Producto p: l) {
			if(p.getId()==id) {
				r=p;
			}
					
		}
		
		if(r!=null) {
			return new ResponseEntity<Producto>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
