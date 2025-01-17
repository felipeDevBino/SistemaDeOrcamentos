package br.com.felipedevbino.gui.painelinterativo;

import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.instancias.InstanceManager;

public class DadosNoPainel {

	private ModeloEtapas etapas;
	private ModeloMateriais materiais;
	private ModeloEmpecilhos empecilhos;
	private LogicaPainel logicaPainel;
	private int altura;
	
	public DadosNoPainel(JPanel painelDeDados) {
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		logicaPainel = new LogicaPainel(painelDeDados);
		altura = painelDeDados.getHeight() / 2;
	}

	public void exporDadosNoPainel(JPanel painelDeDados) {
		addEtapas(painelDeDados);
		addMateriais(painelDeDados);
		addEmpecilhos(painelDeDados);
	}

	private void addEtapas(JPanel painelDeDados) {
		//TODO
	}

	private void addMateriais(JPanel painelDeDados) {
		//TODO
	}

	private void addEmpecilhos(JPanel painelDeDados) {
		//TODO
	}

}
