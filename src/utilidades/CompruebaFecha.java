package utilidades;

import java.time.LocalDate;

import excepciones.FechaException;

public class CompruebaFecha {

		public static LocalDate compruebaFecha(String fecha) throws FechaException {
			LocalDate fechaNacimiento;
			try {
			fechaNacimiento = LocalDate.parse(fecha);
			}catch(Exception e) {
				throw new FechaException();
			}
			
			return fechaNacimiento;
		}
}