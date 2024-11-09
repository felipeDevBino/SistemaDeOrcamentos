package br.com.felipedevbino.logicaexecucao.logicadados.partes;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloPartes;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;

public class AdicionarParte {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private BuscarEtapa buscarEtapa;
	private String etapaEncontrada;
	private ModeloPartes partes;
	private Interacao interacao;

	public AdicionarParte() {
		buscarEtapa = new BuscarEtapa();
		etapaEncontrada = "";
		interacao = new Interacao();
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

		inserirParteEValor();

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
			inserirParteEValorNaEtapa(i, etapa);
		}

		etapas.inserirEtapa(etapa, partes.getPartes());
		interacao.mostrarMensagemDeInformacao("PARTES ADICIONADAS NA ETAPA " + etapa);

		buscarEtapa.mostrarEtapasComPartes();
	}

	private void inserirParteEValorNaEtapa(int i, String etapa) {
		partes.inserirParte(
				interacao.inserirDadoDeTexto(String.format("INSIRA A %d PARTE DA ETAPA %s", (i + 1), etapa)),
				interacao.inserirDadoNumericoFlutuante("INSIRA O VALOR DA PARTE"));
	}

	private boolean seNaoHaEtapas() {
		if (etapas.getEtapas() == null || etapas.getEtapas().isEmpty()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUMA ETAPA ESTÁ DISPONÍVEL PARA QUE SE ADICIONE PARTES.");
			return true;
		}
		return false;
	}
	
	private void inserirParteEValor() {
		partes = new ModeloPartes();
		partes.inserirParte(interacao.inserirDadoDeTexto("INSIRA A PARTE PARA A ETAPA"),
				interacao.inserirDadoNumericoFlutuante("INSIRA O VALOR DA PARTE"));
	}
	
	private void encontrarEDefinirEtapa() {
		do {
			etapaEncontrada = buscarEtapa.buscarEtapa();
		} while (etapaEncontrada == null);
	}

}
