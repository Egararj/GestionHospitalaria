package repositorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.CampoVacioException;
import excepciones.DniException;
import modelo.Paciente;

public class HospitalRepositorio {
	
	private static final String ARCHIVO_PACIENTES = "PACIENTES";
	List<Paciente> pacientes;
	public HospitalRepositorio() {
	}
	
	public List<Paciente> cargarPacientes () {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PACIENTES))){
			pacientes = (List<Paciente>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar pacientes");
		}
		
		return pacientes;
	}
	
	public void guardarPacientes() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PACIENTES"));
		oos.writeObject(pacientes);
		oos.close();
	}
	
	public void agregarPaciente(Paciente paciente) throws FileNotFoundException, IOException {
		
		cargarPacientes();
		pacientes.add(paciente);
		guardarPacientes();
		
	}


}
