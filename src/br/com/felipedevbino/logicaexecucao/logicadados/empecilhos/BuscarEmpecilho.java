package br.com.felipedevbino.logicaexecucao.logicadados.empecilhos;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;

public class BuscarEmpecilho {

	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private StringBuilder todosOsEmpecilhos;
	private Interacao interacao;
	private int contador;

	public BuscarEmpecilho() {
		interacao = new Interacao();
	}

	public String buscarEmpecilho() {
		int posicao = interacao.inserirDadoNumericoInteiro(
				String.format("%s\n\nINSIRA O NÚMERO DO EMPECILHO:", mostrarTodosOsEmpecilhosSemValor()));
		String empecilho = selecionarEmpecilhoPorPosicao(posicao);

		if (verificarSeOEmpecilhoExiste(empecilho)) {
			return empecilho;
		}
		return "";
	}

	private boolean seNaoHaEmpecilhos() {
		return empecilhos.getEmpecilhos() == null || empecilhos.getEmpecilhos().isEmpty();
	}

	private boolean verificarSeOEmpecilhoExiste(String empecilhoSolicitado) {
		for (String empecilho : empecilhos.getEmpecilhos().keySet()) {
			if (empecilho.equalsIgnoreCase(empecilhoSolicitado)) {
				return true;
			}
		}
		return false;
	}

	private String selecionarEmpecilhoPorPosicao(int posicao) {
		contador = 1;
		for (String nome : empecilhos.getEmpecilhos().keySet()) {
			if (posicao == contador) {
				return nome;
			}
			contador++;
		}
		return "";
	}


	private void construirCorpoEmpecilhosSemValor() {
		for (String empecilho : empecilhos.getEmpecilhos().keySet()) {
			todosOsEmpecilhos.append(String.format("\n%d EMPECILHO - %s \n", contador, empecilho));
			contador++;
		}
	}

	private void construirCorpoEmpecilhosComValor() {
		for (String empecilho : empecilhos.getEmpecilhos().keySet()) {
			todosOsEmpecilhos.append(String.format("\n%d EMPECILHO - %s, VALOR: %f \n", contador, empecilho,
					empecilhos.getEmpecilhos().get(empecilho)));
			contador++;
		}
	}

	public String mostrarTodosOsEmpecilhosSemValor() {
		if (seNaoHaEmpecilhos()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUM EMPECILHO REGISTRADO.");
			return "";
		}
		contador = 1;
		todosOsEmpecilhos = new StringBuilder();

		construirCorpoEmpecilhosSemValor();
		
		return todosOsEmpecilhos.toString();
	}

	public void mostrarEmpecilhosComValor() {
		if (seNaoHaEmpecilhos()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUM EMPECILHO REGISTRADO.");
			return;
		}
		contador = 1;
		todosOsEmpecilhos = new StringBuilder();

		construirCorpoEmpecilhosComValor();
		
		interacao.mostrarMensagemDeInformacao(todosOsEmpecilhos.toString());
	}

}
