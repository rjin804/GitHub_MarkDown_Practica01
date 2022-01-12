/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */


import java.awt.*;

import javax.swing.*;


/**
 * The Class PanelTitulo.
 */
public class PanelTitulo extends JPanel {
	
	/** The empresa. */
	private JLabel empresa;
	
	/**
	 * Instantiates a new panel titulo.
	 */
	public PanelTitulo() {
		
		setLayout(new BorderLayout());
		
		empresa = new JLabel("Nombre de la empresa");
		setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		empresa.setFont(new Font("Cascadia Code",Font.BOLD,60));
		add(empresa);
		setBackground(Color.YELLOW);
		
	}

}
