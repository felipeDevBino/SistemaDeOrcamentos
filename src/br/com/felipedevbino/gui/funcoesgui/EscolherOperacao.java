package br.com.felipedevbino.gui.funcoesgui;

import javax.swing.JOptionPane;

import br.com.felipedevbino.gui.SistemaDeOrcamentos;
import br.com.felipedevbino.instancias.InstanceManager;

public class EscolherOperacao {

	private SistemaDeOrcamentos orcamento = InstanceManager.getSistemaDeOrcamentos();
	private int escolha;
	private String[] opcoes;
	
	public void escolherContinuarOuCancelar(String opcao01, String opcao02, String continuidade) {
		opcoes = new String[] { opcao01, opcao02 };

		escolha = JOptionPane.showOptionDialog(orcamento.getJFrame(), continuidade, "ESCOLHA",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public int getOpcaoEscolhida() {
		return escolha;
	}

}
