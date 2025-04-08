package utilidades;

public class CompruebaDni {
	
	public static boolean compruebaDni(String dni) {
		boolean correcto = true;
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		try {
			if(dni.length() != 9) {
				return correcto = false;
			}
			int numerosDni = Integer.parseInt(dni.substring(0, 8));
			int resto = numerosDni % 23;
			String letraDni = dni.substring(8,9);
			String letras2 = letras.substring(resto,resto+1);
			if(!letraDni.equals(letras2)) {
				return correcto =false;
			}
			
		}catch (Exception e){
			return correcto = false;
		}
		
		return correcto;
	}

}