

public class GrafoND {
	private ListaArreglo gustos;         //LISTA ARREGLO DE GUSTOS QUE POSEE UNA LISTA DE DNI
	private ListaArreglo idUsuarios;     //LISTA ARREGLO DE DNI QUE POSEE UNA LISTA DE GUSTOS
	private int clave;
	private int longitud;
	
	public GrafoND() {
		this.gustos = new ListaArreglo();
		this.idUsuarios = new ListaArreglo();
		this.clave = 1;
		this.longitud = 0;
	}
	
	private int getClave(String dato) {
		int c = 0;
		if(gustos.existe(dato)) {
			c = gustos.getClave(dato);
		}
		else if(idUsuarios.existe(dato)) {
				c = idUsuarios.getClave(dato);
		}
		return c;
	}
	
	private String extraerMinimo(Lista cola, int[] dist) {
		String menor;
		int menorCant;
		Nodo cursor = cola.primero();
		menor = cursor.getDato();
		int c = getClave(menor);
		menorCant = dist[c];
		while(cursor != null) {
			int clav = getClave(cursor.getDato());
			if(menorCant > dist[clav]) {
				menorCant = dist[clav];
				menor = cursor.getDato();
			}
			cursor = cursor.getNext();
		}
		return menor;
	}
	
	public String idConGustosMasLejanos(String id) {
		int[] distancias = Dijkstra(id);
		int mayor = distancias[0];
		int pos = 0;
		for (int i = 0; i < distancias.length; i++) {
			if(distancias[i]%2 == 0) {            //SON PARES LAS DISTANCIAS ENTRE USUARIOS
				if(mayor < distancias[i]) {
					mayor = distancias[i];
					pos = i;
				}
			}	
		}
		return this.idUsuarios.getDatoConClave(pos);
	}
	
	private int[] Dijkstra(String origen){
		Lista cola = new Lista();
		int[] dist = new int[longitud+1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}            
		if(idUsuarios.existe(origen)) {
			clave = idUsuarios.getClave(origen);
		}
		dist[clave] = 0;                    //DISTANCIA DEL ORIGEN
		while(!cola.esVacia()){
		    String min = extraerMinimo(cola,dist);      
			cola.eliminar(min);
			int claveMin = 0;
			Lista ady = new Lista();
			if(gustos.existe(min)) {
				claveMin = gustos.getClave(min);
				ady = gustos.getAdyVert(min);
			}
			else if(idUsuarios.existe(min)) {
					claveMin = idUsuarios.getClave(min);
					ady = idUsuarios.getAdyVert(min);
			} 
			Nodo cursor = ady.primero();
			while(cursor != null) {
				String dato = cursor.getDato();
				int c = getClave(dato);
				int distancia = dist[claveMin] + 1; //SE TOMA 1 POR TOMAR EL COSTO DEL GRAFO
				if(distancia < dist[c])
					dist[c] = distancia;
			}
		}
		return dist;
	}
	
	//RETORNA LA CANTIDAD DE VERTICES DEL GRAFO
	public int longitud() {
		return longitud;
	}
	
	public void addGusto(String gusto) {
		if(!gustos.existe(gusto)){
			this.gustos.agregar(gusto, clave);
			this.longitud++;
			this.clave++;
		}	
	}
	
	public void addUsuario(String id) {
		if(!idUsuarios.existe(id)){
			this.idUsuarios.agregar(id,clave);
			this.longitud++;
			this.clave++;
		}	
	}
	
	public boolean existeGusto(String gusto) {
		return this.gustos.existe(gusto);
	}
	
	public boolean existeUsuario(String usuario) {
		return this.gustos.existe(usuario);
	}
	
	public void addArco(String gusto, String id) {
		this.gustos.addArco(gusto, id);
		this.idUsuarios.addArco(id, gusto);
	}
	
	//DADO UN USUARIO RETORNA UNA LISTA CON TODAS LAS PERSONAS QUE TIENEN MAS DE UN GUSTO EN COMUN CON EL.
	public Lista idConGustosEnComun(String id) {
		return idUsuarios.vertCantAdyEnComun(id);
	}
	
	//RETORNA QUE GUSTO LE GUSTA A MAS CANTIDAD DE GENTE
	public String gustoMasRecurrente() {
		return this.gustos.mayoresAdyacentes();
	}
}
