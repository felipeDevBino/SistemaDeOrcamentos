package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.gui.painelinterativo.posicionamento.Posicionamento;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;

public class DadosNoPainel {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private BuscarEtapa buscarEtapas;
	private Posicionamento posicionar;

	public DadosNoPainel(Posicionamento posicionar) {
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		buscarEtapas = new BuscarEtapa();
		this.posicionar = posicionar;
	}

	private JLabel obtemLabelFormatada(JPanel painelDeDados, String texto) {
		JLabel label = new JLabel();
		label.setBounds(posicionar.larguraNoPainel, posicionar.alturaNoPainel, posicionar.larguraDoObjeto,
				posicionar.alturaDoObjeto);
		label.setText(texto);
		label.setFont(new Font("Arial Black", Font.PLAIN, 18));
		return label;
	}

	public void addEtapas(JPanel painelDeDados) {

		// verificar se o titulo já existe, se não, adicioná-lo, atualizando a posição;

		// definir o conteúdo dos botões, alocando os mesmos em suas devidas posições,
		// os dividindo em métodos reutilizáveis;

		// Por fim, atualizar a posição para que o próximo título seja claramente
		// visível.

	}

	public void addMateriais(JPanel painelDeDados) {
		// TODO
	}

	public void addEmpecilhos(JPanel painelDeDados) {
		// TODO
	}

}
