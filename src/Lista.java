
public class Lista {
	Nodo lista;
	private int cantDatos;
	
	public Lista() {
		lista = null;
		cantDatos = 0;
	}
	
	public Nodo primero() {
			return lista;
	}
	
	//AGREGAR AL PRINCIPIO
	public void agregar(String dato) {
		Nodo nuevo = new Nodo(dato, null);
		if (lista == null) 
			lista = nuevo;
		else if(lista != null) {
				nuevo.setNext(lista);
				lista = nuevo;
		  }
		cantDatos++;
	}
	
	public boolean esVacia() {
		return lista == null;
	}
	
	public int cantElementos() {
		return cantDatos;
	}
	
	public void eliminar(String dato) {
		Nodo pos = lista;
		if(lista != null){
			if(dato == lista.getDato()) {
				lista = lista.getNext();
				cantDatos--;
			}
			else { while((pos.getNext() != null)&&(!dato.equals(pos.getNext().getDato())))
						pos = lista.getNext();
				   if(dato == pos.getNext().getDato()){
					   pos.setNext(pos.getNext().getNext());
					   cantDatos--;
				   }
			}
		}
	}
	
	//Retorna TRUE si existe un determinado elemento
	public boolean existeElem(String dato) {
		Nodo cursor = lista;
		while(cursor != null) {
			if(dato.equals(cursor.getDato()))
				return true;
			cursor = cursor.getNext();
		}
		return false;
	}
	
	public void imprimir() {
		Nodo cursor = lista;
		while (cursor != null) {
			System.out.println(cursor.getDato());
			cursor = cursor.getNext();
		}
	}
}