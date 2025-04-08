package servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import excepciones.CampoVacioException;
import excepciones.FechaException;
import interfaces.IHospital;
import modelo.Paciente;
import repositorio.HospitalRepositorio;

public class HospitalServicio implements IHospital{



	@Override
	public List<Paciente> obtenerTodos() {
		HospitalRepositorio hospitalRepositorio = new HospitalRepositorio();
		List <Paciente> pacientes = hospitalRepositorio.cargarPacientes();
		return pacientes;
	}

	@Override
	public Paciente agregarPaciente(String dni, String nombre, String apellidos, String fechaNacimiento) throws CampoVacioException, FechaException, FileNotFoundException, IOException {
		
		Paciente paciente = new Paciente(dni, nombre, apellidos, fechaNacimiento, "ta mal", fechaNacimiento, true);	
		HospitalRepositorio hr = new HospitalRepositorio();
		hr.agregarPaciente(paciente);
		
		return null;
	}

	@Override
	public Paciente borrarPaciente(int puntero) throws FileNotFoundException, IOException {
		
		HospitalRepositorio hs = new HospitalRepositorio();
		List<Paciente> pacientes = hs.cargarPacientes();
		pacientes.remove(puntero);
		hs.guardarPacientes();
		
		return null;
	}

}
