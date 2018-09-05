package ar.edu.iua.demo.model;

public class Valor {
	private int id;
	public Valor(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
