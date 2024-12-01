package br.com.felipedevbino.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.felipedevbino.gui.funcoesgui.Interacao;
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
		frame.setName("Sistema de Orçamentos");
		frame.setBounds(100, 100, 1213, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 1207, 707);
		panel.setBackground(new Color(135, 135, 135));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSistemaDeOrcamentos = new JLabel("SISTEMA DE ORÇAMENTOS");
		lblSistemaDeOrcamentos.setBounds(303, -2, 605, 48);
		lblSistemaDeOrcamentos.setFont(new Font("Arial Black", Font.PLAIN, 39));
		lblSistemaDeOrcamentos.setForeground(Color.WHITE);
		panel.add(lblSistemaDeOrcamentos);

		JScrollPane telaInterativa = new JScrollPane();
		telaInterativa.setBounds(303, 78, 588, 337);
		panel.add(telaInterativa);

		JButton botaoAtualizar = new JButton("ATUALIZAR");
		botaoAtualizar.setBounds(303, 426, 588, 41);
		botaoAtualizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAtualizar);

		JLabel infoAutor = new JLabel("@felipeDevBino / felipereisbino@gmail.com / (41) 99874-4825");
		infoAutor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		infoAutor.setBounds(331, 52, 655, 15);
		infoAutor.setForeground(Color.WHITE);
		panel.add(infoAutor);

		JLabel iconeProgresso = new JLabel("");
		iconeProgresso.setBounds(32, 537, 121, 120);
		panel.add(iconeProgresso);

		JLabel iconeDificuldade = new JLabel("");
		iconeDificuldade.setBounds(157, 537, 119, 120);
		panel.add(iconeDificuldade);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(32, 11, 244, 41);
		botaoVoltar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoVoltar);

		JButton botaoEditar = new JButton("EDITAR");
		botaoEditar.setBounds(303, 478, 139, 50);
		botaoEditar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEditar);

		JButton botaoPreVisualizar = new JButton("PRÉ-VISUALIZAR");
		botaoPreVisualizar.setBounds(529, 478, 139, 50);
		botaoPreVisualizar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		panel.add(botaoPreVisualizar);

		JButton botaoConfigurar = new JButton("CONFIGURAR ");
		botaoConfigurar.setBounds(752, 478, 139, 50);
		botaoConfigurar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoConfigurar);

		JButton botaoSalvar = new JButton("SALVAR");
		botaoSalvar.setBounds(32, 461, 244, 65);
		botaoSalvar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoSalvar);

		JLabel iconeOrcamentos = new JLabel("");
		iconeOrcamentos.setBounds(926, 11, 237, 47);
		panel.add(iconeOrcamentos);

		JButton botaoEstimativa = new JButton("ESTIMATIVA");
		botaoEstimativa.setBounds(32, 385, 244, 65);
		botaoEstimativa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEstimativa);

		JButton botaoAddMateriais = new JButton("ADICIONAR MATERIAIS");
		botaoAddMateriais.setBounds(32, 308, 244, 65);
		botaoAddMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarMateriais.adicionarMaterialAoOrcamento();
			}
		});
		botaoAddMateriais.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddMateriais);

		JButton botaoAddEmpecilho = new JButton("ADICIONAR EMPECILHO");
		botaoAddEmpecilho.setBounds(32, 232, 244, 65);
		botaoAddEmpecilho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarEmpecilho.adicionarEmpecilhoAoOrcamento();
			}
		});
		botaoAddEmpecilho.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddEmpecilho);

		JButton botaoAddParte = new JButton("ADICIONAR PARTE");
		botaoAddParte.setBounds(32, 156, 244, 65);
		botaoAddParte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarParte.adicionarParteAQualquerEtapa();
			}
		});
		botaoAddParte.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddParte);

		JButton botaoAddEtapa = new JButton("ADICIONAR ETAPA");
		botaoAddEtapa.setBounds(32, 80, 244, 65);
		botaoAddEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarEtapa.adicionarEtapaAoOrcamento();
			}
		});
		botaoAddEtapa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoAddEtapa);

		JButton botaoEstilo = new JButton("ESTILO DE FORMATAÇÃO");
		botaoEstilo.setBounds(926, 366, 244, 65);
		botaoEstilo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoEstilo);

		JButton botaoEmitirArquivo = new JButton("EMITIR ARQUIVO");
		botaoEmitirArquivo.setBounds(926, 270, 244, 65);
		botaoEmitirArquivo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoEmitirArquivo);

		JButton botaoResetar = new JButton("RESETAR ORÇAMENTO");
		botaoResetar.setBounds(926, 177, 244, 65);
		botaoResetar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(botaoResetar);

		JButton botaoMudarNomeArq = new JButton("MUDAR NOME DO ARQUIVO");
		botaoMudarNomeArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		botaoMudarNomeArq.setBounds(926, 80, 244, 65);
		botaoMudarNomeArq.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoMudarNomeArq);

		JButton botaoProgresso = new JButton("MOSTRAR PROGRESSO");
		botaoProgresso.setBounds(926, 463, 244, 65);
		botaoProgresso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel.add(botaoProgresso);

		JLabel informacoes = new JLabel("");
		informacoes.setBounds(303, 553, 588, 98);
		panel.add(informacoes);

		ImageIcon icon = new ImageIcon(SistemaDeOrcamentos.class.getResource("/resources/background.png"));
		JLabel planoDeFundo = new JLabel(icon);
		planoDeFundo.setBounds(0, 0, 1207, 707);
		panel.add(planoDeFundo);
		
	}
}
