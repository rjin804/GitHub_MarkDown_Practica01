/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */



import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/** The contenedor. */
	//private Dialogo dialogo;
	private Container contenedor;
	
	/** The mi barra. */
	private JMenuBar miBarra;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** The acerca. */
	private JMenuItem salir, altoPiso, bajoPiso,acerca;
	
	/** The bajo P. */
	private JButton altoP,bajoP;
	
	/** The eliminar. */
	private ImageIcon agregar, eliminar;
	
	/** The mi ventana principal. */
	private VentanaPrincipal miVentanaPrincipal;
	
	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {
		
		super("Gestión Apartamentos Turísticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		Dimension tamano=miPantalla.getScreenSize();
		int alto = tamano.height;
		int ancho =tamano.width;
		setSize(ancho/2,alto/2);
		setLocation(ancho/4,alto/4);
		
		iniciar();
		/*JPanel contentPane = new JPanel();
		 
        //Indicamos el diseño usado
        contentPane.setLayout(null);
		setContentPane(contentPane);*/
		contenedor=getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		agregar = new ImageIcon(getClass().getResource("recursos/agregar.png"));
		altoP = new JButton ("Alta Pisos",agregar);
		altoP.setMnemonic(KeyEvent.VK_A);
		altoP.addActionListener(this);
		contenedor.add(altoP);
		
		
		eliminar= new ImageIcon(getClass().getResource("recursos/eliminar.png"));
		bajoP = new JButton ("Baja Pisos",eliminar);
		bajoP.setMnemonic(KeyEvent.VK_B);
		bajoP.addActionListener(this);
		contenedor.add(bajoP);
		
		
		setVisible(true);
		
	}
	
	/**
	 * Sets the ventana principal.
	 *
	 * @param miVentana the new ventana principal
	 */
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		miVentanaPrincipal=miVentana;
	}

	/**
	 * Iniciar.
	 */
	private void iniciar() {
		
		miBarra = new JMenuBar();
		
		archivo = new JMenu("Archivo");
		salir = new JMenuItem("Salir");
		archivo.add(salir);
		miBarra.add(archivo);
		
		registro = new JMenu ("Registro");
		registro.setMnemonic(KeyEvent.VK_R);
		altoPiso = new JMenuItem("Alto Piso");
		altoPiso.addActionListener(this);
		bajoPiso = new JMenuItem("Bajo Piso");
		bajoPiso.addActionListener(this);
		registro.add(altoPiso);
		registro.add(bajoPiso);
		miBarra.add(registro);
		
		ayuda = new JMenu("Ayuda");
		acerca = new JMenuItem("Acerca de...");
		acerca.addActionListener(this);
		ayuda.add(acerca);
		miBarra.add(ayuda);
		
		
		
		setJMenuBar(miBarra);
		
		
		
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==acerca) {
			JOptionPane.showMessageDialog(null, "Mensaje INFORMATION_MESSAGE", "INFORMACIÓN BASICA DE LA APLICACIÓN",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==altoP || e.getSource()==altoPiso) {
			//frame = new Frame();
			Dialogo dialogo = new Dialogo(this, true);
			dialogo.setVisible(true);
			
		}
		
		if( e.getSource()==bajoP || e.getSource()==bajoPiso) {
			JOptionPane.showMessageDialog(null, "Aun no se ha desarrollada esta opción", "INFORMACIÓN",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
