
public class Nodo {
	private String dato;
	private Nodo siguiente;
	
	
	public Nodo() {
		this.siguiente = null;
	}
	
	public Nodo(String dato, Nodo siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}
	
	public void setNext(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public String getDato() {
		return this.dato;
	}
	
	public Nodo getNext() {
		return siguiente;
	}
	
	public void eliminar() {
		this.siguiente = null;
	}
}
