
public class Nodo {
	private String dato;
	private TipoNodo tipo;
	private Nodo siguiente;
	
	
	public Nodo() {
		this.siguiente = null;
	}
	
	public Nodo(String dato, TipoNodo tipo, Nodo siguiente) {
		this.dato = dato;
		this.tipo = tipo;
		this.siguiente = siguiente;
	}
	
	public void set_info(String dato) {
		this.dato = dato;
	}
	
	public TipoNodo tipoDato() {
		return tipo;
	}
	
	public void set_siguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public String get_info() {
		return this.dato;
	}
	
	public Nodo get_next() {
		return siguiente;
	}
	
	public void eliminar() {
		this.siguiente = null;
	}
}
