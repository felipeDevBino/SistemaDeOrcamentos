package br.com.felipedevbino.gui.funcoesgui;

import javax.swing.JOptionPane;

public class CaixaDeEscolha {

	private EscolherOperacao operacao;

	public boolean confirmarOuNegarDados(String opcaoConfirmacao, String opcaoNegacao, String mensagem) {
		operacao = new EscolherOperacao();

		if (confirmarOuNegarSemDados(opcaoConfirmacao, opcaoNegacao, mensagem)) {
			return true;
		}
		return false;
	}

	private boolean confirmarOuNegarSemDados(String opcaoConfirmacao, String opcaoNegacao, String mensagem) {
		operacao.escolherContinuarOuCancelar(opcaoConfirmacao, opcaoNegacao, mensagem);
		if (operacao.getOpcaoEscolhida() == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

}
