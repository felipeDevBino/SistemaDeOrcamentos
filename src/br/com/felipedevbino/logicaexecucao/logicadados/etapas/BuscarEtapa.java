package br.com.felipedevbino.logicaexecucao.logicadados.etapas;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class BuscarEtapa {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private Interacao interacao;
	private StringBuilder todasAsEtapas;
	private BuscarParte buscarParte;
	private int contador;

	public BuscarEtapa() {
		interacao = new Interacao();
		buscarParte = new BuscarParte();
	}

	public String buscarEtapa() {
		int posicao = interacao
				.inserirDadoNumericoInteiro(String.format("%s\n\nINSIRA O NÚMERO DA ETAPA:", mostrarTodasAsEtapas()));
		String etapa = selecionarEtapaPorPosicao(posicao);

		return etapa;
	}
	
	public boolean verificarSeAEtapaExiste(String etapaSolicitada) {
		for (String etapa : etapas.getEtapas().keySet()) {
			if (etapa.equalsIgnoreCase(etapaSolicitada)) {
				return true;
			}
		}
		interacao.mostrarMensagemDeErro("ERRO! A ETAPA INFORMADA NÃO EXISTE.");
		return false;
	}

	private boolean seNaoHaEtapas() {
		return etapas.getEtapas() == null || etapas.getEtapas().isEmpty();
	}

	private String selecionarEtapaPorPosicao(int posicao) {
		contador = 1;
		for (String nome : etapas.getEtapas().keySet()) {
			if (posicao == contador) {
				return nome;
			}
			contador++;
		}
		return "";
	}

	private void construirCorpoEtapaSemPartes() {
		for (String etapa : etapas.getEtapas().keySet()) {
			todasAsEtapas.append(String.format("%d ETAPA - %s \n", contador, etapa));
			contador++;
		}
	}
	
	private void construirCorpoEtapaComPartes() {
		for (String etapa : etapas.getEtapas().keySet()) {
			todasAsEtapas.append(String.format("\n%d ETAPA - %s \n", contador, etapa));
			if (buscarParte.montarPartesParaExibicao(etapa).isEmpty()) {
				todasAsEtapas.append("  NÃO HÁ VALOR REGISTRADO\n");
			}
			todasAsEtapas.append(buscarParte.montarPartesParaExibicao(etapa));
			contador++;
		}
		todasAsEtapas.append("\n");
	}

	public void mostrarEtapasComPartes() {
		if (seNaoHaEtapas()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUMA ETAPA REGISTRADA.");
			return;
		}
		contador = 1;
		todasAsEtapas = new StringBuilder();
		
		construirCorpoEtapaComPartes();
		
		interacao.mostrarMensagemDeInformacao(todasAsEtapas.toString());
	}

	public String mostrarTodasAsEtapas() {
		if (seNaoHaEtapas()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUMA ETAPA REGISTRADA.");
			return "";
		}
		contador = 1;
		todasAsEtapas = new StringBuilder();

		construirCorpoEtapaSemPartes();

		return todasAsEtapas.toString();
	}

}
