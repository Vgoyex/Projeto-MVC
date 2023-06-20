package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import model.Aluno;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class Tela extends JFrame {
	private JPanel contentPane;
	private JLabel labelRgm;
	private JTextField txtRgm;
	private JTextField txtRgm2;
	private JLabel labelRgmNotas;
	private JLabel labelNome;
	private JTextField txtNome;
	private JLabel labelEmail;
	private JTextField txtEmail;
	private JLabel labelEndereco;
	private JTextField txtEndereco;
	private JTextField txtMunicipio;
	private JLabel labelMunicipio;
	private JLabel labelUf;
	private JFormattedTextField txtDtNascimento;
	private JLabel labelDtNascimento;
	private JFormattedTextField txtCelular;
	private JLabel labelCelular;
	private JFormattedTextField txtCpf;
	private JLabel labelCpf;
	private JButton btLimpar;
	private JButton btSalvar;
	private JButton btConsultar;
	private JButton btAlterar;
	private JButton btExcluir;
	private JButton btSair;
	private JButton btnListar;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JSeparator separator;
	private JPanel panel_Curso;
	private JPanel panel_Notas_E_Faltas;
	private JPanel panel_Boletim;
	private JLabel lblNewLabel;
	private JComboBox comboBoxCurso;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxCampus;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBoxDisciplina;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBoxSemestre;
	private JLabel lblNewLabel_5;
	private JComboBox comboBoxNota;
	private JLabel lblNewLabel_6;
	private JTextField txtFaltas;
	private JTextField txtRgm1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCurso;
	private JTextField txtNome1;
	private JComboBox comboBoxUf;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_12;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	//private TextArea txtMostrar;
	//private DefaultTableModel model;
	private JTable table;
	private JLabel labelRgmNotas_3;
	private JLabel labelRgmNotas_4;
	private JLabel labelRgmNotas_5;
	private JLabel labelRgmNotas_6;
	private JLabel labelRgmNotas_7;
	private JLabel labelRgmNotas_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setTitle("Projeto MVC");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// "Design" da tela é feito no próprio construtor
	public Tela() throws Exception {

		// FVG 24/05 - Panel da aplicação
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 476);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Dados Pessoais");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setCelular(txtCelular.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setDtNascimento(txtDtNascimento.getText());
				aluno.setUf(comboBoxUf.getSelectedItem().toString());
				aluno.setMunicipio(txtMunicipio.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);
				}
			}	
	
		});


		mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setCelular(txtCelular.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setDtNascimento(txtDtNascimento.getText());
				aluno.setUf(comboBoxUf.getSelectedItem().toString());
				aluno.setMunicipio(txtMunicipio.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.atualizar(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);
				}
			}
		});

		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultar(alunoRgm);
					// preencher a tela
					txtNome.setText(aluno.getNome());
					txtDtNascimento.setText(aluno.getDtNascimento());
					txtCpf.setText(aluno.getCpf());
					txtEmail.setText(aluno.getEmail());
					txtEndereco.setText(aluno.getEndereco());
					txtMunicipio.setText(aluno.getMunicipio());
					for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
						String item = comboBoxUf.getItemAt(i).toString();
						if (aluno.getUf().equals(item)) {
							comboBoxUf.setSelectedItem(item);
							break;
						}
					}
					txtCelular.setText(aluno.getCelular());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});

		mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mnNewMenu.add(mntmNewMenuItem_3);

		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FVG 02/05 - Evento para limpar todos os dados da tela
				txtNome.setText(null);
				txtEmail.setText(null);
				txtDtNascimento.setValue(null);
				txtRgm.setText(null);
				txtMunicipio.setText(null);
				txtCelular.setText(null);
				txtCpf.setValue(null);
				txtEndereco.setText(null);
			}
		});

		separator = new JSeparator();
		mnNewMenu.add(separator);

		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});
		
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		JMenu mnNewMenu_3 = new JMenu("Curso");
		menuBar.add(mnNewMenu_3);
		mntmNewMenuItem_10 = new JMenuItem("Salvar");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm1.getText());
				aluno.setCurso(comboBoxCurso.getSelectedItem().toString());
				aluno.setCampus(comboBoxCampus.getSelectedItem().toString());
				if (rdbtnNewRadioButton.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton.getText());
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton_1.getText());
				}
				if (rdbtnNewRadioButton_2.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton_2.getText());
				}
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvarCurso(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);

				}
			}
		});
		
		

		mntmNewMenuItem_11 = new JMenuItem("Consultar");
		mnNewMenu_3.add(mntmNewMenuItem_11);

		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm1.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultarCurso(alunoRgm);
					// preencher a tela
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
						String item = comboBoxCurso.getItemAt(i).toString();
						if (aluno.getCurso().equals(item)) {
							comboBoxCurso.setSelectedItem(item);
							break;
						}
					}
					for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
						String item = comboBoxCampus.getItemAt(i).toString();
						if (aluno.getCampus().equals(item)) {
							comboBoxCampus.setSelectedItem(item);
							break;
						}
					}

					if (aluno.getPeriodo().matches("Matutino")) {
						rdbtnNewRadioButton.doClick();
					}
					if (aluno.getPeriodo().matches("Vespertino")) {
						rdbtnNewRadioButton_1.doClick();
					}
					if (aluno.getPeriodo().matches("Noturno")) {
						rdbtnNewRadioButton_2.doClick();
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

			}
		});
		mntmNewMenuItem_12 = new JMenuItem("Limpar");
		mnNewMenu_3.add(mntmNewMenuItem_12);

		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm1.getText());
					AlunoDAO dao = new AlunoDAO();
					dao.excluirCurso(alunoRgm);
					JOptionPane.showMessageDialog(null, "Registro do curso excluido com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});

		mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem_6 = new JMenuItem("Salvar");
		mnNewMenu_1.add(mntmNewMenuItem_6);		
		mntmNewMenuItem_6.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			Aluno aluno = new Aluno();
			aluno.setRgm(txtRgm2.getText());
			aluno.setCurso(txtCurso.getText());
			aluno.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
			aluno.setNota(comboBoxNota.getSelectedItem().toString());
			aluno.setFaltas(txtFaltas.getText());
			try {
				AlunoDAO dao = new AlunoDAO();
				dao.salvarNotasEFaltas(aluno);
				JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
			} catch (Exception f) {
				JOptionPane.showMessageDialog(null, f);

			}
		} });

		mntmNewMenuItem_9 = new JMenuItem("Consultar");
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm2.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultarCurso(alunoRgm);
					txtCurso.setText(aluno.getCurso());
					txtNome1.setText(aluno.getNome());
					atualizarComboBoxDisciplina();
				} catch (Exception not) {
					JOptionPane.showMessageDialog(null, not);
				}
			}
		});

		mntmNewMenuItem_8 = new JMenuItem("Limpar ");
		mnNewMenu_1.add(mntmNewMenuItem_8);

		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm2.setText(null);
				txtCurso.setText(null);
				txtFaltas.setText(null);
				txtNome.setText(null);
				comboBoxDisciplina.setSelectedItem(null);
			}
		});

		mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_5 = new JMenuItem("Sobre");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Informações do Menu");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(71, 25, 571, 300);
		contentPane.add(tabbedPane);

		// --------------- Painel Dados Pessoais --------------------

		JPanel panel_Dados_Pessoais = new JPanel();
		panel_Dados_Pessoais.setBackground(new Color(135, 167, 186));
		tabbedPane.addTab("Dados Pessoais", null, panel_Dados_Pessoais, null);
		panel_Dados_Pessoais.setLayout(null);

		// FVG 02/05 - Toda definição de campos como labels, campos de texto e botões

// -------------- Labels -------------------

		labelRgm = new JLabel("RGM:");
		labelRgm.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgm.setBounds(9, 17, 41, 14);
		panel_Dados_Pessoais.add(labelRgm);
		txtRgm = new JTextField();
		txtRgm.setBounds(50, 12, 126, 25);
		panel_Dados_Pessoais.add(txtRgm);
		labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Arial", Font.BOLD, 12));
		labelNome.setBounds(186, 17, 42, 14);
		panel_Dados_Pessoais.add(labelNome);

		txtNome = new JTextField(20);
		txtNome.setBounds(238, 11, 307, 25);
		panel_Dados_Pessoais.add(txtNome);
		labelDtNascimento = new JLabel("Data de Nascimento:");
		labelDtNascimento.setFont(new Font("Arial", Font.BOLD, 12));
		labelDtNascimento.setBounds(10, 48, 126, 14);
		panel_Dados_Pessoais.add(labelDtNascimento);
		txtDtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDtNascimento.setBounds(137, 43, 126, 25);
		panel_Dados_Pessoais.add(txtDtNascimento);

		labelCpf = new JLabel("CPF:");
		labelCpf.setFont(new Font("Arial", Font.BOLD, 12));
		labelCpf.setBounds(273, 48, 27, 14);
		panel_Dados_Pessoais.add(labelCpf);

		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(310, 43, 235, 25);
		panel_Dados_Pessoais.add(txtCpf);

		labelEmail = new JLabel("E-mail:");
		labelEmail.setFont(new Font("Arial", Font.BOLD, 12));
		labelEmail.setBounds(10, 81, 40, 14);
		panel_Dados_Pessoais.add(labelEmail);

		txtEmail = new JTextField(20);
		txtEmail.setBounds(64, 76, 481, 25);
		panel_Dados_Pessoais.add(txtEmail);

		btSair = new JButton("");
		btSair.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/sair.png")));
		btSair.setBounds(470, 200, 70, 50);

		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});
		labelEndereco = new JLabel("Endereço:");
		labelEndereco.setFont(new Font("Arial", Font.BOLD, 12));
		labelEndereco.setBounds(10, 118, 72, 14);
		panel_Dados_Pessoais.add(labelEndereco);

		txtEndereco = new JTextField(20);
		txtEndereco.setBounds(74, 114, 471, 25);
		panel_Dados_Pessoais.add(txtEndereco);
		labelMunicipio = new JLabel("Município:");
		labelMunicipio.setFont(new Font("Arial", Font.BOLD, 12));
		labelMunicipio.setBounds(10, 155, 75, 14);
		panel_Dados_Pessoais.add(labelMunicipio);

		txtMunicipio = new JTextField(20);
		txtMunicipio.setBounds(74, 150, 170, 25);
		panel_Dados_Pessoais.add(txtMunicipio);
		labelUf = new JLabel("UF:");
		labelUf.setFont(new Font("Arial", Font.BOLD, 12));
		labelUf.setBounds(265, 155, 22, 14);
		panel_Dados_Pessoais.add(labelUf);

		// --------------- Botões -------------------

		btLimpar = new JButton("");
		btLimpar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/limpar.png")));
		btLimpar.setBounds(380, 200, 70, 50);

		// --------------- Eventos nos botões -------------

		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FVG 02/05 - Evento para limpar todos os dados da tela
				txtNome.setText(null);
				txtEmail.setText(null);
				txtDtNascimento.setValue(null);
				txtRgm.setText(null);
				txtMunicipio.setText(null);
				txtCelular.setText(null);
				txtCpf.setValue(null);
				txtEndereco.setText(null);
			}
		});

		JComboBox comboBoxUf = new JComboBox();
		comboBoxUf.setModel(new DefaultComboBoxModel(
				new String[] { "SP", "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL",
						"SE", "BA", "MG", "ES", "RJ", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));
		comboBoxUf.setBounds(287, 151, 41, 22);
		panel_Dados_Pessoais.add(comboBoxUf);

		btSalvar = new JButton("");
		btSalvar.setBounds(20, 200, 70, 50);
		btSalvar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/adicionar.png")));

		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setCelular(txtCelular.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setDtNascimento(txtDtNascimento.getText());
				aluno.setUf(comboBoxUf.getSelectedItem().toString());
				aluno.setMunicipio(txtMunicipio.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);

				}
			}
		});
		labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Arial", Font.BOLD, 12));
		labelCelular.setBounds(348, 155, 54, 14);
		panel_Dados_Pessoais.add(labelCelular);

		txtCelular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txtCelular.setBounds(403, 150, 142, 25);
		panel_Dados_Pessoais.add(txtCelular);
		panel_Dados_Pessoais.add(btSalvar);

		btAlterar = new JButton("");
		btAlterar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/editar.png")));
		btAlterar.setBounds(200, 200, 70, 50);

		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setCelular(txtCelular.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setDtNascimento(txtDtNascimento.getText());
				aluno.setUf(comboBoxUf.getSelectedItem().toString());
				aluno.setMunicipio(txtMunicipio.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.atualizar(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);
				}
			}
		});

		btConsultar = new JButton("");
		btConsultar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/consultar.png")));
		btConsultar.setBounds(110, 200, 70, 50);

		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultar(alunoRgm);
					// preencher a tela
					txtNome.setText(aluno.getNome());
					txtDtNascimento.setText(aluno.getDtNascimento());
					txtCpf.setText(aluno.getCpf());
					txtEmail.setText(aluno.getEmail());
					txtEndereco.setText(aluno.getEndereco());
					txtMunicipio.setText(aluno.getMunicipio());
					for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
						String item = comboBoxUf.getItemAt(i).toString();
						if (aluno.getUf().equals(item)) {
							comboBoxUf.setSelectedItem(item);
							break;
						}
					}
					txtCelular.setText(aluno.getCelular());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		panel_Dados_Pessoais.add(btConsultar);
		panel_Dados_Pessoais.add(btAlterar);

		btExcluir = new JButton("");
		btExcluir.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/excluir.png")));
		btExcluir.setBounds(290, 200, 70, 50);

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm.getText());
					AlunoDAO dao = new AlunoDAO();
					dao.excluir(alunoRgm);
					JOptionPane.showMessageDialog(null, "Registro do aluno excluido com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		panel_Dados_Pessoais.add(btExcluir);
		panel_Dados_Pessoais.add(btLimpar);
		panel_Dados_Pessoais.add(btSair);

// -------------------------------------------------------------

		panel_Curso = new JPanel();
		panel_Curso.setBackground(new Color(135, 167, 186));
		tabbedPane.addTab("Curso", null, panel_Curso, null);
		panel_Curso.setLayout(null);

		lblNewLabel = new JLabel("Curso:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 56, 47, 22);
		panel_Curso.add(lblNewLabel);

		comboBoxCurso = new JComboBox<>();
		comboBoxCurso.setBounds(60, 55, 245, 25);
		comboBoxCurso.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Ciência da Computação", "Relações Internacionais", "Direito" }));
		panel_Curso.add(comboBoxCurso);

		lblNewLabel_1 = new JLabel("Campus:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 101, 56, 14);
		panel_Curso.add(lblNewLabel_1);

		comboBoxCampus = new JComboBox();
		comboBoxCampus.setBounds(70, 96, 95, 25);
		comboBoxCampus.setModel(new DefaultComboBoxModel(new String[] { "Pinheiros", "Tatuapé" }));
		panel_Curso.add(comboBoxCampus);

		lblNewLabel_2 = new JLabel("Período:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 134, 56, 14);
		panel_Curso.add(lblNewLabel_2);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Matutino");
		rdbtnNewRadioButton.setBackground(new Color(135, 167, 186));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(94, 130, 83, 23);
		panel_Curso.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Vespertino");
		rdbtnNewRadioButton_1.setBackground(new Color(135, 167, 186));
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(203, 130, 95, 23);
		panel_Curso.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Noturno");
		rdbtnNewRadioButton_2.setBackground(new Color(135, 167, 186));
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(326, 130, 95, 23);
		panel_Curso.add(rdbtnNewRadioButton_2);

		JButton btSalvar_1 = new JButton("");
		btSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm1.getText());
				aluno.setCurso(comboBoxCurso.getSelectedItem().toString());
				aluno.setCampus(comboBoxCampus.getSelectedItem().toString());
				if (rdbtnNewRadioButton.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton.getText());
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton_1.getText());
				}
				if (rdbtnNewRadioButton_2.isSelected()) {
					aluno.setPeriodo(rdbtnNewRadioButton_2.getText());
				}
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvarCurso(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);

				}
			}
		});
		btSalvar_1.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/adicionar.png")));
		btSalvar_1.setBounds(36, 192, 70, 50);
		panel_Curso.add(btSalvar_1);

		JButton btConsultar_1 = new JButton("");
		btConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm1.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultarCurso(alunoRgm);
					// preencher a tela
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
						String item = comboBoxCurso.getItemAt(i).toString();
						if (aluno.getCurso().equals(item)) {
							comboBoxCurso.setSelectedItem(item);
							break;
						}
					}
					for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
						String item = comboBoxCampus.getItemAt(i).toString();
						if (aluno.getCampus().equals(item)) {
							comboBoxCampus.setSelectedItem(item);
							break;
						}
					}

					if (aluno.getPeriodo().matches("Matutino")) {
						rdbtnNewRadioButton.doClick();
					}
					if (aluno.getPeriodo().matches("Vespertino")) {
						rdbtnNewRadioButton_1.doClick();
					}
					if (aluno.getPeriodo().matches("Noturno")) {
						rdbtnNewRadioButton_2.doClick();
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

			}
		});
		btConsultar_1.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/consultar.png")));
		btConsultar_1.setBounds(142, 192, 70, 50);
		panel_Curso.add(btConsultar_1);

		JButton btLimpar_1 = new JButton("");
		btLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm1.setText(null);

			}
		});
		btLimpar_1.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/limpar.png")));
		btLimpar_1.setBounds(248, 192, 70, 50);
		panel_Curso.add(btLimpar_1);

		JButton btSair_1 = new JButton("");
		btSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});
		btSair_1.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/sair.png")));
		btSair_1.setBounds(460, 192, 70, 50);
		panel_Curso.add(btSair_1);

		JLabel labelRgmNotas_1 = new JLabel("RGM:");
		labelRgmNotas_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_1.setBounds(10, 21, 56, 14);
		panel_Curso.add(labelRgmNotas_1);

		txtRgm1 = new JTextField();
		txtRgm1.setBounds(50, 16, 188, 25);
		panel_Curso.add(txtRgm1);

		JButton btExcluir_1 = new JButton("");
		btExcluir_1.setBounds(354, 192, 70, 50);
		panel_Curso.add(btExcluir_1);
		btExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm1.getText());
					AlunoDAO dao = new AlunoDAO();
					dao.excluirCurso(alunoRgm);
					JOptionPane.showMessageDialog(null, "Registro do curso excluido com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

			}
		});
		btExcluir_1.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/excluir.png")));
		labelRgmNotas = new JLabel("RGM:");
		labelRgmNotas.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas.setBounds(10, 21, 37, 14);

// ------------ Campos de Texto ----------------

		txtRgm2 = new JTextField();
		txtRgm2.setBounds(48, 16, 187, 25);

		panel_Notas_E_Faltas = new JPanel();
		panel_Notas_E_Faltas.setBackground(new Color(135, 167, 186));
		tabbedPane.addTab("Notas e Faltas", null, panel_Notas_E_Faltas, null);
		panel_Notas_E_Faltas.setLayout(null);

		panel_Notas_E_Faltas.add(labelRgmNotas);
		panel_Notas_E_Faltas.add(txtRgm2);

		comboBoxDisciplina = new JComboBox<String>();
		comboBoxDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String disciplinaSelecionada = (String) comboBoxDisciplina.getSelectedItem();

				// Cria um objeto Aluno com os valores selecionados e busca as notas e faltas
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm2.getText());
				aluno.setDisciplina(disciplinaSelecionada);
				try {
					AlunoDAO alunoDAO = new AlunoDAO();
					aluno = alunoDAO.buscarNotaEFaltas(aluno);
					// Preencher a tela
					txtFaltas.setText(aluno.getFaltas());
					for (int i = 0; i < comboBoxNota.getItemCount(); i++) {
						String item = comboBoxNota.getItemAt(i).toString();
						if (aluno.getNota().equals(item)) {
							comboBoxNota.setSelectedItem(item);
							break;
						}
					}
				} catch (Exception ex) {
				}
			}
		});
		comboBoxDisciplina.setBounds(76, 92, 445, 25);
		panel_Notas_E_Faltas.add(comboBoxDisciplina);

		lblNewLabel_3 = new JLabel("Disciplina:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 97, 80, 14);
		panel_Notas_E_Faltas.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Semestre:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(30, 132, 80, 14);
		panel_Notas_E_Faltas.add(lblNewLabel_4);

		comboBoxSemestre = new JComboBox<>();
		comboBoxSemestre.setBounds(109, 127, 71, 25);
		comboBoxSemestre.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2" }));
		comboBoxSemestre.setSelectedIndex(0);
		comboBoxSemestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarComboBoxDisciplina();
			}
		});
		panel_Notas_E_Faltas.add(comboBoxSemestre);

		lblNewLabel_5 = new JLabel("Nota:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(241, 132, 46, 14);
		panel_Notas_E_Faltas.add(lblNewLabel_5);

		comboBoxNota = new JComboBox();
		comboBoxNota.setModel(new DefaultComboBoxModel(new String[] { "0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0",
				"3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10" }));
		comboBoxNota.setBounds(285, 127, 51, 25);
		panel_Notas_E_Faltas.add(comboBoxNota);

		lblNewLabel_6 = new JLabel("Faltas:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(398, 132, 46, 14);
		panel_Notas_E_Faltas.add(lblNewLabel_6);

		txtFaltas = new JTextField();
		txtFaltas.setBounds(445, 127, 57, 25);
		panel_Notas_E_Faltas.add(txtFaltas);
		txtFaltas.setColumns(10);

		JButton btConsultar_2 = new JButton("");
		btConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm2.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultarCurso(alunoRgm);
					txtCurso.setText(aluno.getCurso());
					txtNome1.setText(aluno.getNome());
					atualizarComboBoxDisciplina();
				} catch (Exception not) {
					JOptionPane.showMessageDialog(null, not);
				}
			}
		});
		btConsultar_2.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/consultar.png")));
		btConsultar_2.setBounds(142, 194, 70, 50);
		panel_Notas_E_Faltas.add(btConsultar_2);

		JButton btLimpar_2 = new JButton("");
		btLimpar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm2.setText(null);
				txtCurso.setText(null);
				txtFaltas.setText(null);
				txtNome.setText(null);
				comboBoxDisciplina.setSelectedItem(null);
			}
		});
		btLimpar_2.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/limpar.png")));
		btLimpar_2.setBounds(248, 194, 70, 50);
		panel_Notas_E_Faltas.add(btLimpar_2);

		JButton btExcluir_2 = new JButton("");
		btExcluir_2.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/excluir.png")));
		btExcluir_2.setBounds(354, 194, 70, 50);
		panel_Notas_E_Faltas.add(btExcluir_2);

		JButton btSair_2 = new JButton("");
		btSair_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});
		btSair_2.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/sair.png")));
		btSair_2.setBounds(460, 194, 70, 50);
		panel_Notas_E_Faltas.add(btSair_2);

		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setBounds(110, 56, 327, 25);
		panel_Notas_E_Faltas.add(txtCurso);
		txtNome1 = new JTextField();
		txtNome1.setEditable(false);
		txtNome1.setBounds(273, 16, 248, 25);
		panel_Notas_E_Faltas.add(txtNome1);

		JButton btSalvar_2 = new JButton("");
		btSalvar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm2.getText());
				aluno.setCurso(txtCurso.getText());
				aluno.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
				aluno.setNota(comboBoxNota.getSelectedItem().toString());
				aluno.setFaltas(txtFaltas.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvarNotasEFaltas(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);

				}
			}
		});

		btSalvar_2.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/adicionar.png")));
		btSalvar_2.setBounds(36, 194, 70, 50);
		panel_Notas_E_Faltas.add(btSalvar_2);

		panel_Boletim = new JPanel();
		panel_Boletim.setBackground(new Color(135, 167, 188));
		tabbedPane.addTab("Boletim", null, panel_Boletim, null);
		panel_Boletim.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    	    AlunoDAO dao = new AlunoDAO();
		    	    List<Aluno> lista = dao.listarTodos();

		    	    // Ordenar a lista por RGM
		    	    Collections.sort(lista, new Comparator<Aluno>() {
		    	        public int compare(Aluno a1, Aluno a2) {
		    	            return a1.getRgm().compareTo(a2.getRgm());
		    	        }
		    	    });

		    	    // Definir as colunas da tabela
		    	    String[] colunas = {"RGM", "Nome", "Curso", "Disciplina", "Nota", "Faltas"};

		    	    // Criar o modelo da tabela com as colunas
		    	    DefaultTableModel model = new DefaultTableModel(colunas, 0);

		    	    // Preencher o modelo com os dados dos alunos que possuem disciplina preenchida
		    	    for (Aluno a : lista) {
		    	        if (!a.getDisciplina().isEmpty()) {
		    	            String rgm = a.getRgm();
		    	            String nome = a.getNome();
		    	            String curso = a.getCurso();
		    	            String disciplina = a.getDisciplina();
		    	            String nota = a.getNota();
		    	            String faltas = a.getFaltas();
		    	            Object[] data = {rgm, nome, curso, disciplina, nota, faltas};
		    	            model.addRow(data);
		    	        }
		    	    }

		    	    // Definir o modelo da tabela como o modelo criado anteriormente
		    	    table.setModel(model);

		    	} catch (Exception e2) {
		    	    JOptionPane.showMessageDialog(null, e2.getMessage());
		    	}  
		    }
		});
		btnListar.setBounds(215, 11, 89, 23);
		panel_Boletim.add(btnListar);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RGM", "Nome", "Disciplina", "Curso", "Nota", "New column"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(51);
		table.setBounds(30, 65, 509, 196);
		panel_Boletim.add(table);
		
		labelRgmNotas_3 = new JLabel("RGM:");
		labelRgmNotas_3.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_3.setBounds(44, 42, 37, 14);
		panel_Boletim.add(labelRgmNotas_3);
		
		labelRgmNotas_4 = new JLabel("Nome:");
		labelRgmNotas_4.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_4.setBounds(125, 42, 37, 14);
		panel_Boletim.add(labelRgmNotas_4);
		
		labelRgmNotas_5 = new JLabel("Curso");
		labelRgmNotas_5.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_5.setBounds(206, 42, 37, 14);
		panel_Boletim.add(labelRgmNotas_5);
		
		labelRgmNotas_6 = new JLabel("Disciplina:");
		labelRgmNotas_6.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_6.setBounds(287, 42, 69, 14);
		panel_Boletim.add(labelRgmNotas_6);
		
		labelRgmNotas_7 = new JLabel("Notas:");
		labelRgmNotas_7.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_7.setBounds(400, 42, 37, 14);
		panel_Boletim.add(labelRgmNotas_7);
		
		labelRgmNotas_8 = new JLabel("Faltas:");
		labelRgmNotas_8.setFont(new Font("Arial", Font.BOLD, 12));
		labelRgmNotas_8.setBounds(481, 42, 37, 14);
		panel_Boletim.add(labelRgmNotas_8);

	}
	
	

	private void atualizarComboBoxDisciplina() {
		String semestreSelecionado = (String) comboBoxSemestre.getSelectedItem();
		String cursoSelecionado = txtCurso.getText();
		if (cursoSelecionado.matches("Ciência da Computação") || cursoSelecionado.equals("Relações Internacionais")
				|| cursoSelecionado.equals("Direito")) {
			comboBoxDisciplina.removeAllItems();

			if (cursoSelecionado.equals("Ciência da Computação")) {
				if (semestreSelecionado.equals("1")) {
					comboBoxDisciplina.addItem("Laborátorio de Desenvolvimento de Algoritmos");
					comboBoxDisciplina.addItem("Programação Web");
					comboBoxDisciplina.addItem("Técnicas de Desenvolvimento de Algoritmos");

				} else if (semestreSelecionado.equals("2")) {
					comboBoxDisciplina.addItem("Programação Orientada a Objetos");
					comboBoxDisciplina.addItem("Estrutura de Dados");
					comboBoxDisciplina.addItem("Matemática Discreta");
				}

			} else if (cursoSelecionado.equals("Relações Internacionais")) {
				if (semestreSelecionado.equals("1")) {
					comboBoxDisciplina.addItem("Teoria das Relações Internacionais");
					comboBoxDisciplina.addItem("Ciência Política Contemporânea");
					comboBoxDisciplina.addItem("Comércio Internacional");

				} else if (semestreSelecionado.equals("2")) {
					comboBoxDisciplina.addItem("Economia Internacional");
					comboBoxDisciplina.addItem("Integração Regional");
					comboBoxDisciplina.addItem("História do Mundo Moderno");
				}
			} else if (cursoSelecionado.equals("Direito")) {
				if (semestreSelecionado.equals("1")) {
					comboBoxDisciplina.addItem("Antropologia e Direito");
					comboBoxDisciplina.addItem("Direito de Família");
					comboBoxDisciplina.addItem("Direito Penal - 1");

				} else if (semestreSelecionado.equals("2")) {
					comboBoxDisciplina.addItem("Direito Processual Civil - 1");
					comboBoxDisciplina.addItem("Direito Penal - 2");
					comboBoxDisciplina.addItem("Direito Empresarial - 1");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Curso inválido!");
		}
	}
}
