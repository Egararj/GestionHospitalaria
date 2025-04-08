package vista.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;


public class FrmHospital extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel, panelLibros, panelMantenimientoLibro, panelNavegador;
	private ImageIcon nuevo, editar, borrar, guardar, deshacer, primero, izquierda, derecha, ultimo;
	private JButton btnNuevo, btnEditar, btnBorrar, btnGuardar, btnDeshacer, btnFiltrar;
	private JLabel lblIdPaciente, lblDni, lblNombre, lblApellidos, lblIsbn, lblFechaNacimiento, lblFecha2;
	private JTextField textIdPaciente, textDni, textNombre, textApellidos, textIsbn, textFechaNacimineto, textConsulta;
	private JCheckBox chcPrestado;
	private JButton btnPrimero, btnIzquierda, btnDerecha, btnFinal;
	private JComboBox cmbConsulta;
	private boolean b, libroNuevo;
	private int puntero, tamaño;
	DefaultTableModel dtm;
	List<Paciente>pacientes= new ArrayList<Paciente>();
	private JTable tableLibros;

	
	
	public FrmHospital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1215, 621);
		puntero = 0;
		b = true;
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		definirEventos();
		definirVentana();
		mostrarPaciente();
		
		this.setVisible(true);
	}



	private void mostrarPaciente() {

		Paciente paciente = pacientes.get(puntero);
		
	}



	private void definirEventos() {

		
	}



	private void definirVentana() {
		panelMantenimientoLibro = new JPanel();
		panelMantenimientoLibro.setBounds(42, 29, 503, 110);
		panel.add(panelMantenimientoLibro);
		panelMantenimientoLibro.setLayout(null);
		
		nuevo = new ImageIcon("imagenes/botonAgregar.jpg");
		btnNuevo = new JButton(nuevo);
		btnNuevo.setBounds(10, 11, 88, 84);
		panelMantenimientoLibro.add(btnNuevo);
		
		editar = new ImageIcon("imagenes/botonEditar.jpg");
		btnEditar = new JButton(editar);
		btnEditar.setBounds(108, 11, 88, 84);
		panelMantenimientoLibro.add(btnEditar);
		
		borrar = new ImageIcon("imagenes/borrar.jpg");
		btnBorrar = new JButton(borrar);
		btnBorrar.setBounds(206, 11, 88, 83);
		panelMantenimientoLibro.add(btnBorrar);
		
		guardar = new ImageIcon("imagenes/botonGuardar.jpg");
		btnGuardar = new JButton(guardar);
		btnGuardar.setBounds(304, 11, 88, 83);
		btnGuardar.setEnabled(false);
		panelMantenimientoLibro.add(btnGuardar);
		
		deshacer = new ImageIcon("imagenes/botonDeshacer.jpg");
		btnDeshacer = new JButton(deshacer);
		btnDeshacer.setBounds(402, 11, 88, 83);
		btnDeshacer.setEnabled(false);
		panelMantenimientoLibro.add(btnDeshacer);
		
		panelLibros = new JPanel();
		panelLibros.setBounds(42, 161, 503, 224);
		panel.add(panelLibros);
		panelLibros.setLayout(null);
		
		lblIdPaciente = new JLabel("Id Libro:");
		lblIdPaciente.setBounds(10, 11, 88, 14);
		panelLibros.add(lblIdPaciente);
		
		textIdPaciente = new JTextField();
		textIdPaciente.setBounds(108, 8, 86, 20);
		panelLibros.add(textIdPaciente);
		textIdPaciente.setColumns(10);
		
		lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 42, 88, 14);
		panelLibros.add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(108, 39, 251, 20);
		panelLibros.add(textDni);
		textDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 73, 46, 14);
		panelLibros.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(108, 70, 251, 20);
		panelLibros.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 104, 88, 14);
		panelLibros.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(108, 101, 251, 20);
		panelLibros.add(textApellidos);
		textApellidos.setColumns(10);
		
		lblIsbn = new JLabel("Isbn:");
		lblIsbn.setBounds(10, 135, 46, 14);
		panelLibros.add(lblIsbn);
		
		textIsbn = new JTextField();
		textIsbn.setBounds(108, 132, 251, 20);
		panelLibros.add(textIsbn);
		textIsbn.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(10, 166, 88, 14);
		panelLibros.add(lblFechaNacimiento);
		
		textFechaNacimineto = new JTextField();
		textFechaNacimineto.setBounds(108, 163, 133, 20);
		panelLibros.add(textFechaNacimineto);
		textFechaNacimineto.setColumns(10);
		
		lblFecha2 = new JLabel("aaaa-mm-dd");
		lblFecha2.setBounds(251, 166, 108, 14);
		panelLibros.add(lblFecha2);
		
		chcPrestado = new JCheckBox("Prestado");
		chcPrestado.setBounds(1, 187, 97, 23);
		chcPrestado.setEnabled(false);
		panelLibros.add(chcPrestado);
		
		panelNavegador = new JPanel();
		panelNavegador.setBounds(42, 396, 249, 71);
		panel.add(panelNavegador);
		panelNavegador.setLayout(null);
		
		primero = new ImageIcon("imagenes/navPri.jpg");
		btnPrimero = new JButton(primero);
		btnPrimero.setBounds(10, 11, 48, 46);
		panelNavegador.add(btnPrimero);
		
		izquierda = new ImageIcon("imagenes/navIzq.jpg");
		btnIzquierda = new JButton(izquierda);
		btnIzquierda.setBounds(68, 11, 48, 46);
		panelNavegador.add(btnIzquierda);
		
		derecha = new ImageIcon("imagenes/navDer.jpg");
		btnDerecha = new JButton(derecha);
		btnDerecha.setBounds(126, 11, 48, 46);
		panelNavegador.add(btnDerecha);
		
		ultimo = new ImageIcon("imagenes/navUlt.jpg");
		btnFinal = new JButton(ultimo);
		btnFinal.setBounds(184, 11, 48, 46);
		panelNavegador.add(btnFinal);
		
		cmbConsulta = new JComboBox();
		cmbConsulta.setModel(new DefaultComboBoxModel(new String[] {"todos", "autor", "no devueltos"}));
		cmbConsulta.setBounds(597, 54, 134, 22);
		panel.add(cmbConsulta);
		
		textConsulta = new JTextField();
		textConsulta.setBounds(762, 55, 177, 20);
		panel.add(textConsulta);
		textConsulta.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(964, 54, 89, 23);
		panel.add(btnFiltrar);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setBounds(597, 87, 592, 400);
		panel.add(panelGrid);
		panelGrid.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelGrid.add(scrollPane, BorderLayout.CENTER);
		
		dtm = new DefaultTableModel();
		tableLibros = new JTable(dtm);
		tableLibros.setEnabled(false);
		scrollPane.setViewportView(tableLibros);
				
	}

}
