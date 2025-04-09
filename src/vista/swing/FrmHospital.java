package vista.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.CampoVacioException;
import excepciones.DniException;
import excepciones.FechaException;
import modelo.Paciente;
import repositorio.HospitalRepositorio;
import servicio.HospitalServicio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmHospital extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel, panelPaciente, panelMantenimientoLibro, panelNavegador;
	private ImageIcon nuevo, editar, borrar, guardar, deshacer, primero, izquierda, derecha, ultimo;
	private JButton btnNuevo, btnEditar, btnBorrar, btnGuardar, btnDeshacer, btnFiltrar;
	private JLabel lblIdPaciente, lblDni, lblNombre, lblApellidos, lblIsbn, lblFechaNacimiento, lblFecha2;
	private JTextField textIdPaciente, textDni, textNombre, textApellidos, textIsbn, textFechaNacimineto, textConsulta;
	private JCheckBox chcIngresado;
	private JButton btnPrimero, btnIzquierda, btnDerecha, btnFinal;
	private JComboBox cmbConsulta;
	private boolean b, pacienteNuevo;
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
		
		
		
		
		definirVentana();
		definirEventos();

		habilitarNavegador(b);
		habilitarMantenimiento(b);
		
		/*GeneraPacientes gp = new GeneraPacientes();
		try {
			gp.GeneraPacientes();
		} catch (CampoVacioException | DniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		HospitalServicio hospitalServicio = new HospitalServicio();
		pacientes = hospitalServicio.obtenerTodos();
		hospitalServicio = null;
	
		cargarGrid(pacientes);
		mostrarPaciente(puntero);
		
		this.setVisible(true);
	}



	private void cargarGrid(List<Paciente> pacientes) {

		dtm.setRowCount(0);
		dtm.setColumnCount(0);
		String[] pacientitos = {"Dni","Nombre","Apellidos","Diagnóstico","Ultima Consulta"};
		dtm.setColumnIdentifiers(pacientitos);
		
		for (Paciente p:pacientes) {
			String diagnostico = "";
			if(p.getDiagnostico() != null) {
				diagnostico = p.getDiagnostico();
			}
			
			Object[] fila = {p.getDni(),p.getNombre(),p.getApellidos(),diagnostico,p.getUltimaConsulta()};
			dtm.addRow(fila);
			;
		}
		
	}



	private void habilitarMantenimiento(boolean b) {

		btnNuevo.setEnabled(b);
		btnEditar.setEnabled(b);
		btnBorrar.setEnabled(b);
		btnGuardar.setEnabled(!b);
		btnDeshacer.setEnabled(!b);
		
	}



	private void habilitarNavegador(boolean b) {
		
		btnIzquierda.setEnabled(b);
		btnDerecha.setEnabled(b);
		btnPrimero.setEnabled(b);
		btnFinal.setEnabled(b);
		
	}



	private void mostrarPaciente(int puntero) {

		Paciente paciente = pacientes.get(puntero);
		textDni.setText(paciente.getDni());
		textNombre.setText(paciente.getNombre());
		textApellidos.setText(paciente.getApellidos());
		textFechaNacimineto.setText(paciente.getFechaNacimiento().toString());
		chcIngresado.setSelected(paciente.isEnTratamiento());

	}



	private void definirEventos() {

		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				puntero = 0;
				mostrarPaciente(puntero);

			}
		});
		
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntero --;
				if(puntero < 0) puntero = 0;
				mostrarPaciente(puntero);
			}
		});
		
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				puntero++;
				if(puntero == pacientes.size()) puntero = pacientes.size()-1; 
				mostrarPaciente(puntero);
			}
		});
		
		btnFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				puntero = pacientes.size()-1;
				mostrarPaciente(puntero);
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				borrarCampos();
				habilitarNavegador(!b);
				habilitarMantenimiento(!b);
				pacienteNuevo = true;
				
			}

		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pacienteNuevo) {
					HospitalServicio hs = new HospitalServicio();
					try {
						hs.agregarPaciente(textDni.getText(), textNombre.getText(), textApellidos.getText(), textFechaNacimineto.getText());
					} catch (CampoVacioException | FechaException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					hs.obtenerTodos();
				}else {
					
				}
				HospitalServicio hs = new HospitalServicio();
				pacientes = hs.obtenerTodos();
				
				puntero = 0;
				mostrarPaciente(puntero);
				habilitarNavegador(b);
				habilitarMantenimiento(b);
				
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcion = JOptionPane.showConfirmDialog(null,"¿Tas seguro?", "Ventana", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION) {
					pacientes.remove(puntero);
					HospitalServicio hs = new HospitalServicio();
					try {
						hs.borrarPaciente(puntero);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				puntero = 0;
				mostrarPaciente(puntero);
				habilitarNavegador(b);
				habilitarMantenimiento(b);
				
			}
		});
		
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				puntero = 0;
				mostrarPaciente(puntero);
				habilitarNavegador(b);
				habilitarMantenimiento(b);
				
			}
		});
		
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HospitalServicio hs = new HospitalServicio();
				List<Paciente> pacientesFiltrado = null;
				int opcion = cmbConsulta.getSelectedIndex();		
				switch (opcion) {
				
				case 0:
					
					pacientes = hs.obtenerTodos();
					cargarGrid(pacientes);
					break;
					
				case 1:
					
					pacientes = hs.obtenerTodos();					
					String filtro = textConsulta.getText().toLowerCase();
					if(filtro == null) break;
					pacientesFiltrado = pacientes.stream()
						.filter(paciente -> paciente.getNombre().toLowerCase().startsWith(filtro))
						.toList();
					cargarGrid(pacientesFiltrado);
					break;
					
				case 2:
					
					pacientes = hs.obtenerTodos();
					
					pacientesFiltrado = pacientes.stream()
							.filter(paciente -> paciente.isEnTratamiento())
							.toList();
					cargarGrid(pacientesFiltrado);
					break;
				}
			}
		});
	}

	private void borrarCampos() {
		textNombre.setText("");
		textApellidos.setText("");
		textDni.setText("");
		textFechaNacimineto.setText("");
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
		
		panelPaciente = new JPanel();
		panelPaciente.setBounds(42, 161, 503, 224);
		panel.add(panelPaciente);
		panelPaciente.setLayout(null);
		
		lblIdPaciente = new JLabel("Id Paciente:");
		lblIdPaciente.setBounds(10, 11, 88, 14);
		panelPaciente.add(lblIdPaciente);
		
		textIdPaciente = new JTextField();
		textIdPaciente.setBounds(108, 8, 86, 20);
		panelPaciente.add(textIdPaciente);
		textIdPaciente.setColumns(10);
		
		lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 42, 88, 14);
		panelPaciente.add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(108, 39, 251, 20);
		panelPaciente.add(textDni);
		textDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 73, 46, 14);
		panelPaciente.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(108, 70, 251, 20);
		panelPaciente.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 104, 88, 14);
		panelPaciente.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(108, 101, 251, 20);
		panelPaciente.add(textApellidos);
		textApellidos.setColumns(10);
		
		lblIsbn = new JLabel("Isbn:");
		lblIsbn.setBounds(10, 135, 46, 14);
		panelPaciente.add(lblIsbn);
		
		textIsbn = new JTextField();
		textIsbn.setBounds(108, 132, 251, 20);
		panelPaciente.add(textIsbn);
		textIsbn.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(10, 166, 88, 14);
		panelPaciente.add(lblFechaNacimiento);
		
		textFechaNacimineto = new JTextField();
		textFechaNacimineto.setBounds(108, 163, 133, 20);
		panelPaciente.add(textFechaNacimineto);
		textFechaNacimineto.setColumns(10);
		
		lblFecha2 = new JLabel("aaaa-mm-dd");
		lblFecha2.setBounds(251, 166, 108, 14);
		panelPaciente.add(lblFecha2);
		
		chcIngresado = new JCheckBox("Ingresado");
		chcIngresado.setBounds(1, 187, 97, 23);
		chcIngresado.setEnabled(false);
		panelPaciente.add(chcIngresado);
		
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
		cmbConsulta.setModel(new DefaultComboBoxModel(new String[] {"todos", "nombre", "ingresados"}));
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
