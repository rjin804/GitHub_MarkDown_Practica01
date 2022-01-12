/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


/**
 * The Class PanelArrendador.
 */
public class PanelArrendador extends JPanel implements Datos, ActionListener{
	
	/** The tel. */
	private JLabel nom, ape, dni, tel;
	
	/** The telefono. */
	private static JFormattedTextField CampoDni,telefono;
	
	/** The nombre. */
	private static JTextField nombre;
	
	/** The apellido. */
	private static JTextField apellido;
	
	/** The mascara 2. */
	private MaskFormatter mascara,mascara2;
	
	/** The inf. */
	static String n,a,d,t,inf;
	
	/** The dato. */
	private static JTextArea dato;
	
	/** The boton. */
	private JButton boton;
	
	/** The espacio. */
	private static String espacio ="";
	
	/**
	 * Instantiates a new panel arrendador.
	 */
	public PanelArrendador() {
		
		//setLayout(new GridLayout(1,1,5,10));
		//setLayout(new BorderLayout());
		Box caja = Box.createVerticalBox();
		caja.add(new JLabel(" "));
		
		JPanel p1 = new JPanel(new GridLayout(1,1,20,20) );
		nom= new JLabel("NOMBRE*: ");
		nom.setFont(new Font("Arial",Font.BOLD,20));
		//nom.setBounds(10,10,150,20);
		p1.add(nom);
		p1.setBackground(new Color(100-204-255));
		
		
		nombre = new JTextField();
		//nombre.setBounds(170,10,150,20);
		p1.add(nombre);
		caja.add(p1);
		caja.add(new JLabel(" "));
		caja.add(new JLabel(" "));
		
		JPanel p2 = new JPanel(new GridLayout(1,1,20,20) );
		ape= new JLabel("APELLIDO*: ");
		ape.setFont(new Font("Arial",Font.BOLD,20));
		p2.add(ape);
		
		apellido = new JTextField();
		p2.add(apellido);
		caja.add(p2);
		caja.add(new JLabel(" "));
		caja.add(new JLabel(" "));
		p2.setBackground(new Color(100-204-255));
		
		JPanel p3 = new JPanel(new GridLayout(1,1,20,20) );
		dni= new JLabel("DNI*: ");
		dni.setFont(new Font("Arial",Font.BOLD,20));
		p3.add(dni);
		
		try {
			mascara = new MaskFormatter("########A");
			CampoDni = new JFormattedTextField(mascara);
			CampoDni.setFocusLostBehavior(CampoDni.COMMIT);
			CampoDni.setBounds(150,20,120,20);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		p3.add(CampoDni);
		caja.add(p3);
		caja.add(new JLabel(" "));
		caja.add(new JLabel(" "));
		p3.setBackground(new Color(100-204-255));
		
		JPanel p4 = new JPanel(new GridLayout(1,1,20,20) );
		tel= new JLabel("TELEFONO*: ");
		tel.setFont(new Font("Arial",Font.BOLD,20));
		p4.add(tel);
		
		try {
			mascara2 = new MaskFormatter("#########");
			telefono = new JFormattedTextField(mascara2);
			telefono.setFocusLostBehavior(telefono.COMMIT);
			telefono.setBounds(150,140,120,20);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		p4.add(telefono);
		p4.setBackground(new Color(100-204-255));
		caja.add(p4);
		caja.add(new JLabel(" "));
		caja.add(new JLabel(" "));
		
		setBackground(new Color(100-204-255));
		setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		
		JPanel p5 = new JPanel(new GridLayout(1,1,20,20) );
		boton = new JButton("Recoger");
		boton.addActionListener(this);
		p5.add(boton);
		caja.add(p5);
		dato = new JTextArea();
		add(caja);
		/*n="NOMBRE: "+nombre.getText();
		a="APELLIDO: "+apellido.getText();
		d= "DNI: "+CampoDni.getText();
		t="TELEFONO: "+telefono.getText();*/
		
		
	}
	
	/**
	 * Datos personal.
	 *
	 * @return the component
	 */
	public static Component DatosPersonal() {
		
		JPanel p1= new JPanel();
		//dato.setText(n+"hola");
		p1.add(dato);
		return p1;
		
		/*pt=new JTabbedPane();
		pt.addTab("Datos personal",p1);
		add(pt);*/
	}


	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		n=nombre.getText();
		a=apellido.getText();
		d= CampoDni.getText();
		t=telefono.getText();
		if(e.getSource()==boton) {
			dato.setText("NOMBRE: "+n+"\nAPELLIDO: "+a+"\nDNI: "+d+"\nTELEFONO: "+t);
		}
		
	}
	
	/**
	 * Inf.
	 */
	public static void Inf() {
		
		if(n==null|| a==null|| d==null || t==null ) {
			JOptionPane.showMessageDialog(null, "Falta Datos" ,"Informacion", 
					JOptionPane.INFORMATION_MESSAGE );
		}else {
			JOptionPane.showMessageDialog(null, "Datos Guardado" ,"Informacion", 
					JOptionPane.INFORMATION_MESSAGE );
		}
	}
	
	/**
	 * Limpiar.
	 */
	public static void Limpiar() {
		Datos.setNombre(nombre);
		Datos.setApellido(apellido);
		Datos.setDni(CampoDni);
		Datos.setTelefono(telefono);
	}
	
	

}
