package br.com.felipedevbino.gui.funcoesgui;

import javax.swing.JOptionPane;

/**
 * Classe que aborda a interação prática com o usuário através de textos
 * impressos e inserções de dados feitos por telas através de JOptionPane,
 * apresentado ao usuário conforme o uso da Inteface Gráfica.
 */
public class Interacao {

	private void tipo(String mensagem, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}

	private String insercao(String mensagem, int tipo) {
		return JOptionPane.showInputDialog(null, mensagem, "INSERIR", tipo);
	}

	public void mostrarMensagemDeInformacao(String mensagem) {
		tipo(mensagem, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensagemDeAviso(String mensagem) {
		tipo(mensagem, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

	public String mostrarMensagemDeErro(String mensagem) {
		tipo(mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
		return mensagem;
	}

	public String inserirDadoDeTexto(String mensagem) {
		return insercao(mensagem, JOptionPane.QUESTION_MESSAGE);
	}

	public int inserirDadoNumericoInteiro(String mensagem) {
		int dado = Integer.parseInt(insercao(mensagem, JOptionPane.QUESTION_MESSAGE));
		return dado;
	}

	public double inserirDadoNumericoFlutuante(String mensagem) {
		double dado = Double.parseDouble(insercao(mensagem, JOptionPane.QUESTION_MESSAGE));
		return dado;
	}

}
