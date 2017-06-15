
public class CentroDeOperaciones {
	public static void main(String[] args) {
		GrafoND g = new GrafoND();
		g.addDni("21");
		g.addGusto("futbol");
		g.addDni("54");
		g.addGusto("tenis");
		g.addDni("67");
		g.addGusto("golf");
		g.addDni("65");
		g.addGusto("handball");
		g.addDni("55");
		g.addGusto("equitacion");
		
		g.addArco("futbol", "21");
		g.addArco("futbol", "67");
		g.addArco("futbol", "55");
		g.addArco("futbol", "54");
		
		g.addArco("tenis", "21");
		g.addArco("tenis", "67");
		g.addArco("tenis", "55");
		
		g.addArco("golf", "55");
		g.addArco("golf", "67");
		
		g.addArco("equitacion", "65");
		g.addArco("equitacion", "67");
		
		g.addArco("handball", "65");
		g.addArco("handball", "55");
		
		//System.out.println(g.gustoMasRecurrente());
		Lista l = g.idConGustosEnComun("55");
		l.imprimir();
	}
}
