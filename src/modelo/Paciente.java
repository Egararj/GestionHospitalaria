package modelo;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.DniException;
import utilidades.CompruebaDni;

public class Paciente {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String diagnostico;
	private LocalDate ultimaConsulta;
	private boolean enTratamiento;
	
	public Paciente(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String diagnostico, boolean enTratamiento) throws CampoVacioException, DniException {
		super();
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaNacimiento(fechaNacimiento);
		this.setDiagnostico(diagnostico);
		this.setEnTratamiento(enTratamiento);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws CampoVacioException, DniException {
		if(dni.length() == 0) throw new CampoVacioException();
		
		boolean correcto = CompruebaDni.compruebaDni(dni);
		
		if(!correcto) throw new DniException();
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CampoVacioException {
		if(nombre.length() == 0) throw new CampoVacioException();

		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) throws CampoVacioException {
		if(apellidos.length() == 0) throw new CampoVacioException();

		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws CampoVacioException {
		if(fechaNacimiento == null) throw new CampoVacioException();

		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) throws CampoVacioException {
		if(diagnostico.length() == 0) throw new CampoVacioException();

		this.diagnostico = diagnostico;
	}

	public LocalDate getUltimaConsulta() {
		return ultimaConsulta;
	}

	public void setUltimaConsulta(LocalDate ultimaConsulta) {
		this.ultimaConsulta = ultimaConsulta;
	}

	public boolean isEnTratamiento() {
		return enTratamiento;
	}

	public void setEnTratamiento(boolean enTratamiento) {
		enTratamiento = true;
		this.enTratamiento = enTratamiento;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", diagnostico=" + diagnostico + ", ultimaConsulta=" + ultimaConsulta
				+ ", enTratamiento=" + enTratamiento + "]";
	}
	
	
	
}