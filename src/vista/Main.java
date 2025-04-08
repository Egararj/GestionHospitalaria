package vista;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.DniException;
import excepciones.FechaException;
import modelo.Paciente;
import vista.swing.FrmHospital;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		/*LocalDate fechaPrueba = LocalDate.of(2000,4,5);
		try {
			Paciente paciente = new Paciente("21150568K", "pepe", "al paca", fechaPrueba, "ta mal", true);
		} catch (CampoVacioException | DniException e) {
			System.out.println(e.getMessage());
		}*/

		FrmHospital frmHospital = new FrmHospital();
		
		
	}

}
