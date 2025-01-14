package br.com.felipedevbino.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.gui.funcoesgui.LogicaPainel;
import br.com.felipedevbino.logicaexecucao.logicadados.empecilhos.AdicionarEmpecilho;
import br.com.felipedevbino.logicaexecucao.logicadados.empecilhos.BuscarEmpecilho;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.AdicionarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.materiais.AdicionarMaterial;
import br.com.felipedevbino.logicaexecucao.logicadados.materiais.BuscarMaterial;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.AdicionarParte;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class SistemaDeOrcamentos {

	private JFrame frame;
	private JPanel panel;
	private Interacao interacao;
	private LogicaPainel logicaPainel;
	private CaixaDeEscolha escolha;
	private BuscarEtapa buscarEtapas;
	private BuscarParte buscarPartes;
	private BuscarEmpecilho buscarEmpecilho;
	private BuscarMaterial buscarMateriais;
	private AdicionarEtapa adicionarEtapa;
	private AdicionarParte adicionarParte;
	private AdicionarEmpecilho adicionarEmpecilho;
	private AdicionarMaterial adicionarMateriais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// Nimbus LookAndFeel
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (javax.swing.UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDeOrcamentos window = new SistemaDeOrcamentos();
					window.frame.setResizable(false);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SistemaDeOrcamentos() {
		initialize();
	}

	private void inicializarInstancias() {
		interacao = new Interacao();
		escolha = new CaixaDeEscolha();
		buscarEtapas = new BuscarEtapa();
		buscarPartes = new BuscarParte();
		buscarEmpecilho = new BuscarEmpecilho();
		buscarMateriais = new BuscarMaterial();
		adicionarEtapa = new AdicionarEtapa();
		adicionarParte = new AdicionarParte();
		adicionarEmpecilho = new AdicionarEmpecilho();
		adicionarMateriais = new AdicionarMaterial();
	}

	public JFrame getJFrame() {
		return frame;
	}

	public JPanel getJPanel() {
		return panel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		inicializarInstancias();

		frame = new JFrame();
		frame.setTitle("Sistema de Orçamentos");
		frame.setBounds(100, 100, 1202, 632);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);

		panel = new JPanel();
		panel.setBounds(0, 0, 1500, 1580);
		panel.setBackground(new Color(135, 135, 135));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSistemaDeOrcamentos = new JLabel("SISTEMA DE ORÇAMENTOS");
		lblSistemaDeOrcamentos.setBounds(301, 42, 605, 48);
		lblSistemaDeOrcamentos.setFont(new Font("Arial Black", Font.PLAIN, 39));
		lblSistemaDeOrcamentos.setForeground(Color.WHITE);
		panel.add(lblSistemaDeOrcamentos);

		JScrollPane telaInterativa = new JScrollPane();

		JPanel painelDeDados = new JPanel(); // < - PAINEL DE DADOS QUE SERÁ EXIBIDO NA JSCROLL PANE
												// REALIZANDO ATUALIZAÇÕES NA EXIBIÇÃO A MEDIDA QUE
												// O USUÁRIO USA O SISTEMA, ATUALIZANDO, REMOVENDO
												// OU CRIANDO DADOS.
		painelDeDados.setLayout(null);
		logicaPainel = new LogicaPainel(painelDeDados);

		telaInterativa.setBounds(301, 122, 588, 337);
		telaInterativa.setViewportView(painelDeDados);
		telaInterativa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		telaInterativa.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(telaInterativa);

		JButton botaoAtualizar = new JButton("ATUALIZAR");
		botaoAtualizar.setBounds(301, 470, 588, 41);
		botaoAtualizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAtualizar);

		JLabel infoAutor = new JLabel("@felipeDevBino / felipereisbino@gmail.com / (41) 99874-4825");
		infoAutor.setBounds(329, 96, 655, 15);
		infoAutor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		infoAutor.setForeground(Color.WHITE);
		panel.add(infoAutor);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(30, 31, 244, 65);
		botaoVoltar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoVoltar);

		JButton botaoEditar = new JButton("EDITAR");
		botaoEditar.setBounds(301, 522, 139, 50);
		botaoEditar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEditar);

		JButton botaoPreVisualizar = new JButton("PRÉ-VISUALIZAR");
		botaoPreVisualizar.setBounds(527, 522, 139, 50);
		botaoPreVisualizar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		panel.add(botaoPreVisualizar);

		JButton botaoConfigurar = new JButton("CONFIGURAR ");
		botaoConfigurar.setBounds(750, 522, 139, 50);
		botaoConfigurar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoConfigurar);

		JButton botaoSalvar = new JButton("SALVAR");
		botaoSalvar.setBounds(30, 505, 244, 65);
		botaoSalvar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoSalvar);

		JButton botaoEstimativa = new JButton("ESTIMATIVA");
		botaoEstimativa.setBounds(30, 429, 244, 65);
		botaoEstimativa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEstimativa);

		JButton botaoAddMateriais = new JButton("ADICIONAR MATERIAIS");
		botaoAddMateriais.setBounds(30, 352, 244, 65);
		botaoAddMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				adicionarMateriais.adicionarMaterialAoOrcamento();
				// ATUALIZAR PAINEL
				frame.setAlwaysOnTop(true);
			}
		});
		botaoAddMateriais.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddMateriais);

		JButton botaoAddEmpecilho = new JButton("ADICIONAR EMPECILHO");
		botaoAddEmpecilho.setBounds(30, 276, 244, 65);
		botaoAddEmpecilho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				adicionarEmpecilho.adicionarEmpecilhoAoOrcamento();
				// ATUALIZAR PAINEL
				frame.setAlwaysOnTop(true);
			}
		});
		botaoAddEmpecilho.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddEmpecilho);

		JButton botaoAddParte = new JButton("ADICIONAR PARTE");
		botaoAddParte.setBounds(30, 200, 244, 65);
		botaoAddParte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				adicionarParte.adicionarParteAQualquerEtapa();
				//logicaPainel.adicionarNoPainel();
				telaInterativa.repaint();
				telaInterativa.revalidate();
				// ATUALIZAR PAINEL
				frame.setAlwaysOnTop(true);
			}
		});
		botaoAddParte.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddParte);

		JButton botaoAddEtapa = new JButton("ADICIONAR ETAPA");
		botaoAddEtapa.setBounds(30, 122, 244, 65);
		botaoAddEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				adicionarEtapa.adicionarEtapaAoOrcamento();
				//logicaPainel.adicionarNoPainel();
				telaInterativa.repaint();
				telaInterativa.revalidate();
				// ATUALIZAR PAINEL
				frame.setAlwaysOnTop(true);
			}
		});
		botaoAddEtapa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddEtapa);

		JButton botaoEstilo = new JButton("ESTILO DE FORMATAÇÃO");
		botaoEstilo.setBounds(924, 410, 244, 65);
		botaoEstilo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoEstilo);

		JButton botaoEmitirArquivo = new JButton("EMITIR ARQUIVO");
		botaoEmitirArquivo.setBounds(924, 314, 244, 65);
		botaoEmitirArquivo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEmitirArquivo);

		JButton botaoResetar = new JButton("RESETAR ORÇAMENTO");
		botaoResetar.setBounds(924, 221, 244, 65);
		botaoResetar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoResetar);

		JButton botaoMudarNomeArq = new JButton("MUDAR NOME DO ARQUIVO");
		botaoMudarNomeArq.setBounds(924, 124, 244, 65);
		botaoMudarNomeArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		botaoMudarNomeArq.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoMudarNomeArq);

		JButton botaoProgresso = new JButton("MOSTRAR PROGRESSO");
		botaoProgresso.setBounds(924, 506, 244, 65);
		botaoProgresso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoProgresso);

		JButton btnTerminar = new JButton("TERMINAR");
		btnTerminar.setBounds(916, 31, 252, 65);
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				seDesejaEncerrar();
				if (frame.isVisible()) {
					frame.setAlwaysOnTop(true);
				}
				return;
			}
		});
		btnTerminar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(btnTerminar);

		ImageIcon icon = new ImageIcon(SistemaDeOrcamentos.class.getResource("/resources/background.png"));
		JLabel planoDeFundo = new JLabel(icon);
		planoDeFundo.setBounds(-140, 0, 1499, 707);
		panel.add(planoDeFundo);

	}

	private void seDesejaEncerrar() {
		if (escolha.confirmarOuNegarDados("SIM", "NÃO", "VOCÊ REALMENTE DESEJA ENCERRAR O PROGRAMA?")) {
			System.exit(0);
		}
	}
}
