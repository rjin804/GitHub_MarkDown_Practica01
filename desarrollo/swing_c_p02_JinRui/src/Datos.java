/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */


import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The Interface Datos.
 */
public interface Datos {

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	static void setNombre(JTextField nombre) {
		nombre.setText("");
	}
	
	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	static void setApellido(JTextField apellido) {
		apellido.setText("");
	}
	
	/**
	 * Sets the dni.
	 *
	 * @param CampoDni the new dni
	 */
	static void setDni(JFormattedTextField CampoDni) {
		CampoDni.setText("");
	}
	
	/**
	 * Sets the telefono.
	 *
	 * @param tel the new telefono
	 */
	static void setTelefono (JFormattedTextField tel) {
		tel.setText("");
	}
	
}
