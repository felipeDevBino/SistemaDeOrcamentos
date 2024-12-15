package br.com.felipedevbino.logicaexecucao.logicadados.etapas;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.AdicionarParte;

public class AdicionarEtapa {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private CaixaDeEscolha escolha;
	private AdicionarParte adicionarParte;
	private Interacao interacao;
	private String etapa;
	private String quantidade;
	private int quantidadeEmInteiro;
	private boolean adicionou;
	private boolean seEscolheuAdicionar;
	private boolean seEscolheuSair;

	public AdicionarEtapa() {
		adicionarParte = new AdicionarParte();
		escolha = new CaixaDeEscolha();
		interacao = new Interacao();
		adicionou = false;
		seEscolheuAdicionar = false;
		seEscolheuSair = false;
		etapa = "";
		quantidadeEmInteiro = 0;
		quantidade = "";
	}

	public void adicionarEtapaAoOrcamento() {
		do {
			seEscolheuSair = false;
			seEscolheuAdicionar = false;

			etapa = interacao.inserirDadoDeTexto("INSIRA O NOME DA SUA ETAPA: ");

			if (seEscolheCancelarExecucao("A ETAPA ESTÁ VAZIA, DESEJA CANCELAR A EXECUÇÃO?")) {
				break;
			}
			if (seAEtapaEstaVazia()) {
				continue;
			}

			seEscolheuAdicionar = escolha.confirmarOuNegarDados("SIM", "NÃO",
					"VOCÊ DESEJA ADICIONAR AS PARTES DA SUA ETAPA AGORA?");

			avaliarEscolha();
			if (seEscolheuSair) {
				return;
			}
		} while (!adicionou);
	}

	private boolean seEscolheCancelarExecucao(String mensagem) {
		if (etapa == null || etapa.isEmpty()) {
			return escolha.confirmarOuNegarDados("SIM", "NÃO", mensagem);
		}
		return false;
	}

	private boolean seAEtapaEstaVazia() {
		return etapa == null || etapa.isEmpty();
	}

	private void avaliarEscolha() {
		if (seEscolheuAdicionar) {
			inserirQuantidadeEParte();

		} else if (!seEscolheuAdicionar) {
			etapas.inserirEtapa(etapa, null);
			interacao.mostrarMensagemDeInformacao("ETAPA SEM PARTES ADICIONADA COM SUCESSO!");
			adicionou = true;

		} else {
			interacao.mostrarMensagemDeErro("ERRO! OPÇÕES VÁLIDAS: SIM OU NÃO.");
			adicionou = false;
		}
	}

	private void inserirQuantidadeEParte() {
		quantidadeEmInteiro = 0;
		while (quantidadeEmInteiro <= 0) {
			try {
				if (seInseriuQuantidadeComSucesso()) {
					if (seEscolheuSair) {
						return;
					}
					adicionarParte.adicionarParteParaAEtapa(quantidadeEmInteiro, etapa);
					adicionou = true;
					break;
				}
			} catch (NumberFormatException e) {
				interacao.mostrarMensagemDeErro("ERRO! CARACTERE INVÁLIDO.");
				continue;
			}
		}
	}

	private boolean seQuantidadeEInvalida() {
		return quantidade == null || quantidade.isEmpty() || quantidade.equals("0") || quantidade.equals("");
	}

	private boolean seInseriuQuantidadeComSucesso() {
		quantidade = interacao.inserirDadoDeTexto("INSIRA A QUANTIDADE DE PARTES PARA SUA ETAPA:");

		if (seQuantidadeEInvalida()) {
			seEscolheuSair = escolha.confirmarOuNegarDados("SIM", "NÃO",
					"ERRO! É PRECISO INSERIR UMA QUANTIDADE DE PARTES VÁLIDA.\nDESEJA CANCELAR A EXECUÇÃO?");
			return seEscolheuSair;
		}

		quantidadeEmInteiro = Integer.parseInt(quantidade);
		return true;
	}
}
