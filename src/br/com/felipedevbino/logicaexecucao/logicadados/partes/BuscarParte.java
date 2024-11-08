package br.com.felipedevbino.logicaexecucao.logicadados.partes;

import java.util.Map;

import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.instancias.InstanceManager;

public class BuscarParte {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private StringBuilder todasAsPartes;
	private int contadorDePartes;

	public String montarPartesParaExibicao(String etapa) {
		contadorDePartes = 1;
		todasAsPartes = new StringBuilder();
		for (Map<String, Double> parteNaEtapa : etapas.getEtapas().values()) {
			if (parteNaEtapa != null) {
				construirCorpoDoTexto(etapa, parteNaEtapa);
			}
		}
		return todasAsPartes.toString();
	}

	private boolean verificarSeValoresSaoVazios(Double partes) {
		return partes == 0 || partes == null;
	}

	private boolean verificarSeAEtapaInseridaCoincide(String etapa, Map<String, Double> parteNaEtapa) {
		return etapas.getEtapas().get(etapa).equals(parteNaEtapa);
	}

	private void construirCorpoDoTexto(String etapa, Map<String, Double> parteNaEtapa) {
		for (String parte : parteNaEtapa.keySet()) {
			if (verificarSeValoresSaoVazios(parteNaEtapa.get(parte))) {
				todasAsPartes.append("SEM VALOR REGISTRADO");

			} else if (verificarSeAEtapaInseridaCoincide(etapa, parteNaEtapa)) {
				todasAsPartes.append(String.format("  %d PARTE - %s, VALOR: %f\n", contadorDePartes, parte,
						parteNaEtapa.get(parte)));
				contadorDePartes++;
			}
		}
	}

}
