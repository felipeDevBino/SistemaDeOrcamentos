package br.com.felipedevbino.logicaexecucao.logicadados.materiais;

import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;

public class AdicionarMaterial {

	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private Interacao interacao;
	private String material;
	private Double valorMaterial;

	public AdicionarMaterial() {
		interacao = new Interacao();
		material = "";
		valorMaterial = 0.0;
	}

	private void inserirNomeEValorDoMaterial() {
		material = interacao.inserirDadoDeTexto("INSIRA O NOME DO MATERIAL ");
		valorMaterial = interacao.inserirDadoNumericoFlutuante(
				"INSIRA O VALOR QUE O MATERIAL POSSUI AO SUBTRAIR NO ORÇAMENTO\n\nP.S: CASO NÃO HAJA GASTO, DIGITE SOMENTE 0:");
	}

	public void adicionarMaterialAoOrcamento() {
		boolean seOsDadosForamValidos;
		do {
			inserirNomeEValorDoMaterial();

			seOsDadosForamValidos = seOsDadosSaoValidos(material, valorMaterial);

			if (!seOsDadosForamValidos) {
				continue;
			}
		} while (!seOsDadosForamValidos);

		materiais.inserirMaterial(material, valorMaterial);
		interacao.mostrarMensagemDeInformacao("MATERIAL ADICIONADO COM SUCESSO.");
	}

	private boolean seOsDadosSaoValidos(String material, Double valorMaterial) {
		if (valorMaterial < 0) {
			interacao.mostrarMensagemDeErro("ERRO! O MATERIAL PRECISA TER NO MÍNIMO O VALOR DE 0.");
			return false;
		} else if (material == null || valorMaterial == null) {
			interacao.mostrarMensagemDeErro("ERRO! DADOS VAZIOS.");
			return false;
		} else {
			return true;
		}
	}

}
