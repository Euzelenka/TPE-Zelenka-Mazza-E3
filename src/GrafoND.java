
public class GrafoND {
	private ListaArreglo gustos;         //LISTA ARREGLO DE GUSTOS QUE POSEE UNA LISTA DE DNI
	private ListaArreglo idUsuarios;            //LISTA ARREGLO DE DNI QUE POSEE UNA LISTA DE GUSTOS
	
	public GrafoND() {
		this.gustos = new ListaArreglo();
		this.idUsuarios = new ListaArreglo();
	}
	
	public void addGusto(String dato) {
		this.gustos.agregar(dato);
	}
	
	public void addDni(String dato) {
		this.idUsuarios.agregar(dato);
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
