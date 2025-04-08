package utilidades;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.CampoVacioException;
import excepciones.DniException;
import modelo.Paciente;
import servicio.HospitalServicio;

public class GeneraPacientes {

		public void GeneraPacientes() throws CampoVacioException, DniException {
			List<Paciente> pacientes = new ArrayList<Paciente>();
			try(FileOutputStream fos = new FileOutputStream("PACIENTES"); ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				Paciente paciente = new Paciente("23456789D", "Carlos", "Gómez Ruiz", "2000-02-03", "Hipertensión", "2023-03-22", true);
		        pacientes.add(new Paciente("34567890V", "María", "Fernández Soto", "1992-11-30", "Asma", "2022-10-14", false));
		        pacientes.add(new Paciente("45678901G", "Javier", "Hernández Díaz", "1980-06-25", "Diabetes", "2023-12-05", true));
		        pacientes.add(new Paciente("56789012B", "Lucía", "Ramírez Peña", "1995-04-12", "Alergias", "2022-08-18", false));
		        pacientes.add(new Paciente("67890123B", "Diego", "Moreno Gil", "1988-09-19", "Bronquitis", "2024-01-20", true));
		        //pacientes.add(new Paciente("78901234X", "Elena", "Ortega Jiménez", "03/02/2000", "Ansiedad", "07/11/2023", false));
		       // pacientes.add(new Paciente("89012345E", "Sergio", "Navarro Cruz", "27/10/1993", "Migraña", "11/04/2024", true));
		        //pacientes.add(new Paciente("90123456A", "Natalia", "Iglesias Romero", "09/12/1997", "Fractura", "30/12/2023", false));
		       // pacientes.add(new Paciente("11223344B", "Pablo", "Castro Méndez", "06/01/1983", "Covid-19", "01/03/2024", true));
			       
			       oos.writeObject(pacientes);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}