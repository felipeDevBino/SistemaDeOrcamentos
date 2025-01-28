package br.com.felipedevbino.logicaexecucao.logicadados.materiais;

import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.instancias.InstanceManager;

public class BuscarMaterial {

	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private StringBuilder todosOsMateriais;
	private Interacao interacao;
	private int contador;

	public BuscarMaterial() {
		interacao = new Interacao();
	}

	public String buscarMaterial() {
		int posicao = interacao.inserirDadoNumericoInteiro(
				String.format("%s\n\nINSIRA O NÚMERO DO MATERIAL:", mostrarTodosOsMateriaisSemValor()));
		String material = selecionarMaterialPorPosicao(posicao);

		if (verificarSeOMaterialExiste(material)) {
			return material;
		}
		return "";
	}

	public boolean seNaoHaMateriais() {
		return materiais.getMateriais() == null || materiais.getMateriais().isEmpty();
	}

	private boolean verificarSeOMaterialExiste(String materialSolicitado) {
		for (String material : materiais.getMateriais().keySet()) {
			if (material.equals(materialSolicitado)) {
				return true;
			}
		}
		return false;
	}

	private String selecionarMaterialPorPosicao(int posicao) {
		for (String nome : materiais.getMateriais().keySet()) {
			if (posicao == contador) {
				return nome;
			}
			contador++;
		}
		return "";
	}

	private void construirCorpoMateriaisSemValor() {
		for (String material : materiais.getMateriais().keySet()) {
			todosOsMateriais.append(String.format("\n%d MATERIAL - %s \n", contador, material));
			contador++;
		}
	}

	private void construirCorpoMateriaisComValor() {
		contador = 1;
		for (String material : materiais.getMateriais().keySet()) {
			todosOsMateriais.append(String.format("\n%d MATERIAL - %s, VALOR: %f \n", contador, material,
					materiais.getMateriais().get(material)));
			contador++;
		}
	}

	public String mostrarTodosOsMateriaisSemValor() {
		if (seNaoHaMateriais()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUM MATERIAL REGISTRADO.");
			return "";
		}
		contador = 1;
		todosOsMateriais = new StringBuilder();

		construirCorpoMateriaisSemValor();

		return todosOsMateriais.toString();
	}

	public void mostrarTodosOsMateriaisComValor() {
		if (seNaoHaMateriais()) {
			interacao.mostrarMensagemDeErro("ERRO! NENHUM MATERIAL REGISTRADO.");
			return;
		}
		contador = 1;
		todosOsMateriais = new StringBuilder();

		construirCorpoMateriaisComValor();
	}

}
