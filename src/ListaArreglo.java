public class ListaArreglo {
	
	//CLASE PRIVADA DE LISTA ARREGLO
	private class Vertice {
		String dato;
		Lista adyacentes;
		
		private Vertice(String dato) {
			this.dato = dato;
			this.adyacentes = new Lista();
		}
		
		private void addAdyacente(String dato) {
			this.adyacentes.agregar(dato);
		}
		
		//DADA UNA LISTA RETORNA LA CANTIDAD DE VERTICES QUE TIENEN EN COMUN
		private int cantAdyEnComun(Lista ady2) {
			int cant = 0;
			Nodo cursor = this.adyacentes.primero();
			String vert;
			while(cursor != null) {
				vert = cursor.getDato();
				if(ady2.existeElem(vert))
					cant++;
				cursor = cursor.getNext();
			}
			return cant;
		}
		
		private int cantAdyacentes() {
			return this.adyacentes.cantElementos();
		}
		
		private String getDato() {
			return this.dato;
		}
		
		private Lista getAdyacentes() {
			return this.adyacentes;
		}
	}
	Vertice arr[];
	int cantidad;

	public ListaArreglo(){
		arr = new Vertice[100];
		cantidad = 0;
	}
	
	public boolean estaVacia(){
		return cantidad == 0;
	}
	
	//DADO UN VERTICE RETORNA UNA LISTA CON TODOS LOS VERTICES QUE TIENEN MAS DE UN VERTICE EN COMUN CON EL.
	public Lista vertCantAdyEnComun(String v) {
		Lista vertices = new Lista();
		if(existe(v)) {
			int posV = buscarDato(v);
			Lista adyV2;
			for(int i = 0; i < cantidad; i++) {
				if(!this.arr[i].getDato().equals(v)) {
					String v2 = this.arr[i].getDato();
					adyV2 = getAdyVert(v2);
					int cont = this.arr[posV].cantAdyEnComun(adyV2);
					if(cont > 1) {
						vertices.agregar(v2);
					}
				}
			}
		}	
		return vertices;
	}
	
	//RETORNA UNA LISTA CON TODOS LOS ADYACENTES DE UN DETERMINADO VERTICE
	public Lista getAdyVert(String v) {
		Lista ady = new Lista();
		if(existe(v)) {
			int posId = buscarDato(v);
			ady = this.arr[posId].getAdyacentes();
		}
		return ady;
	}
	
	public boolean existe(String dato) {
		if(!estaVacia()) {
			for (int i = 0; i < cantidad; i++) {
				if(arr[i].getDato().equals(dato)) {                
					return true;
				}
			}
		}
		return false;
	}
	
	public int getCantidad(){
		return cantidad;
	}

	public Vertice getElemento(int pos){
		if(pos < cantidad){
			return arr[pos];
		}
		return null;
	}
	
	//RETORNA EL VERTICE QUE POSEE MAS ADYACENTES
	public String mayoresAdyacentes() {
		int mayor = 0;
		String vertice = arr[0].getDato();
		mayor = arr[0].cantAdyacentes();
		for(int i = 0; i < cantidad; i++) {
			if(mayor < arr[i].cantAdyacentes()) {
				mayor = arr[i].cantAdyacentes();
				vertice = arr[i].getDato();
			}	
		}
		return vertice;
	}
	
	//RETORNA LA POSICION EN LA QUE SE ENCUENTRA EL VERTICE
	public int buscarDato(String v) {
		if(existe(v)) {
			for(int i = 0; i < cantidad; i++) {
				if(this.arr[i].getDato().equals(v))
					return i;
			}	
		}
		return -1;
	}
	
	public void addArco(String v, String dato) {
		if(existe(v)){
			int pos = buscarDato(v);
			arr[pos].addAdyacente(dato);
		}	
	}	
		
	public void agregar(String dato){
		
		if(!hayEspacio()){
			incrementarEspacio();
		}
		Vertice v = new Vertice(dato);
		arr[cantidad] = v;
		cantidad++;
	}
	
	private boolean hayEspacio(){
		return arr[arr.length-1] == null;
	}
	
	private void incrementarEspacio(){
		Vertice nuevoArreglo[] = new Vertice[cantidad*2];
		for (int i = 0; i < cantidad; i++) {
			nuevoArreglo[i] = arr[i];
		}
		arr = nuevoArreglo;	
	}
	
	public void imprimir(){
		for (int i = 0; i < cantidad; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void eliminarTodo(){
		arr = new Vertice[10];
		cantidad = 0;
	}
}
