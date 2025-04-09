package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import excepciones.CampoVacioException;
import excepciones.FechaException;
import modelo.Paciente;

public interface IHospital {

	List<Paciente> obtenerTodos();
	
	Paciente agregarPaciente(String dni, String nombre, String apellidos, String fechaNacimiento) throws CampoVacioException, FechaException, FileNotFoundException, IOException;
	
	Paciente borrarPaciente(int puntero) throws FileNotFoundException, IOException;
	
	Paciente editarPaciente(int puntero, boolean prestado) throws FileNotFoundException, IOException;
}
