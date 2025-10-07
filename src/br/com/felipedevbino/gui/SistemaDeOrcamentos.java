package br.com.felipedevbino.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.felipedevbino.arquivos.Arquivo;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloPartes;
import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.gui.painelinterativo.DadosNoPainel;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicadados.empecilhos.AdicionarEmpecilho;
import br.com.felipedevbino.logicadados.empecilhos.BuscarEmpecilho;
import br.com.felipedevbino.logicadados.etapas.AdicionarEtapa;
import br.com.felipedevbino.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicadados.materiais.AdicionarMaterial;
import br.com.felipedevbino.logicadados.materiais.BuscarMaterial;
import br.com.felipedevbino.logicadados.partes.AdicionarParte;
import br.com.felipedevbino.logicadados.partes.BuscarParte;

public class SistemaDeOrcamentos {

	private JFrame frame;
	private JPanel panel;
	private Interacao interacao;
	private DadosNoPainel dadosNoPainel;
	private CaixaDeEscolha escolha;
	private BuscarEtapa buscarEtapas;
	private BuscarEmpecilho buscarEmpecilho;
	private BuscarMaterial buscarMateriais;
	private AdicionarEtapa adicionarEtapa;
	private AdicionarParte adicionarParte;
	private AdicionarEmpecilho adicionarEmpecilho;
	private AdicionarMaterial adicionarMateriais;
	private JPanel telaInterativa;

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
		frame.setBounds(100, 100, 1202, 670);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setAlwaysOnTop(true);

		panel = new JPanel();
		panel.setBounds(-1, -11, 1500, 1580);
		panel.setBackground(new Color(135, 135, 135));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// CRIANDO SCROLL PANE PRINCIPAL
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 122, 588, 336);
		panel.add(scrollPane);

		// DEFININDO O PAINÉL DE DADOS DA JANELA INTERATIVA
		telaInterativa = new JPanel();
		telaInterativa.setLayout(new BoxLayout(telaInterativa, BoxLayout.Y_AXIS));
		telaInterativa.setAlignmentX(Component.CENTER_ALIGNMENT);
		telaInterativa.setPreferredSize(new Dimension(600, Integer.MAX_VALUE));

		dadosNoPainel = new DadosNoPainel(telaInterativa);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setViewportView(telaInterativa);

		// ATUALIZANDO A SCROLL PANE
		scrollPane.revalidate();
		scrollPane.repaint();

		JLabel lblSistemaDeOrcamentos = new JLabel("SISTEMA DE ORÇAMENTOS");
		lblSistemaDeOrcamentos.setBounds(301, 10, 605, 48);
		lblSistemaDeOrcamentos.setFont(new Font("Arial Black", Font.PLAIN, 39));
		lblSistemaDeOrcamentos.setForeground(Color.WHITE);
		panel.add(lblSistemaDeOrcamentos);

		JButton botaoAtualizar = new JButton("ATUALIZAR");
		botaoAtualizar.setBounds(301, 463, 588, 48);
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);
				
				if (!buscarEtapas.seNaoHaEtapas() || !buscarMateriais.seNaoHaMateriais()
						|| !buscarEmpecilho.seNaoHaEmpecilhos()) {
					dadosNoPainel.addEtapas();
					dadosNoPainel.addMateriais();
					dadosNoPainel.addEmpecilhos();
				} else {
					interacao.mostrarMensagemDeErro(
							"VOCÊ AINDA NÃO INSERIU NENHUM DADO PARA QUE POSSA SER EXIBIDO NO PAINEL!");
				}

				telaInterativa.revalidate();
				telaInterativa.repaint();

				frame.setAlwaysOnTop(true);
			}
		});
		botaoAtualizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAtualizar);

		JLabel infoAutor = new JLabel("@felipeDevBino / felipereisbino@gmail.com / (41) 99874-4825");
		infoAutor.setBounds(329, 50, 655, 15);
		infoAutor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		infoAutor.setForeground(Color.WHITE);
		panel.add(infoAutor);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(30, 31, 244, 65);
		botaoVoltar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoVoltar);

		JButton botaoPreVisualizar = new JButton("PRÉ-VISUALIZAR");
		botaoPreVisualizar.setBounds(301, 522, 276, 77);
		botaoPreVisualizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoPreVisualizar);

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

				if (!buscarMateriais.seNaoHaMateriais()) {
					botaoAtualizar.doClick();
				}

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
				
				if(!buscarEmpecilho.seNaoHaEmpecilhos()) {
					botaoAtualizar.doClick();
				}
				
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
				
				if(adicionarParte.adicionarParteAQualquerEtapa()) {
					botaoAtualizar.doClick();
				}
				
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

				if (!buscarEtapas.seNaoHaEtapas()) {
					botaoAtualizar.doClick();
				}

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

		JButton btnConfigurar = new JButton("CONFIGURAR");
		btnConfigurar.setBounds(613, 522, 276, 77);
		btnConfigurar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(btnConfigurar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(301, 69, 588, 48);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setAlwaysOnTop(false);

				if (telaInterativa.getComponentCount() == 0) {
					interacao.mostrarMensagemDeErro("NÃO HÁ NENHUM DADO NO PAINEL PARA SER REMOVIDO!");
				}

				telaInterativa.removeAll();
				telaInterativa.revalidate();
				telaInterativa.repaint();

				frame.setAlwaysOnTop(true);
			}
		});
		btnLimpar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(btnLimpar);

		ImageIcon icon = new ImageIcon(SistemaDeOrcamentos.class.getResource("/resources/background.png"));
		JLabel planoDeFundo = new JLabel(icon);
		planoDeFundo.setBounds(-137, -62, 1499, 707);
		panel.add(planoDeFundo);

	}

	private void seDesejaEncerrar() {

		if (escolha.confirmarOuNegarDados("SIM", "NÃO", "VOCÊ REALMENTE DESEJA ENCERRAR O PROGRAMA?")) {
			System.exit(0);
		}

	}

	public JPanel getTelaInterativa() {
		return telaInterativa;
	}

}
