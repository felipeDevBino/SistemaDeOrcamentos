package br.com.felipedevbino.gui.painelinterativo;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.felipedevbino.gui.SistemaDeOrcamentos;
import br.com.felipedevbino.instancias.InstanceManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDeAcoes {

	private JFrame frame;
	private SistemaDeOrcamentos sistemaDeOrcamentos = InstanceManager.getSistemaDeOrcamentos();
	
	/**
	 * Launch the application.
	 */
	///public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//MenuDeAcoes window = new MenuDeAcoes();
					//window.frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the application.
	 */
	public MenuDeAcoes(JPanel painelDeDados, JButton dado) {
		initialize(painelDeDados, dado);
	}
	
	public JFrame getJFrame() {
		return frame;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JPanel painelDeDados, JButton dado) {

		sistemaDeOrcamentos.getJFrame().setAlwaysOnTop(false);
		
		frame = new JFrame();
		frame.setTitle("AÇÕES");
		frame.setResizable(true);
		frame.setBounds(150, 61, 221, 151);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		LogicaPainel logicaPainel = new LogicaPainel();
		
		JButton btnNewButton = new JButton("RENOMEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logicaPainel.renomearNoPainel(dado);
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 11, 185, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnReposicionar_1 = new JButton("REPOSICIONAR");
		btnReposicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logicaPainel.reposicionarNoPainel(dado);
				frame.setVisible(false);
			
			}
		});
		btnReposicionar_1.setBounds(10, 42, 185, 23);
		frame.getContentPane().add(btnReposicionar_1);

		JButton btnReposicionar = new JButton("REMOVER");
		btnReposicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				
			}
		});
		btnReposicionar.setBounds(10, 76, 185, 23);
		frame.getContentPane().add(btnReposicionar);
		
		sistemaDeOrcamentos.getJFrame().setAlwaysOnTop(false);
		
		
	}

}
