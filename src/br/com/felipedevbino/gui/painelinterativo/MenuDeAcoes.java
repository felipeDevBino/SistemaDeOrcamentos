package br.com.felipedevbino.gui.painelinterativo;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDeAcoes {

	private JFrame frame;
	private static int acao;

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
		acao = 0;

		initialize();
	}

	public static int getAcao() {
		return acao;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("AÇÕES");
		frame.setResizable(true);
		frame.setBounds(150, 61, 221, 151);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("RENOMEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 1;
			}
		});
		btnNewButton.setBounds(10, 11, 185, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnReposicionar_1 = new JButton("REPOSICIONAR");
		btnReposicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 2;
			}
		});
		btnReposicionar_1.setBounds(10, 42, 185, 23);
		frame.getContentPane().add(btnReposicionar_1);

		JButton btnReposicionar = new JButton("REMOVER");
		btnReposicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 3;
			}
		});
		btnReposicionar.setBounds(10, 76, 185, 23);
		frame.getContentPane().add(btnReposicionar);
		frame.requestFocus();
	}

}
