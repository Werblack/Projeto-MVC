package Telas;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.projeto.crud.NotaEFalta;
import br.com.projeto.crud.PessoasDAO;
import br.com.projeto.model.DadosPessoais;
import br.com.projeto.model.NotasFaltas;

public class Tela_01 extends JFrame {

	// MARK: ATRIBUTOS
	private JPanel contentPane;
	private JTextField txtRgm;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMunicipio;
	private JTextField txtCel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtRgm1;
	private JTextField txtFaltas1;
	private JTextField txtRgm2;
	private TextArea txtListar;
	private JButton btnNewButton;
	private JLabel lblNomeBoletim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_01 frame = new Tela_01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_01() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 318);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAluno = new JMenu("ALUNO");
		menuBar.add(mnAluno);

		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");

		mnAluno.add(mntmNewMenuItem);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");

		mnAluno.add(mntmAlterar);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");

		mnAluno.add(mntmConsultar);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");

		mnAluno.add(mntmExcluir);

		JSeparator separator = new JSeparator();
		mnAluno.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");

		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAluno.add(mntmSair);

		JMenu mnNotasEFaltas = new JMenu("NOTAS E FALTAS");
		menuBar.add(mnNotasEFaltas);

		JMenuItem mntmSalvar = new JMenuItem("Salvar");

		mnNotasEFaltas.add(mntmSalvar);

		JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");

		mnNotasEFaltas.add(mntmAlterar_1);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");

		mnNotasEFaltas.add(mntmConsultar_1);

		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");

		mnNotasEFaltas.add(mntmExcluir_1);

		JMenuItem mntmSair_1 = new JMenuItem("Sair");

		mntmSair_1.setBorder(new CompoundBorder());
		mntmSair_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNotasEFaltas.add(mntmSair_1);

		JMenu mnAjuda = new JMenu("AJUDA");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 450, 211);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);

		JLabel lblRgm = new JLabel("RGM");
		lblRgm.setBounds(10, 11, 48, 14);
		panel.add(lblRgm);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(211, 11, 48, 14);
		panel.add(lblNome);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 43, 121, 14);
		panel.add(lblDataDeNascimento);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(211, 43, 48, 14);
		panel.add(lblCpf);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(10, 80, 48, 14);
		panel.add(lblEmail);

		JLabel lblEnd = new JLabel("END.");
		lblEnd.setBounds(10, 118, 48, 14);
		panel.add(lblEnd);

		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setBounds(10, 158, 62, 14);
		panel.add(lblMunicipio);

		JLabel txtUf = new JLabel("UF");
		txtUf.setBounds(211, 158, 48, 14);
		panel.add(txtUf);

		JLabel lblCelular = new JLabel("Cel.");
		lblCelular.setBounds(290, 158, 48, 14);
		panel.add(lblCelular);

		txtRgm = new JTextField();
		txtRgm.setBounds(51, 8, 150, 20);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(260, 8, 158, 20);
		panel.add(txtNome);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(68, 77, 367, 20);
		panel.add(txtEmail);

		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		txtEnd.setBounds(68, 115, 367, 20);
		panel.add(txtEnd);

		txtMunicipio = new JTextField();
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(88, 155, 121, 20);
		panel.add(txtMunicipio);

		txtCel = new JFormattedTextField(new MaskFormatter(" (##)  ##### - ####  "));
		txtCel.setColumns(10);
		txtCel.setBounds(312, 155, 123, 20);
		panel.add(txtCel);

		JComboBox cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] { "SP", "RJ" }));
		cmbUf.setBounds(232, 154, 48, 22);
		panel.add(cmbUf);

		JFormattedTextField txtDataNascimento = new JFormattedTextField(new MaskFormatter("  ##/##/####"));
		txtDataNascimento.setBounds(130, 40, 71, 20);
		panel.add(txtDataNascimento);

		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(260, 40, 158, 20);
		panel.add(txtCpf);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(10, 11, 48, 14);
		panel_1.add(lblCursos);

		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setBounds(10, 40, 48, 14);
		panel_1.add(lblCampus);

		JLabel lblPriodo = new JLabel("P\u00E9riodo");
		lblPriodo.setBounds(10, 74, 48, 14);
		panel_1.add(lblPriodo);

		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "Analise e Desenvolvimento de Sistemas",
				"Redes de Computadores", "Ci\u00EAncia da Computa\u00E7\u00E3o" }));
		cmbCurso.setBounds(65, 7, 332, 22);
		panel_1.add(cmbCurso);

		JComboBox cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "Tatuape", "Suzano", "Mogi" }));
		cmbCampus.setBounds(65, 36, 332, 22);
		panel_1.add(cmbCampus);

		JRadioButton chkMatutino = new JRadioButton("Matutino");
		buttonGroup.add(chkMatutino);
		chkMatutino.setBounds(76, 70, 109, 23);
		panel_1.add(chkMatutino);

		JRadioButton chkVespertino = new JRadioButton("Vespertino");
		buttonGroup.add(chkVespertino);
		chkVespertino.setBounds(190, 70, 109, 23);
		panel_1.add(chkVespertino);

		JRadioButton chkNoturno = new JRadioButton("Noturno");
		buttonGroup.add(chkNoturno);
		chkNoturno.setBounds(312, 70, 109, 23);
		panel_1.add(chkNoturno);

		JButton btnConsultar = new JButton("");

		btnConsultar.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\verificar.png"));
		btnConsultar.setBounds(184, 111, 77, 50);
		panel_1.add(btnConsultar);

		JButton btnAlterar = new JButton("");

		btnAlterar.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\mudanca.png"));
		btnAlterar.setBounds(97, 111, 77, 50);
		panel_1.add(btnAlterar);

		JButton btnSalvar = new JButton("");

		btnSalvar.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\download-direto.png"));
		btnSalvar.setBounds(10, 111, 77, 50);
		panel_1.add(btnSalvar);

		JButton btnSair = new JButton("");

		btnSair.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\sair.png"));
		btnSair.setBounds(358, 111, 77, 50);
		panel_1.add(btnSair);

		JButton btnLixeira = new JButton("");

		btnLixeira.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\lixo.png"));
		btnLixeira.setBounds(271, 111, 77, 50);
		panel_1.add(btnLixeira);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setBounds(10, 11, 48, 14);
		panel_2.add(lblRgm_1);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 76, 59, 14);
		panel_2.add(lblDisciplina);

		JLabel lblNewLabel = new JLabel("Semestre");
		lblNewLabel.setBounds(10, 101, 59, 14);
		panel_2.add(lblNewLabel);

		JLabel labon = new JLabel("Notas");
		labon.setBounds(153, 101, 48, 14);
		panel_2.add(labon);

		JLabel newlawbomtxt = new JLabel("Faltas");
		newlawbomtxt.setBounds(280, 101, 48, 14);
		panel_2.add(newlawbomtxt);

		txtRgm1 = new JTextField();
		txtRgm1.setBounds(68, 8, 135, 20);
		panel_2.add(txtRgm1);
		txtRgm1.setColumns(10);

		JComboBox cmbDisciplina1 = new JComboBox();
		cmbDisciplina1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Programa\u00E7\u00E3o orientada  a objetos", "Engenharia de Software", "Banco de dados"}));
		cmbDisciplina1.setBounds(68, 72, 333, 22);
		panel_2.add(cmbDisciplina1);

		JComboBox cmbSemestre1 = new JComboBox();
		cmbSemestre1.setModel(new DefaultComboBoxModel(new String[] { "2019-1", "2019-2", "2020-1", "" }));
		cmbSemestre1.setBounds(68, 97, 75, 22);
		panel_2.add(cmbSemestre1);

		JComboBox lblNotas1 = new JComboBox();
		lblNotas1.setModel(new DefaultComboBoxModel(new String[] { "0,0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0",
				"3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10" }));
		lblNotas1.setBounds(190, 97, 80, 22);
		panel_2.add(lblNotas1);

		txtFaltas1 = new JTextField();
		txtFaltas1.setBounds(326, 98, 75, 20);
		panel_2.add(txtFaltas1);
		txtFaltas1.setColumns(10);

		JLabel lblCursoNotas = new JLabel("");
		lblCursoNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCursoNotas.setBounds(68, 39, 367, 22);
		panel_2.add(lblCursoNotas);

		JLabel lblNomeNotas = new JLabel("");
		lblNomeNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNomeNotas.setBounds(213, 8, 222, 20);
		panel_2.add(lblNomeNotas);

		JButton btnSalvar1 = new JButton("");

		btnSalvar1.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\download-direto.png"));
		btnSalvar1.setBounds(10, 122, 77, 50);
		panel_2.add(btnSalvar1);

		JButton btnSelecionar2 = new JButton("");

		btnSelecionar2.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\mudanca.png"));
		btnSelecionar2.setBounds(98, 122, 77, 50);
		panel_2.add(btnSelecionar2);

		JButton btnConsultar1 = new JButton("");

		btnConsultar1.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\verificar.png"));
		btnConsultar1.setBounds(190, 122, 77, 50);
		panel_2.add(btnConsultar1);

		JButton btnApagar1 = new JButton("");

		btnApagar1.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\lixo.png"));
		btnApagar1.setBounds(277, 122, 77, 50);
		panel_2.add(btnApagar1);

		JButton btnSair1 = new JButton("");

		btnSair1.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\sair.png"));
		btnSair1.setBounds(358, 122, 77, 50);
		panel_2.add(btnSair1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblRgm_2 = new JLabel("RGM");
		lblRgm_2.setBounds(21, 14, 48, 14);
		panel_3.add(lblRgm_2);

		txtRgm2 = new JTextField();
		txtRgm2.setBounds(66, 8, 180, 20);
		panel_3.add(txtRgm2);
		txtRgm2.setColumns(10);

		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\verificar.png"));
		btnNewButton.setBounds(295, 11, 65, 49);
		panel_3.add(btnNewButton);

		txtListar = new TextArea();
		txtListar.setBounds(10, 66, 380, 105);
		panel_3.add(txtListar);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\padav\\Downloads\\educacao.png"));
		
		btnNewButton_1.setBounds(370, 11, 65, 48);
		panel_3.add(btnNewButton_1);

		lblNomeBoletim = new JLabel("");
		lblNomeBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNomeBoletim.setBounds(66, 30, 180, 20);
		panel_3.add(lblNomeBoletim);

		JLabel lblNome_1 = new JLabel("NOME");
		lblNome_1.setBounds(19, 36, 37, 14);
		panel_3.add(lblNome_1);

		//              **** METODOS DADOS PESSOAIS ****
		//             =====SALVAR====
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DadosPessoais a = new DadosPessoais();
				a.setRgm(Integer.parseInt(txtRgm.getText()));
				a.setNome(txtNome.getText());
				a.setDataNascimento(txtDataNascimento.getText());
				a.setCpf(txtCpf.getText());
				a.setEmail(txtEmail.getText());
				a.setEndereco(txtEnd.getText());
				a.setMunicipio(txtMunicipio.getText());
				a.setUf((String) cmbUf.getSelectedItem());
				a.setCelular(txtCel.getText());
				a.setCurso((String) cmbCurso.getSelectedItem());
				a.setCampus((String) cmbCampus.getSelectedItem());

				if (chkMatutino.isSelected()) {
					a.setPeriodo("M");
				}
				if (chkVespertino.isSelected()) {
					a.setPeriodo("V");
				}
				if (chkNoturno.isSelected()) {
					a.setPeriodo("N");
				}

				try {
					PessoasDAO dao = new PessoasDAO(); // abriu o bd
					dao.salvar(a);
					System.out.println("Sucesso");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});

		//                =====ALTERAR====

		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DadosPessoais a = new DadosPessoais();
				a.setRgm(Integer.parseInt(txtRgm.getText()));
				a.setNome(txtNome.getText());
				a.setDataNascimento(txtDataNascimento.getText());
				a.setCpf(txtCpf.getText());
				a.setEmail(txtEmail.getText());
				a.setEndereco(txtEnd.getText());
				a.setMunicipio(txtMunicipio.getText());
				a.setUf((String) cmbUf.getSelectedItem());
				a.setCelular(txtCel.getText());
				a.setCurso((String) cmbCurso.getSelectedItem());
				a.setCampus((String) cmbCampus.getSelectedItem());

				if (chkMatutino.isSelected()) {
					a.setPeriodo("M");
				}
				if (chkVespertino.isSelected()) {
					a.setPeriodo("V");
				}
				if (chkNoturno.isSelected()) {
					a.setPeriodo("N");
				}
				try {
					PessoasDAO dao = new PessoasDAO(); // abriu o bd
					dao.alterar(a);
					System.out.println("alterou o leitor");

				} catch (Exception e2) {

					System.out.println(e2.getMessage());
				}

			}
		});

		//              =====CONSULTAR=======

		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					PessoasDAO a = new PessoasDAO();
					int codigo = Integer.parseInt(txtRgm.getText());
					DadosPessoais pessoais = a.consultar(codigo);
					txtNome.setText(pessoais.getNome());
					txtDataNascimento.setText(pessoais.getDataNascimento());
					txtCpf.setText(pessoais.getCpf());
					txtEmail.setText(pessoais.getEmail());
					txtEnd.setText(pessoais.getEndereco());
					txtMunicipio.setText(pessoais.getMunicipio());

					String uf = pessoais.getUf();
					if (uf.equals("SP")) {
						cmbUf.setSelectedIndex(0);
					} else if (uf.equals("RJ")) {
						cmbUf.setSelectedIndex(1);
					} else {
						cmbUf.setSelectedIndex(2);
					}

					txtCel.setText(pessoais.getCelular());

					String curso = pessoais.getCurso();
					if (curso.equals("Analise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					} else if (curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					} else {
						cmbCurso.setSelectedIndex(3);
					}

					String campus = pessoais.getCampus();
					if (campus.equals("Tatuape")) {
						cmbCampus.setSelectedIndex(1);
					} else if (campus.equals("Suzano")) {
						cmbCampus.setSelectedIndex(2);
					}

					else {
						cmbCampus.setSelectedIndex(3);
					}

					String periodo = pessoais.getPeriodo();
					if (periodo.equals("M")) {
						chkMatutino.setSelected(true);
					}
					if (periodo.equals("V")) {
						chkVespertino.setSelected(true);
					}
					if (periodo.equals("N")) {
						chkNoturno.setSelected(true);
					}

				} catch (Exception e1) {
					System.out.println("Erro ao consultar");
					System.out.println(e1.getMessage());
				}
			}
		});

		//             ======EXLUIR=====

		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// abrir a conexão
					PessoasDAO a = new PessoasDAO();
					// excluir
					int codigo = Integer.parseInt(txtRgm.getText());
					a.excluir(codigo);
					System.out.println("Excluido com Sucesso!!");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});
	
		//                 ====SAIR=====

		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		//         ***** JBUTOON DADOS PESSOAIS ***** 
		//                ===== SALVAR ====

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DadosPessoais a = new DadosPessoais();
				a.setRgm(Integer.parseInt(txtRgm.getText()));
				a.setNome(txtNome.getText());
				a.setDataNascimento(txtDataNascimento.getText());
				a.setCpf(txtCpf.getText());
				a.setEmail(txtEmail.getText());
				a.setEndereco(txtEnd.getText());
				a.setMunicipio(txtMunicipio.getText());
				a.setUf((String) cmbUf.getSelectedItem());
				a.setCelular(txtCel.getText());
				a.setCurso((String) cmbCurso.getSelectedItem());
				a.setCampus((String) cmbCampus.getSelectedItem());

				if (chkMatutino.isSelected()) {
					a.setPeriodo("M");
				}
				if (chkVespertino.isSelected()) {
					a.setPeriodo("V");
				}
				if (chkNoturno.isSelected()) {
					a.setPeriodo("N");
				}

				try {
					PessoasDAO dao = new PessoasDAO(); // abriu o bd
					dao.salvar(a);
					System.out.println("Sucesso");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});

		//             ======ALTERAR=======

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DadosPessoais a = new DadosPessoais();
				a.setRgm(Integer.parseInt(txtRgm.getText()));
				a.setNome(txtNome.getText());
				a.setDataNascimento(txtDataNascimento.getText());
				a.setCpf(txtCpf.getText());
				a.setEmail(txtEmail.getText());
				a.setEndereco(txtEnd.getText());
				a.setMunicipio(txtMunicipio.getText());
				a.setUf((String) cmbUf.getSelectedItem());
				a.setCelular(txtCel.getText());
				a.setCurso((String) cmbCurso.getSelectedItem());
				a.setCampus((String) cmbCampus.getSelectedItem());

				if (chkMatutino.isSelected()) {
					a.setPeriodo("M");
				}
				if (chkVespertino.isSelected()) {
					a.setPeriodo("V");
				}
				if (chkNoturno.isSelected()) {
					a.setPeriodo("N");
				}
				try {
					PessoasDAO dao = new PessoasDAO(); // abriu o bd
					dao.alterar(a);
					System.out.println("alterou o leitor");

				} catch (Exception e2) {

					System.out.println(e2.getMessage());
				}

			}
		});

		//           ====== CONSULTAR =====

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					PessoasDAO a = new PessoasDAO();
					int codigo = Integer.parseInt(txtRgm.getText());
					DadosPessoais pessoais = a.consultar(codigo);
					txtNome.setText(pessoais.getNome());
					txtDataNascimento.setText(pessoais.getDataNascimento());
					txtCpf.setText(pessoais.getCpf());
					txtEmail.setText(pessoais.getEmail());
					txtEnd.setText(pessoais.getEndereco());
					txtMunicipio.setText(pessoais.getMunicipio());

					String uf = pessoais.getUf();
					if (uf.equals("SP")) {
						cmbUf.setSelectedIndex(0);
					} else if (uf.equals("RJ")) {
						cmbUf.setSelectedIndex(1);
					} else {
						cmbUf.setSelectedIndex(2);
					}

					txtCel.setText(pessoais.getCelular());

					String curso = pessoais.getCurso();
					if (curso.equals("Analise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					} else if (curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					} else {
						cmbCurso.setSelectedIndex(3);
					}

					String campus = pessoais.getCampus();
					if (campus.equals("Tatuape")) {
						cmbCampus.setSelectedIndex(1);
					} else if (campus.equals("Suzano")) {
						cmbCampus.setSelectedIndex(2);
					}

					else {
						cmbCampus.setSelectedIndex(3);
					}

					String periodo = pessoais.getPeriodo();
					if (periodo.equals("M")) {
						chkMatutino.setSelected(true);
					}
					if (periodo.equals("V")) {
						chkVespertino.setSelected(true);
					}
					if (periodo.equals("N")) {
						chkNoturno.setSelected(true);
					}

				} catch (Exception e1) {
					System.out.println("Erro ao consultar");
					System.out.println(e1.getMessage());
				}

			}
		});

		//             ======EXCLUIR========

		btnLixeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// abrir a conexão
					PessoasDAO a = new PessoasDAO();
					// excluir
					int codigo = Integer.parseInt(txtRgm.getText());
					a.excluir(codigo);
					System.out.println("Excluido com Sucesso!!");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});

		//         =====SAIR=====

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

				
			}
		});
		// ============================================
		
		
		// MÉTODO JMENU NOTAS E FALTA
		//        ======SALVAR=====

		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NotasFaltas a = new NotasFaltas();

				a.setRgm1(Integer.parseInt(txtRgm1.getText()));
				a.setSemestre1((String) cmbSemestre1.getSelectedItem());
				a.setDisciplina1((String) cmbDisciplina1.getSelectedItem());
				a.setNota1((String) lblNotas1.getSelectedItem());
				a.setFaltas1(txtFaltas1.getText());

				try {

					NotaEFalta dao = new NotaEFalta(); // abriu o bd
					dao.salvar(a);
					System.out.println("Inseriu o leitor: ");

				} catch (Exception ee) {
					System.out.println("Erro ao inserir o leitor: ");

					System.out.println(ee.getMessage());
				}

			}
		});

		//           =======ALTERAR======

		mntmAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NotasFaltas a = new NotasFaltas();

				a.setRgm1(Integer.parseInt(txtRgm1.getText()));
				a.setSemestre1((String) cmbSemestre1.getSelectedItem());
				a.setDisciplina1((String) cmbDisciplina1.getSelectedItem());
				a.setNota1((String) lblNotas1.getSelectedItem());
				a.setFaltas1(txtFaltas1.getText());

				try {
					NotaEFalta dao = new NotaEFalta(); // abriu o bd
					dao.alterar(a);
					System.out.println("alterou o leitor");

				} catch (Exception e2) {

					System.out.println(e2.getMessage());
				}

			}
		});

		//         ======CONSULTAR======
		
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					PessoasDAO dao = new PessoasDAO();
					int rgm1 = Integer.parseInt(txtRgm1.getText());
					DadosPessoais pessoais = dao.consultar(rgm1);
					lblNomeNotas.setText(pessoais.getNome());

					String curso = pessoais.getCurso();
					
					lblCursoNotas.setText(curso);

				} catch (Exception e1) {

				}

				// =========================================================

				try {

					NotaEFalta a = new NotaEFalta();
					int codigo = Integer.parseInt(txtRgm1.getText());
					NotasFaltas c = a.consultar(codigo);

					String disciplina = c.getDisciplina1();
					
					if (disciplina.equals("Programação orientada  a objetos")) {
						cmbDisciplina1.setSelectedIndex(1);
					} else if (disciplina.equals("Engenharia de Software")) {
						cmbDisciplina1.setSelectedIndex(2);
					} else {
						cmbDisciplina1.setSelectedIndex(3);
					}

					String semestre = c.getSemestre1();
					if (semestre.equals("2019-1")) {
						cmbSemestre1.setSelectedIndex(0);
					} else if (semestre.equals("2019-2")) {
						cmbSemestre1.setSelectedIndex(1);
					} else if (semestre.equals("2020-1")) {
						cmbSemestre1.setSelectedIndex(2);
					} else {
						cmbSemestre1.setSelectedIndex(3);
					}

					String nota = c.getNota1();
					if (nota.equals("0,0")) {
						lblNotas1.setSelectedIndex(0);
					}
					if (nota.equals("0,5")) {
						lblNotas1.setSelectedIndex(1);
					} else if (nota.equals("1,0")) {
						lblNotas1.setSelectedIndex(2);
					} else if (nota.equals("1,5")) {
						lblNotas1.setSelectedIndex(3);
					} else if (nota.equals("2,0")) {
						lblNotas1.setSelectedIndex(4);
					} else if (nota.equals("2,5")) {
						lblNotas1.setSelectedIndex(5);
					} else if (nota.equals("3,0")) {
						lblNotas1.setSelectedIndex(6);
					} else if (nota.equals("3,5")) {
						lblNotas1.setSelectedIndex(7);
					} else if (nota.equals("4,0")) {
						lblNotas1.setSelectedIndex(8);
					} else if (nota.equals("4,5")) {
						lblNotas1.setSelectedIndex(9);
					} else if (nota.equals("5,0")) {
						lblNotas1.setSelectedIndex(10);
					} else if (nota.equals("5,5")) {
						lblNotas1.setSelectedIndex(11);
					} else if (nota.equals("6,0")) {
						lblNotas1.setSelectedIndex(12);
					} else if (nota.equals("6.5")) {
						lblNotas1.setSelectedIndex(13);
					} else if (nota.equals("7,0")) {
						lblNotas1.setSelectedIndex(14);
					} else if (nota.equals("7,5")) {
						lblNotas1.setSelectedIndex(15);
					} else if (nota.equals("8,0")) {
						lblNotas1.setSelectedIndex(16);
					} else if (nota.equals("8,5")) {
						lblNotas1.setSelectedIndex(17);
					} else if (nota.equals("9,0")) {
						lblNotas1.setSelectedIndex(18);
					} else if (nota.equals("9,5")) {
						lblNotas1.setSelectedIndex(19);
					} else {
						lblNotas1.setSelectedIndex(20);
					}

					txtFaltas1.setText(c.getFaltas1());

				} catch (Exception e1) {
					System.out.println("Erro ao consultar");
					System.out.println(e1.getMessage());
				}

			}
		});

		//          ======EXCLUIR====

		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// abrir a conexão
					NotaEFalta a = new NotaEFalta();
					// excluir
					int codigo = Integer.parseInt(txtRgm1.getText());
					a.excluir(codigo);
					System.out.println("Excluido com Sucesso!!");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});
		//       =====SAIR====

		mntmSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		// ============================================

		//   ======JBUTOON NOTAS E FALTAS =====

		//          ====SALVAR ====
		btnSalvar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NotasFaltas a = new NotasFaltas();

				a.setRgm1(Integer.parseInt(txtRgm1.getText()));
				a.setSemestre1((String) cmbSemestre1.getSelectedItem());
				a.setDisciplina1((String) cmbDisciplina1.getSelectedItem());
				a.setNota1((String) lblNotas1.getSelectedItem());
				a.setFaltas1(txtFaltas1.getText());

				try {

					NotaEFalta dao = new NotaEFalta(); // abriu o bd
					dao.salvar(a);
					System.out.println("Inseriu o leitor: ");

				} catch (Exception ee) {
					System.out.println("Erro ao inserir o leitor: ");

					System.out.println(ee.getMessage());
				}

			}
		});

		//               =====ALTERAR====

		btnSelecionar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NotasFaltas a = new NotasFaltas();

				a.setRgm1(Integer.parseInt(txtRgm1.getText()));
				a.setSemestre1((String) cmbSemestre1.getSelectedItem());
				a.setDisciplina1((String) cmbDisciplina1.getSelectedItem());
				a.setNota1((String) lblNotas1.getSelectedItem());
				a.setFaltas1(txtFaltas1.getText());

				try {
					NotaEFalta dao = new NotaEFalta(); // abriu o bd
					dao.alterar(a);
					System.out.println("alterou o leitor");

				} catch (Exception e2) {

					System.out.println(e2.getMessage());
				}

			}
		});

		//                ====CONSULTAR====

		btnConsultar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					PessoasDAO dao = new PessoasDAO();
					int rgm1 = Integer.parseInt(txtRgm1.getText());
					DadosPessoais pessoais = dao.consultar(rgm1);
					lblNomeNotas.setText(pessoais.getNome());

					String curso = pessoais.getCurso();
				

					lblCursoNotas.setText(curso);

				} catch (Exception e1) {

				}

				// =========================================================

				try {

					NotaEFalta a = new NotaEFalta();
					int codigo = Integer.parseInt(txtRgm1.getText());
					NotasFaltas c = a.consultar(codigo);

					String disciplina = c.getDisciplina1();
				
					if (disciplina.equals("Programação orientada  a objetos")) {
						cmbDisciplina1.setSelectedIndex(1);
					} else if (disciplina.equals("Engenharia de Software")) {
						cmbDisciplina1.setSelectedIndex(2);
					} else {
						cmbDisciplina1.setSelectedIndex(3);
					}

					String semestre = c.getSemestre1();
					if (semestre.equals("2019-1")) {
						cmbSemestre1.setSelectedIndex(0);
					} else if (semestre.equals("2019-2")) {
						cmbSemestre1.setSelectedIndex(1);
					} else if (semestre.equals("2020-1")) {
						cmbSemestre1.setSelectedIndex(2);
					} else {
						cmbSemestre1.setSelectedIndex(3);
					}

					String nota = c.getNota1();
					if (nota.equals("0,0")) {
						lblNotas1.setSelectedIndex(0);
					}
					if (nota.equals("0,5")) {
						lblNotas1.setSelectedIndex(1);
					} else if (nota.equals("1,0")) {
						lblNotas1.setSelectedIndex(2);
					} else if (nota.equals("1,5")) {
						lblNotas1.setSelectedIndex(3);
					} else if (nota.equals("2,0")) {
						lblNotas1.setSelectedIndex(4);
					} else if (nota.equals("2,5")) {
						lblNotas1.setSelectedIndex(5);
					} else if (nota.equals("3,0")) {
						lblNotas1.setSelectedIndex(6);
					} else if (nota.equals("3,5")) {
						lblNotas1.setSelectedIndex(7);
					} else if (nota.equals("4,0")) {
						lblNotas1.setSelectedIndex(8);
					} else if (nota.equals("4,5")) {
						lblNotas1.setSelectedIndex(9);
					} else if (nota.equals("5,0")) {
						lblNotas1.setSelectedIndex(10);
					} else if (nota.equals("5,5")) {
						lblNotas1.setSelectedIndex(11);
					} else if (nota.equals("6,0")) {
						lblNotas1.setSelectedIndex(12);
					} else if (nota.equals("6.5")) {
						lblNotas1.setSelectedIndex(13);
					} else if (nota.equals("7,0")) {
						lblNotas1.setSelectedIndex(14);
					} else if (nota.equals("7,5")) {
						lblNotas1.setSelectedIndex(15);
					} else if (nota.equals("8,0")) {
						lblNotas1.setSelectedIndex(16);
					} else if (nota.equals("8,5")) {
						lblNotas1.setSelectedIndex(17);
					} else if (nota.equals("9,0")) {
						lblNotas1.setSelectedIndex(18);
					} else if (nota.equals("9,5")) {
						lblNotas1.setSelectedIndex(19);
					} else {
						lblNotas1.setSelectedIndex(20);
					}

					txtFaltas1.setText(c.getFaltas1());

				} catch (Exception e1) {
					System.out.println("Erro ao consultar");
					System.out.println(e1.getMessage());
				}

			}
		});

		//         =====EXCLUIR====

		btnApagar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// abrir a conexão
					NotaEFalta a = new NotaEFalta();
					// excluir
					int codigo = Integer.parseInt(txtRgm1.getText());
					a.excluir(codigo);
					System.out.println("Excluido com Sucesso!!");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});

		//        ===== SAIR ====

		btnSair1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		// =========================================
	
	   //           **** BOLETIM***
		//			=== CONSULTAR BOLETIM ===
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				try {

					PessoasDAO dao = new PessoasDAO();
					int rgm = Integer.parseInt(txtRgm2.getText());
					DadosPessoais pessoais = dao.consultar(rgm);
					// txtListar.setText(pessoais.getNome());
					lblNomeBoletim.setText(pessoais.getNome());

					String curso = pessoais.getCurso() + "\n";
					if (curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(0);
					} else if (curso.equals("Direito")) {
						cmbCurso.setSelectedIndex(1);
					} else if (curso.equals("Engenharia de dados")) {
						cmbCurso.setSelectedIndex(2);
					}
					txtListar.setText(curso);
				} catch (Exception e1) {
					txtListar.setText("Erro ao Consultar" + "\n");
				}

				// ==================================================================

				try {

					List<NotasFaltas> lista = new ArrayList<NotasFaltas>();
					NotaEFalta daoNotas = new NotaEFalta();
					int rgm = Integer.parseInt(txtRgm2.getText());
					lista = daoNotas.listarNotas(rgm);
					for (NotasFaltas aluno : lista) {

						txtListar.append((String) "Disciplina =  " + aluno.getDisciplina1() + "\n");
						txtListar.append((String) "Notas = " + aluno.getNota1() + "\n");
						txtListar.append((String) "Faltas = " + aluno.getFaltas1() + "\n\n");

					}
				}

				catch (Exception e3) {
					System.out.println(e3.getMessage());
				}

				

			}

		});

				// ====LIMPAR BOLETIN ===
	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				txtRgm2.setText(null);
				txtListar.setText(null);
				lblNomeBoletim.setText(null);

				
			}
		});
	
		// =========================
	
	
	}
}
