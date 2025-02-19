package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.dadosgerais.dados.ModeloPartes;
import br.com.felipedevbino.gui.painelinterativo.posicionamento.Posicionamento;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class DadosNoPainel {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private ModeloPartes partes;
	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private BuscarEtapa buscarEtapas;
	private BuscarParte buscarParte;
	private Posicionamento posicionar;

	public DadosNoPainel(Posicionamento posicionar) {
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		buscarEtapas = new BuscarEtapa();
		buscarParte = new BuscarParte();
		this.posicionar = posicionar;
	}

	public void addEtapas(JPanel painelDeDados) {

		// verificar se o titulo já existe, se não, adicioná-lo, atualizando a posição;
		verificarSeTituloExiste(painelDeDados, "Etapas");

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

	private JLabel obtemLabelFormatada(JPanel painelDeDados, String texto) {

		JLabel label = new JLabel();

		label.setBounds(posicionar.larguraNoPainel, posicionar.alturaNoPainel, posicionar.larguraDoObjeto,
				posicionar.alturaDoObjeto);
		label.setText(texto);
		label.setFont(new Font("Arial Black", Font.PLAIN, 18));

		return label;

	}

	private void criaEtapasVisiveis(JPanel painelDeDados) {
		
		for (String etapa : etapas.getEtapas().keySet()) {
			JLabel item = obtemLabelFormatada(painelDeDados, capturarDadoComoBotao(painelDeDados).getText());
			painelDeDados.add(item);

			
			
		}

	}

	private void verificarSeTituloExiste(JPanel painelDeDados, String titulo) {

		int contador = 0;

		JLabel label = new JLabel();
		label.setText(titulo);

		for (Component componente : painelDeDados.getComponents()) {

			if (componente == label) {

				JLabel item = obtemLabelFormatada(painelDeDados, capturarDadoComoBotao(painelDeDados).getText());
				painelDeDados.add(item);

			} else {
				adicionarTitulo(titulo);
			}
			contador++;

		}

		// TODO
	}

	private void adicionarTitulo(String titulo) {
		// TODO
	}

	private JButton capturarDadoComoBotao(JPanel painelDeDados) {

		// TODO
		return new JButton();
	}

}
