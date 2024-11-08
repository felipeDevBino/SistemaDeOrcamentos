package br.com.felipedevbino.logicaexecucao.logicadados.empecilhos;

import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;

public class AdicionarEmpecilho {

	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private Interacao interacao;
	private String empecilho;
	private Double valorEmpecilho;

	public AdicionarEmpecilho() {
		interacao = new Interacao();
		empecilho = "";
		valorEmpecilho = 0.0;
	}

	private void inserirNomeEValorDoEmpecilho() {
		empecilho = interacao.inserirDadoDeTexto("INSIRA O NOME DO EMPECILHO: ");
		valorEmpecilho = interacao.inserirDadoNumericoFlutuante(
				"INSIRA O VALOR QUE O EMPECILHO REPRESENTA AO SUBTRAIR NO ORÇAMENTO: ");
	}

	public void adicionarEmpecilhoAoOrcamento() {
		boolean seOsDadosForamValidos;
		do {
			inserirNomeEValorDoEmpecilho();

			seOsDadosForamValidos = seOsDadosSaoValidos(empecilho, valorEmpecilho);

			if (!seOsDadosForamValidos) {
				continue;
			}

		} while (!seOsDadosForamValidos);

		empecilhos.inserirEmpecilho(empecilho, valorEmpecilho);
		interacao.mostrarMensagemDeInformacao("EMPECILHO ADICIONADO COM SUCESSO.");
	}

	private boolean seOsDadosSaoValidos(String empecilho, Double valorEmpecilho) {
		if (valorEmpecilho <= 0) {
			interacao.mostrarMensagemDeErro("ERRO! O EMPECILHO PRECISA TER UM VALOR SUPERIOR A 0.");
			return false;
		} else if (empecilho == null || valorEmpecilho == null) {
			interacao.mostrarMensagemDeErro("ERRO! DADOS VAZIOS.");
			return false;
		} else {
			return true;
		}
	}
}
