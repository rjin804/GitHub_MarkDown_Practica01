/**
 * swing_c_p02_JinRui
   29 Nov 2021 05:13:55
   @author Rui Jin
 */


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

/**
 * The Class PanelInmueble.
 */
public class PanelInmueble extends JPanel implements ActionListener,ChangeListener{
	
	/** The tipo cama. */
	private JComboBox<String>provencia,tipoCama;
	
	/** The edad. */
	private JSpinner fechaAlta,fechaFinal, huespedes, dormitorio,banos,cama,edad;
	
	/** The imagen 3. */
	private JCheckBox nino,imagen1,imagen2,imagen3;
	
	/** The txt 11. */
	//private JFormattedTextField fechaFinal;
	private JLabel txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
	
	/** The txtprecio. */
	private JLabel img1,img2,img3,txt12,txtprecio;
	
	/** The p 5. */
	private JPanel p1,p2,p3,panelCama,p4,panelNino,panelImagen,precio,p5;
	
	/** The area precio. */
	private JTextArea areaTexto,areaPrecio;
	
	/** The i 3. */
	private ImageIcon i1,i2,i3;
	
	/** The dato. */
	private static JTextArea dato;
	
	/** The boton. */
	private JButton boton ;
	
	/** The extra. */
	static String prov,fAlta,fFinal,huesped,dorm,b, cam, tiCamas,n,extra;
	
	/**
	 * Instantiates a new panel inmueble.
	 */
	public PanelInmueble() {
		
		setLayout(new BorderLayout());
		Box caja = Box.createVerticalBox();
		//caja.add(new JLabel(" "));
		
		p1 = new JPanel(new GridLayout(2,3,20,20) );
		txt1= new JLabel ("PROVENCIA: ");
		p1.add(txt1);
		
		txt2= new JLabel ("FECHA DE ALTA: ");
		p1.add(txt2);
		
		txt3= new JLabel ("FECHA FINAL: ");
		p1.add(txt3);
		
		String [] prov = {"Almería","Cádiz","Córdoba","Granada","Huelva","Jaén","Málaga","Sevilla",
				"Albacete","Ciudad Real","Cuenca","Guadalajara","Toledo","Badajoz","Cáceres",
				"Alicante","Castellón","Valencia","Madrid","Ávila","Burgos","León","Palencia",
				"Salamanca","Segovia","Soria","Valladolid","Zamora","Huesca","Teruel","Zaragoza",
				"Barcelona","Girona","Lleida","Tarragona","Coruña","Lugo","Orense","Pontevedra",
				"Cantabria","Álava","Guipúzcoa","Vizcaya","Navarra","Murcia","La Rioja","Las Palmas",
				"Santa Cruz de Tenerife"};
		
		provencia = new JComboBox<String>(prov);
		provencia.addActionListener(this);;
		p1.add(provencia);
		
		fechaAlta= new JSpinner(new SpinnerDateModel());
		p1.add(fechaAlta);
		
		//DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate hoy = LocalDate.now();
		LocalDate fin = hoy.plusYears(1);
		//fin.format(myFormatObj);
		Date fecha = Date.valueOf(fin);
		
		fechaFinal= new JSpinner(new SpinnerDateModel(fecha,null,null,Calendar.DAY_OF_MONTH));
		p1.add(fechaFinal);
		
		caja.add(p1);
		
		p2 = new JPanel(new GridLayout(3,1,20,20) );
		txt4 = new JLabel("Nº HUÉSPEDES: ");
		p2.add(txt4);
		
		SpinnerNumberModel n1 = new SpinnerNumberModel();
		n1.setMaximum(8);
		n1.setMinimum(0);
		huespedes = new JSpinner(n1);
		huespedes.addChangeListener(this);
		p2.add(huespedes);
		
		txt5 = new JLabel("Nº DORMITORIO: ");
		p2.add(txt5);
		SpinnerNumberModel n2 = new SpinnerNumberModel();
		n2.setMaximum(4);
		n2.setMinimum(0);
		dormitorio = new JSpinner(n2);
		dormitorio.addChangeListener(this);
		p2.add(dormitorio);
		
		txt6 = new JLabel("Nº BAÑOS: ");
		p2.add(txt6);
		SpinnerNumberModel n3 = new SpinnerNumberModel();
		n3.setMaximum(2);
		n3.setMinimum(0);
		banos = new JSpinner(n3);
		banos.addChangeListener(this);
		p2.add(banos);
		caja.add(p2);
		
		p3 = new JPanel(new GridLayout(1,1,20,20) );
		txt7 = new JLabel("Nº CAMA: ");
		p3.add(txt7);
		
		SpinnerNumberModel n4 = new SpinnerNumberModel();
		n4.setMaximum(4);
		n4.setMinimum(0);
		cama=new JSpinner(n4);
		cama.addChangeListener(this);
		p3.add(cama);
		
		panelCama = new JPanel();
		String [] tipo = {"simple","doble","sófa cama"};
		txt8 = new JLabel("Tipo de cama: ");
		panelCama.add(txt8);
		tipoCama = new JComboBox<String>(tipo);
		tipoCama.addActionListener(this);
		panelCama.add(tipoCama);
		panelCama.setBackground(Color.LIGHT_GRAY);
		panelCama.setVisible(false);
		p3.add(panelCama);
		caja.add(p3);
		
		p4 = new JPanel(new GridLayout(1,1,20,20) );
		txt9 = new JLabel("NIÑOS? ");
		p4.add(txt9);
		
		nino= new JCheckBox("SI");
		nino.addActionListener(this);
		p4.add(nino);
		
		panelNino = new JPanel(new GridLayout(2,2,20,20) );
		txt10 = new JLabel("EDAD DE NIÑO: ");
		panelNino.add(txt10);
		
		SpinnerNumberModel n5 = new SpinnerNumberModel();
		n5.setMaximum(10);
		n5.setMinimum(0);
		edad=new JSpinner(n5);
		edad.addChangeListener(this);
		panelNino.add(edad);
		
		txt11 = new JLabel("EXTRA: ");
		txt11.setVisible(false);
		panelNino.add(txt11);
		
		areaTexto = new JTextArea();
		areaTexto.setVisible(false);
		panelNino.add(areaTexto);
		panelNino.setVisible(false);
		p4.add(panelNino);
		caja.add(p4);
		
		panelImagen = new JPanel(new GridLayout(1,1,20,20));
		txt12 = new JLabel ("Panel Imágenes");
		panelImagen.add(txt12);
		
		imagen1= new JCheckBox("IMAGEN 1");
		imagen1.addActionListener(this);
		panelImagen.add(imagen1);
		
		imagen2= new JCheckBox("IMAGEN 2");
		imagen2.addActionListener(this);
		panelImagen.add(imagen2);
		
		imagen3= new JCheckBox("IMAGEN 3");
		imagen3.addActionListener(this);
		panelImagen.add(imagen3);
		
		i1 = new ImageIcon(getClass().getResource("recursos/p1.jpg"));
		img1= new JLabel(i1);
		img1.setVisible(false);
		panelImagen.add(img1);
		
		i2 = new ImageIcon(getClass().getResource("recursos/p2.jpg"));
		img2= new JLabel(i2);
		img2.setVisible(false);
		panelImagen.add(img2);
		
		i3 = new ImageIcon(getClass().getResource("recursos/p3.png"));
		img3= new JLabel(i3);
		img3.setVisible(false);
		panelImagen.add(img3);
		caja.add(panelImagen);	
		
		precio = new JPanel(new GridLayout(2,1,20,20));
		txtprecio = new JLabel("PRECIO:  \n"+
		" Por cama doble: 20 €   \r\n"
		+ " Por sofá cama: 15 €   \r\n"
		+ " Por cama simple: 15 €   \r\n"
		+ " Por baño: 25 €   \r\n"
		+ " Cuna o cama supletoria: 12 €");
		precio.add(txtprecio);
		areaPrecio = new JTextArea();
		precio.add(areaPrecio);
		caja.add(precio);
		
		p5 = new JPanel();
		boton = new JButton ("Recoger");
		boton.addActionListener(this);
		p5.add(boton);
		caja.add(p5);
		add(caja);
		
		setBorder(BorderFactory.createLineBorder(Color.RED,2));
		
		dato = new JTextArea();
		
	}
	
	/** The ninos. */
	private String pro="",tiCama="",ninos="";
	
	/** The ed. */
	private int nCama=0, ba=0,preCama=0,total=0,dor=0,hus=0,ed=0;
	
	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==cama) {
			nCama = (int)cama.getValue();
			cam="Nº Cama: "+nCama;
		}
		if(nCama!=0) {
			panelCama.setVisible(true);
		}else {
			panelCama.setVisible(false);
		}
		if(e.getSource()==banos) {
			ba=(int)banos.getValue();
			b = "Nº Baño"+ba;
		}
		if(e.getSource()==huespedes) {
			hus=(int)huespedes.getValue();
			huesped = "Nº Huéspedes: "+hus;
		}
		if(e.getSource()==dormitorio) {
			dor=(int)dormitorio.getValue();
			dorm = "Nº Dormitorio: "+dor;
		}
		if(e.getSource()==edad) {
			ed=(int)edad.getValue();
			extra="Edad de Niños: "+ed;
		}
		
	}
	
	/**
	 * Gets the ba.
	 *
	 * @return the ba
	 */
	public int getBa() {
			return ba;
		}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		total = 0;
		total+=25*getBa();
		if(provencia ==e.getSource()) {
			pro=(String)provencia.getSelectedItem();
			prov = "Provencia: "+pro;
		}
		if(nino.isSelected()) {
			panelNino.setVisible(true);
			total += 12;
			ninos="Si";
			n="Si";
			txt11.setVisible(true);
			
			if(ed>=0 && ed<4) {
				areaTexto.setText("Usa Cuna");
			}else {
				areaTexto.setText("Usa cama supletoria pequeña");
			}
			areaTexto.setVisible(true);
		}else {
			panelNino.setVisible(false);
		}
		if(tipoCama==e.getSource()) {
			tiCama=(String)tipoCama.getSelectedItem();
			tiCamas= "Tipo Cama: "+tiCama;
		}
		if(tiCama.equalsIgnoreCase("simple")) {
			preCama+= 15;
		}
		if(tiCama.equalsIgnoreCase("doble")) {
			preCama+= 20;
		}
		if(tiCama.equalsIgnoreCase("sofá cama")) {
			preCama+= 15;
		}
		if(imagen1.isSelected() ) {
			img1.setVisible(true);
		}else {
			img1.setVisible(false);
		}
		if(imagen2.isSelected() ) {
			img2.setVisible(true);
		}else {
			img2.setVisible(false);
		}
		if(imagen3.isSelected()) {
			img3.setVisible(true);
		}else  {
			img3.setVisible(false);
		}
		total+=preCama;
		areaPrecio.setText("  Precio Total: "+total);
	
		
		 fAlta = fechaAlta.getValue().toString();
		 fFinal = fechaFinal.getValue().toString();
		 if(extra==null) {
			 extra="Edad de Niños: "+0;
		 }
		
		if(e.getSource()==boton) {
			dato.setText(prov+"\n"+fAlta+"\n"+fFinal+"\n"+huesped+"\n"+dorm+"\n"+b
					+"\n"+cam+"\n"+tiCamas+"\n"+n+"\n"+extra+"\n"+areaTexto.getText());
		}
		
		
	}
	
	/**
	 * Datos hotel.
	 *
	 * @return the component
	 */
	public static Component DatosHotel() {
		
		
		JPanel p1= new JPanel();
		//dato.setText(n+"hola");
		p1.add(dato);
		return p1;
		
		/*pt=new JTabbedPane();
		pt.addTab("Datos personal",p1);
		add(pt);*/
	}

}
