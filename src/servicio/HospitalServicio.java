package servicio;

import java.util.List;

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

}
