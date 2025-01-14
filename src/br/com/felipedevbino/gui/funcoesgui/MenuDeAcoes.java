package br.com.felipedevbino.gui.funcoesgui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;

public class MenuDeAcoes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDeAcoes window = new MenuDeAcoes();
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
	public MenuDeAcoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("AÇÕES");
		frame.setResizable(true);
		frame.setBounds(100, 100, 221, 141);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("RENOMEAR");
		btnNewButton.setBounds(10, 11, 185, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReposicionar_1 = new JButton("REPOSICIONAR");
		btnReposicionar_1.setBounds(10, 42, 185, 23);
		frame.getContentPane().add(btnReposicionar_1);
		
		JButton btnReposicionar = new JButton("REMOVER");
		btnReposicionar.setBounds(10, 76, 185, 23);
		frame.getContentPane().add(btnReposicionar);

	}
	
}
