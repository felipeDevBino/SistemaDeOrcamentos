package br.com.felipedevbino.logicaexecucao.logicadados.partes;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloPartes;
import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;

public class AdicionarParte {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private CaixaDeEscolha escolha;
	private BuscarEtapa buscarEtapa;
	private String etapaEncontrada;
	private ModeloPartes partes;
	private Interacao interacao;
	private String parte;
	private Double valor;
	private boolean parteValida;
	private boolean valorValido;
	private boolean seEscolheuSair;

	public AdicionarParte() {
		escolha = new CaixaDeEscolha();
		interacao = new Interacao();
		buscarEtapa = new BuscarEtapa();
		etapaEncontrada = "";
		parte = "";
		valor = 0.0;
		parteValida = false;
		valorValido = false;
		seEscolheuSair = false;
	}

	/**
	 * Método que não recebe parâmetros, permitindo que o usuário adicione uma parte
	 * prematuramente, solicitando depois que o usuário identifique a etapa a qual
	 * ele deseja alocar a parte criada.
	 */
	public void adicionarParteAQualquerEtapa() {
		if (seNaoHaEtapas()) {
			return;
		}

		criarParteEValor();

		if (seEscolheuSair) {
			return;
		}

		buscarEtapa.mostrarTodasAsEtapas();

		encontrarEDefinirEtapa();

		etapas.inserirEtapa(etapaEncontrada, partes.getPartes());
		interacao.mostrarMensagemDeInformacao("PARTES ADICIONADAS NA ETAPA " + etapaEncontrada);

		buscarEtapa.mostrarEtapasComPartes();
	}

	/**
	 * Método que parte do pressuposto de que o usuário forneceu uma quantidade de
	 * partes a ser adicionada para uma etapa específica.
	 * 
	 * @param quantidade
	 * @param etapa
	 */
	public void adicionarParteParaAEtapa(int quantidade, String etapa) {
		partes = new ModeloPartes();
		for (int i = 0; i < quantidade; i++) {
			criarParteEValorParaEtapa(i, etapa);
		}

		if (seEscolheuSair) {
			return;
		}

		etapas.inserirEtapa(etapa, partes.getPartes());
		interacao.mostrarMensagemDeInformacao("PARTES ADICIONADAS NA ETAPA " + etapa);

		buscarEtapa.mostrarEtapasComPartes();
	}

	private void criarParteEValorParaEtapa(int i, String etapa) {
		do {
			seEscolheuSair = false;
			parteValida = false;
			inserirParte(String.format("INSIRA A %d PARTE DA ETAPA %s", (i + 1), etapa));

			if (seEscolheuSair) {
				return;
			}
			if (seAParteEstaVazia()) {
				continue;
			}

			do {
				valorValido = false;
				inserirValor();
				verificarSeOValorEValido();
				if (!valorValido) {
					if (escolha.confirmarOuNegarDados("SIM", "NÃO",
							"O VALOR NÃO FOI INSERIDO, DESEJA CANCELAR A EXECUÇÃO?")) {
						seEscolheuSair = true;
						return;
					}
				}
			} while (!valorValido);
		} while (!parteValida || !valorValido);

		partes.inserirParte(parte, valor);

	}

	private boolean seEscolheCancelarExecucao(String mensagem) {
		if (parte == null || parte.isEmpty()) {
			seEscolheuSair = escolha.confirmarOuNegarDados("SIM", "NÃO", mensagem);
			return seEscolheuSair;
		}
		parteValida = true;
		return false;
	}

	private boolean seAParteEstaVazia() {
		return parte == null || parte.isEmpty();
	}

	private void verificarSeOValorEValido() {
		if (valor == null) {
			definirValorComoInvalido();
		}
	}

	private boolean seNaoHaEtapas() {
		if (etapas.getEtapas() == null || etapas.getEtapas().isEmpty()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUMA ETAPA ESTÁ DISPONÍVEL PARA QUE SE ADICIONE PARTES.");
			return true;
		}
		return false;
	}

	private void criarParteEValor() {
		partes = new ModeloPartes();
		do {
			seEscolheuSair = false;
			parteValida = false;
			inserirParte("INSIRA A PARTE PARA A ETAPA");

			if (seEscolheuSair) {
				return;
			}
			if (seAParteEstaVazia()) {
				continue;
			}

			do {
				valorValido = false;
				inserirValor();
				verificarSeOValorEValido();
				if (!valorValido) {
					if (escolha.confirmarOuNegarDados("SIM", "NÃO",
							"O VALOR NÃO FOI INSERIDO, DESEJA CANCELAR A EXECUÇÃO?")) {
						return;
					}
				}
			} while (!valorValido);
		} while (!parteValida || !valorValido);

		partes.inserirParte(parte, valor);
	}

	private void inserirParte(String texto) {
		parte = interacao.inserirDadoDeTexto(texto);
		seEscolheCancelarExecucao("A PARTE ESTÁ VAZIA, DESEJA CANCELAR A EXECUÇÃO?");
	}

	private void inserirValor() {
		try {
			valor = interacao.inserirDadoNumericoFlutuante("INSIRA O VALOR DA PARTE");
		} catch (Exception e) {
			definirValorComoInvalido();
			return;
		}
		valorValido = true;
	}

	private void definirValorComoInvalido() {
		valorValido = false;
	}

	private void encontrarEDefinirEtapa() {
		boolean seAEtapaFoiDefinida;
		do {
			seAEtapaFoiDefinida = true;
			try {
				etapaEncontrada = buscarEtapa.buscarEtapa();
				seAEtapaFoiDefinida = buscarEtapa.verificarSeAEtapaExiste(etapaEncontrada);
			} catch (Exception e) {
				interacao.mostrarMensagemDeErro("ERRO! INSIRA UMA POSIÇÃO VÁLIDA.");
				seAEtapaFoiDefinida = false;
				continue;
			}
		} while (etapaEncontrada == null || !seAEtapaFoiDefinida);
	}

}
