import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CentroDeOperaciones {
	GrafoND grafo;
	
	public CentroDeOperaciones() {
		grafo = new GrafoND();
	}
	// Carga los usuarios en los cuales se va a trabajar
/*		public void precarga(String ruta) {
			String csvFile = ruta;
			String line = "";
			String cvsSplitBy = ";";
			String[] items = null;

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				String id;
				
				br.readLine(); //PARA EVITAR TOMAR LA PRIMER LINEA DEL ARCHIVO

				while ((line = br.readLine()) != null ) {

					items = line.split(cvsSplitBy);
					id = items[0];                 
					grafo.addUsuario(id);
					for (int i = 1; i < items.length; i++) {
						grafo.addGusto(items[i]);
						grafo.addArco(items[i], id);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {

			CentroDeOperaciones centro = new CentroDeOperaciones();

			//centro.precarga("C:/Users/Eloy/Desktop/datasets/dataset_3000000.csv");
			
			//centro.precarga("C:/Users/Euyi/Desktop/datasets/dataset_1000000.csv");
			
			centro.precarga("C:/Users/Euyi/Desktop/datasets/dataset_500000.csv");
			
			/*ListaArreglo usuarios = new ListaArreglo();
			

			
			for (int i = 0; i < 100; i++) {
				Usuario u = new Usuario(i); 
				usuarios.agregar(u);
			}
			//usuarios.imprimir();
			for (int i = 101; i < 200; i++) {
				System.out.println(usuarios.busquedaDyC(i)+"numero"+i);
			} 
		}*/


	
	public static void main(String[] args) {
		GrafoND g = new GrafoND();
		g.addUsuario("21");
		g.addGusto("futbol");
		g.addUsuario("54");
		g.addGusto("tenis");
		g.addUsuario("67");
		g.addGusto("golf");
		g.addUsuario("65");
		g.addGusto("handball");
		g.addUsuario("55");
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
		//Lista l = g.idConGustosEnComun("55");
		//l.imprimir();
		System.out.println(g.idConGustosMasLejanos("54"));
		//System.out.println(g.dist("54", "65"));
	}
}
