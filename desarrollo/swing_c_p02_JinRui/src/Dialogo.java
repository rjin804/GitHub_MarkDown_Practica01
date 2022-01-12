/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.*;



/**
 * The Class Dialogo.
 */
public class Dialogo extends JDialog implements ActionListener{
	
	/** The p 1. */
	private PanelTitulo p1;
	
	/** The p 2. */
	private PanelArrendador p2;
	
	/** The p 3. */
	private PanelInmueble p3;
	
	/** The p 4. */
	private JPanel p4;
	
	/** The pt. */
	private JTabbedPane pt;
	
	/** The guardar. */
	private JButton imprimir, nuevo, guardar;
	
	/** The gua. */
	private ImageIcon imp,nue,gua;
	
	/**
	 * Instantiates a new dialogo.
	 *
	 * @param miVentanaPrincipal the mi ventana principal
	 * @param modal              the modal
	 */
	public Dialogo(VentanaPrincipal miVentanaPrincipal, boolean modal){
		
		super(miVentanaPrincipal, modal);
		//getContentPane().setLayout(new BorderLayout());
		iniciaComponentes();
   		//Asigna un titulo a la barra de titulo
		setTitle("Ventana JPanel");
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		//obtenemos la resolusion de pantalla
		Dimension tamano=miPantalla.getScreenSize();
		//devuelva el ancho y alto de nuestra pantalla
		int alto = tamano.height;
		int ancho =tamano.width;
		//tamaño de la ventana
		setSize(ancho,alto);
		
		
		
	}

	/**
	 * Inicia componentes.
	 */
	public void iniciaComponentes() {
		
		p1 = new PanelTitulo();
		add(p1,BorderLayout.NORTH);
		
		p2 = new PanelArrendador();
		add(p2,BorderLayout.WEST);
		
		p3= new PanelInmueble();
		add(p3,BorderLayout.CENTER);
		
		pt=new JTabbedPane();
		pt.addTab("Datos personal",PanelArrendador.DatosPersonal());
		pt.addTab("Datos Hotel", PanelInmueble.DatosHotel());
		add(pt,BorderLayout.EAST);
		pt.setVisible(false);
		
		p4=new JPanel();
		imp = new ImageIcon(getClass().getResource("recursos/imprimir.png"));
		imprimir = new JButton("Imprimir",imp);
		imprimir.addActionListener(this);
		p4.add(imprimir);
		
		nue = new ImageIcon(getClass().getResource("recursos/nuevo.png"));
		nuevo = new JButton("Nuevo", nue);
		nuevo.addActionListener(this);
		p4.add(nuevo);
		
		gua=new ImageIcon(getClass().getResource("recursos/guardar.png"));
		guardar = new JButton("Guardar", nue);
		guardar.addActionListener(this);
		p4.add(guardar);
		p4.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
		add(p4,BorderLayout.SOUTH);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imprimir) {
			pt.setVisible(true);
		}else {
			pt.setVisible(false);
		}
		if(e.getSource()==guardar) {
			PanelArrendador.Inf();
		}
		if(e.getSource()==nuevo) {
			PanelArrendador.Limpiar();
		}
		
	}
	
}
