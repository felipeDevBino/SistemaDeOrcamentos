package br.com.felipedevbino.logicaexecucao.logicadados.etapas;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.AdicionarParte;

public class AdicionarEtapa {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private AdicionarParte adicionarParte;
	private Interacao interacao;
	private String quantidade;
	private boolean adicionou;

	public AdicionarEtapa() {
		adicionarParte = new AdicionarParte();
		interacao = new Interacao();
		adicionou = false;
		quantidade = "";
	}

	public void adicionarEtapaAoOrcamento() {
		String etapa = interacao.inserirDadoDeTexto("INSIRA O NOME DA SUA ETAPA: ");
		do {
			String tipo = interacao
					.inserirDadoDeTexto("VOCÊ DESEJA ADICIONAR AS PARTES DA SUA ETAPA AGORA? (SIM OU NÃO).");

			avaliarEscolha(etapa, tipo);
		} while (!adicionou);
	}

	private void avaliarEscolha(String etapa, String tipo) {
		int quantidadeEmInteiro = 0;

		if (tipo.equalsIgnoreCase("sim")) {
			inserirQuantidadeEParte(quantidadeEmInteiro, etapa);

		} else if (tipo.equalsIgnoreCase("nao") || tipo.equalsIgnoreCase("não")) {
			etapas.inserirEtapa(etapa, null);
			interacao.mostrarMensagemDeInformacao("ETAPA SEM PARTES ADICIONADA COM SUCESSO!");
			adicionou = true;

		} else {
			interacao.mostrarMensagemDeErro("ERRO! OPÇÕES VÁLIDAS: SIM OU NÃO.");
			adicionou = false;
		}
	}

	private void inserirQuantidadeEParte(int quantidadeEmInteiro, String etapa) {
		while (quantidadeEmInteiro <= 0) {
			try {
				if (seInseriuQuantidadeComSucesso()) {
					quantidadeEmInteiro = Integer.parseInt(quantidade);

					if (quantidadeEmInteiro > 0) {
						adicionarParte.adicionarParteParaAEtapa(quantidadeEmInteiro, etapa);
						adicionou = true;
						break;
					}
				}
			} catch (NumberFormatException e) {
				interacao.mostrarMensagemDeErro("ERRO! CARACTERE INVÁLIDO.");
				continue;
			}
		}
	}

	private boolean seQuantidadeEInvalida() {
		return quantidade.equals("0") || quantidade.isEmpty() || quantidade == null;
	}
	
	private boolean seInseriuQuantidadeComSucesso() {
		quantidade = interacao.inserirDadoDeTexto("INSIRA A QUANTIDADE DE PARTES PARA SUA ETAPA:");

		if (seQuantidadeEInvalida()) {
			interacao.mostrarMensagemDeErro("ERRO! INSIRA UMA QUANTIDADE DE PARTES VÁLIDA.");
			return false;
		}
		return true;
	}
}
