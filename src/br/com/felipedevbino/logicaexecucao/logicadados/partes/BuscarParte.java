package br.com.felipedevbino.logicaexecucao.logicadados.partes;

import java.math.BigDecimal;
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
		for (Map<String, BigDecimal> parteNaEtapa : etapas.getEtapas().values()) {
			if (parteNaEtapa != null) {
				construirCorpoDoTexto(etapa, parteNaEtapa);
			}
		}
		return todasAsPartes.toString();
	}

	private boolean verificarSeValoresSaoVazios(BigDecimal bigDecimal) {
		return bigDecimal.doubleValue() == 0.0 || bigDecimal == null;
	}

	private boolean verificarSeAEtapaInseridaCoincide(String etapa, Map<String, BigDecimal> parteNaEtapa) {
		return etapas.getEtapas().get(etapa).equals(parteNaEtapa);
	}

	private void construirCorpoDoTexto(String etapa, Map<String, BigDecimal> parteNaEtapa) {
		for (String parte : parteNaEtapa.keySet()) {
			if (verificarSeValoresSaoVazios(parteNaEtapa.get(parte))) {
				todasAsPartes.append("SEM VALOR REGISTRADO");

			} else if (verificarSeAEtapaInseridaCoincide(etapa, parteNaEtapa)) {
				todasAsPartes.append(String.format("  %d PARTE - %s, %.2f R$\n", contadorDePartes, parte,
						parteNaEtapa.get(parte)));
				contadorDePartes++;
			}
		}
	}

}
