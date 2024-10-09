package br.com.felipedevbino.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class SistemaDeOrcamentos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Nimbus LookAndFeel
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setName("Sistema de Orçamentos");
		frame.setBounds(100, 100, 1213, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 1207, 707);
		panel.setBackground(new Color(135, 135, 135));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSistemaDeOrcamentos = new JLabel("SISTEMA DE ORÇAMENTOS");
		lblSistemaDeOrcamentos.setFont(new Font("Arial Black", Font.PLAIN, 39));
		lblSistemaDeOrcamentos.setBounds(311, 11, 605, 48);
		lblSistemaDeOrcamentos.setForeground(Color.WHITE);
		panel.add(lblSistemaDeOrcamentos);

		JScrollPane telaInterativa = new JScrollPane();
		telaInterativa.setBounds(303, 78, 588, 337);
		panel.add(telaInterativa);

		JButton botaoAtualizar = new JButton("ATUALIZAR");
		botaoAtualizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAtualizar.setBounds(303, 426, 588, 41);
		panel.add(botaoAtualizar);

		JLabel infoAutor = new JLabel("@felipeDevBino / felipereisbino@gmail.com / 41998738614");
		infoAutor.setBounds(900, 682, 287, 14);
		infoAutor.setForeground(Color.WHITE);
		panel.add(infoAutor);

		JLabel iconeProgresso = new JLabel("");
		iconeProgresso.setBounds(32, 537, 121, 120);
		panel.add(iconeProgresso);

		JLabel iconeDificuldade = new JLabel("");
		iconeDificuldade.setBounds(157, 537, 119, 120);
		panel.add(iconeDificuldade);

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoVoltar.setBounds(32, 11, 244, 41);
		panel.add(botaoVoltar);

		JButton botaoEditar = new JButton("EDITAR");
		botaoEditar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoEditar.setBounds(303, 478, 139, 50);
		panel.add(botaoEditar);

		JButton botaoPreVisualizar = new JButton("PRÉ-VISUALIZAR");
		botaoPreVisualizar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		botaoPreVisualizar.setBounds(529, 478, 139, 50);
		panel.add(botaoPreVisualizar);

		JButton botaoConfigurar = new JButton("CONFIGURAR ");
		botaoConfigurar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		botaoConfigurar.setBounds(752, 478, 139, 50);
		panel.add(botaoConfigurar);

		JButton botaoSalvar = new JButton("SALVAR");
		botaoSalvar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoSalvar.setBounds(32, 461, 244, 65);
		panel.add(botaoSalvar);
		
		JLabel iconeOrcamentos = new JLabel("");
		iconeOrcamentos.setBounds(926, 11, 237, 47);
		panel.add(iconeOrcamentos);
		
		JButton botaoEstimativa = new JButton("ESTIMATIVA");
		botaoEstimativa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoEstimativa.setBounds(32, 385, 244, 65);
		panel.add(botaoEstimativa);
		
		JButton botaoAddMateriais = new JButton("ADICIONAR MATERIAIS");
		botaoAddMateriais.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAddMateriais.setBounds(32, 308, 244, 65);
		panel.add(botaoAddMateriais);
		
		JButton botaoAddEmpecilho = new JButton("ADICIONAR EMPECILHO");
		botaoAddEmpecilho.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAddEmpecilho.setBounds(32, 232, 244, 65);
		panel.add(botaoAddEmpecilho);
		
		JButton botaoAddParte = new JButton("ADICIONAR PARTE");
		botaoAddParte.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAddParte.setBounds(32, 156, 244, 65);
		panel.add(botaoAddParte);
		
		JButton botaoAddEtapa = new JButton("ADICIONAR ETAPA");
		botaoAddEtapa.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAddEtapa.setBounds(32, 80, 244, 65);
		panel.add(botaoAddEtapa);
		
		JButton botaoEstilo = new JButton("ESTILO DE FORMATAÇÃO");
		botaoEstilo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		botaoEstilo.setBounds(926, 366, 244, 65);
		panel.add(botaoEstilo);
		
		JButton botaoEmitirArquivo = new JButton("EMITIR ARQUIVO");
		botaoEmitirArquivo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoEmitirArquivo.setBounds(926, 270, 244, 65);
		panel.add(botaoEmitirArquivo);
		
		JButton botaoResetar = new JButton("RESETAR ORÇAMENTO");
		botaoResetar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoResetar.setBounds(926, 177, 244, 65);
		panel.add(botaoResetar);
		
		JButton botaoMudarNomeArq = new JButton("MUDAR NOME DO ARQUIVO");
		botaoMudarNomeArq.setFont(new Font("Arial Black", Font.PLAIN, 12));
		botaoMudarNomeArq.setBounds(926, 80, 244, 65);
		panel.add(botaoMudarNomeArq);
		
		JButton botaoProgresso = new JButton("MOSTRAR PROGRESSO");
		botaoProgresso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		botaoProgresso.setBounds(926, 463, 244, 65);
		panel.add(botaoProgresso);
		
		JLabel informacoes = new JLabel("");
		informacoes.setBounds(303, 553, 588, 98);
		panel.add(informacoes);
				
		ImageIcon icon = new ImageIcon(SistemaDeOrcamentos.class.getResource("/resources/background.png"));
		JLabel planoDeFundo = new JLabel(icon);
		planoDeFundo.setBounds(-19, 0, 1226, 707);
		panel.add(planoDeFundo);
		
	}
}
