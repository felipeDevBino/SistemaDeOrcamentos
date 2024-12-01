package br.com.felipedevbino.logicaexecucao.logicadados.empecilhos;

import br.com.felipedevbino.gui.funcoesgui.CaixaDeEscolha;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;

import java.util.Optional;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;

public class AdicionarEmpecilho {

	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private CaixaDeEscolha escolha;
	private Interacao interacao;
	private String empecilho;
	private Double valorEmpecilho;
	private boolean empecilhoValido;
	private boolean valorValido;
	private boolean seEscolheuSair;

	public AdicionarEmpecilho() {
		escolha = new CaixaDeEscolha();
		interacao = new Interacao();
		empecilho = "";
		valorEmpecilho = 0.0;
		empecilhoValido = false;
		valorValido = false;
		seEscolheuSair = false;
	}

	private void inserirNomeEValorDoEmpecilho() {
		do {
			empecilhoValido = false;
			adicionarNomeDoEmpecilho();

			if (seEscolheuSair) {
				return;
			}
			if (!empecilhoValido) {
				if (escolha.confirmarOuNegarDados("SIM", "NÃO",
						"O EMPECILHO NÃO FOI ADICIONADO! DESEJA CANCELAR A EXECUÇÃO?")) {
					seEscolheuSair = true;
					return;
				}
				continue;
			}

			do {
				valorValido = false;
				adicionarValorDoEmpecilho();
				verificarSeOValorEValido();
				if (!valorValido) {
					if (escolha.confirmarOuNegarDados("SIM", "NÃO",
							"O VALOR NÃO FOI INSERIDO, DESEJA CANCELAR A EXECUÇÃO?")) {
						seEscolheuSair = true;
						return;
					}
				}
			} while (!valorValido);
		} while (!empecilhoValido || !valorValido);
	}

	private void adicionarNomeDoEmpecilho() {
		empecilho = interacao.inserirDadoDeTexto("INSIRA O NOME DO EMPECILHO: ");
		verificarSeOEmpecilhoEValido();
	}

	private void adicionarValorDoEmpecilho() {
		try {
			valorEmpecilho = interacao.inserirDadoNumericoFlutuante(
					"INSIRA O VALOR QUE O EMPECILHO REPRESENTA AO SUBTRAIR NO ORÇAMENTO: ");
		} catch (Exception e) {
			defineValorComoInvalido();
			return;
		}
		valorValido = true;
	}

	public void adicionarEmpecilhoAoOrcamento() {
		seEscolheuSair = false;

		inserirNomeEValorDoEmpecilho();

		if (seEscolheuSair) {
			return;
		}

		empecilhos.inserirEmpecilho(empecilho, valorEmpecilho);
		interacao.mostrarMensagemDeInformacao("EMPECILHO ADICIONADO COM SUCESSO.");
	}

	private void verificarSeOEmpecilhoEValido() {
		if (empecilho == null || empecilho.isEmpty()) {
			empecilhoValido = false;
		} else {
			empecilhoValido = true;
		}

	}

	private void verificarSeOValorEValido() {
		Optional<Double> seOValorENulo = Optional.ofNullable(valorEmpecilho);
		if (valorEmpecilho == null || seOValorENulo.isPresent() || seOValorENulo.isEmpty()) {
			defineValorComoInvalido();
		}
	}

	private void defineValorComoInvalido() {
		valorValido = false;
	}

}
