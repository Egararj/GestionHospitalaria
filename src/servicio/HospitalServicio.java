package servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
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
		
		String ultimaConsulta = LocalDate.now().toString();
		Paciente paciente = new Paciente(dni, nombre, apellidos, fechaNacimiento, "ta mal", ultimaConsulta, true);	
		HospitalRepositorio hr = new HospitalRepositorio();
		hr.agregarPaciente(paciente);
		
		return null;
	}

	@Override
	public Paciente borrarPaciente(int puntero) throws FileNotFoundException, IOException {
		
		HospitalRepositorio hr = new HospitalRepositorio();
		List<Paciente> pacientes = hr.cargarPacientes();
		pacientes.remove(puntero);
		hr.guardarPacientes();
		
		return null;
	}

}
