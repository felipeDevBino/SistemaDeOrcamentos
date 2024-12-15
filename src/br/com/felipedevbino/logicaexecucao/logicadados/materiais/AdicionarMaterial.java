package br.com.felipedevbino.logicaexecucao.logicadados.materiais;

import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;

public class AdicionarMaterial {

	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private CaixaDeEscolha escolha;
	private Interacao interacao;
	private String material;
	private Double valor;
	private boolean materialValido;
	private boolean valorValido;

	public AdicionarMaterial() {
		interacao = new Interacao();
		escolha = new CaixaDeEscolha();
		material = "";
		valor = 0.0;
		materialValido = false;
		valorValido = false;
	}

	public void adicionarMaterialAoOrcamento() {
		do {
			materialValido = false;

			inserirMaterial();
			if (!materialValido) {
				if (escolha.confirmarOuNegarDados("SIM", "NÃO",
						"O MATERIAL NÃO FOI INSERIDO, DESEJA CANCELAR A EXECUÇÃO?")) {
					return;
				}
				continue;
			}

			do {
				valorValido = false;
				inserirValor();
				if (!valorValido) {
					if (escolha.confirmarOuNegarDados("SIM", "NÃO",
							"O VALOR NÃO FOI INSERIDO, DESEJA CANCELAR A EXECUÇÃO?")) {
						return;
					}
				}
			} while (!valorValido);
		} while (!materialValido || !valorValido);
		materiais.inserirMaterial(material, valor);
		interacao.mostrarMensagemDeInformacao("MATERIAL ADICIONADO COM SUCESSO.");
	}

	private void inserirMaterial() {
		material = interacao.inserirDadoDeTexto("INSIRA O NOME DO MATERIAL:");
		verificarSeOMaterialEValido();
	}

	private void inserirValor() {
		try {
			valor = interacao
					.inserirDadoNumericoFlutuante("INSIRA O VALOR QUE O MATERIAL POSSUI AO SUBTRAIR NO ORÇAMENTO:");
			verificarSeOValorEValido();
		} catch (Exception e) {
			definirValorComoInvalido();
			return;
		}
		valorValido = true;
	}

	private void verificarSeOMaterialEValido() {
		materialValido = (material == null || material.isEmpty()) ? false : true;
	}

	private void verificarSeOValorEValido() {
		String valorStr = String.valueOf(valor);
		if (valorStr.isEmpty()) {
			definirValorComoInvalido();
		}
	}

	private void definirValorComoInvalido() {
		valorValido = false;
	}

}
