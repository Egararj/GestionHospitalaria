package repositorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import modelo.Paciente;

public class HospitalRepositorio {
	
	private static final String ARCHIVO_PACIENTES = "datos.dat";
	List<Paciente> pacientes;
	public HospitalRepositorio() {
	}
	
	public List<Paciente> cargarPacientes () {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PACIENTES));
			pacientes = (List<Paciente>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar pacientes");
		}
		
		return pacientes;
	}
	
	public void guardarPacientes() throws FileNotFoundException, IOException {
		ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("datos.dat"));
		ois.writeObject(pacientes);
		ois.close();
	}

}
