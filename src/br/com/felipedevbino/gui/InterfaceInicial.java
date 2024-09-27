package br.com.felipedevbino.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class InterfaceInicial {

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
					InterfaceInicial window = new InterfaceInicial();
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
	public InterfaceInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setName("Tela Inicial");
		frame.setBounds(100, 100, 603, 712);
		frame.setBackground(new Color(135, 135, 135));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CRIAR ORÇAMENTO");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 23));
		btnNewButton.setBounds(137, 194, 306, 127);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVereditarOramento = new JButton("VER/EDITAR ORÇAMENTO");
		btnVereditarOramento.setFont(new Font("Arial Black", Font.PLAIN, 17));
		btnVereditarOramento.setBounds(137, 356, 306, 127);
		frame.getContentPane().add(btnVereditarOramento);
		
		JButton btnDeletarOramento = new JButton("DELETAR ORÇAMENTO");
		btnDeletarOramento.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnDeletarOramento.setBounds(137, 520, 306, 127);
		frame.getContentPane().add(btnDeletarOramento);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo(a) ao ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblNewLabel.setBounds(140, -81, 387, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSistemaDeOramentos = new JLabel("Sistema de Orçamentos");
		lblSistemaDeOramentos.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblSistemaDeOramentos.setBounds(89, 11, 438, 120);
		frame.getContentPane().add(lblSistemaDeOramentos);
		
		JLabel lblDeFelipedevbino = new JLabel("de felipeDevBino");
		lblDeFelipedevbino.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblDeFelipedevbino.setBounds(137, 22, 387, 200);
		frame.getContentPane().add(lblDeFelipedevbino);
	}

}
