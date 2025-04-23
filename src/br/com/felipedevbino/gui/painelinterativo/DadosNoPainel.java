package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class DadosNoPainel {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private BuscarEtapa buscarEtapas;
	private BuscarParte buscarParte;

	public DadosNoPainel() {
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		buscarEtapas = new BuscarEtapa();
		buscarParte = new BuscarParte();
	}

	public void addEtapas(JPanel painelDeDados) {

		verificarSeTituloExiste(painelDeDados, "ETAPAS");

		criaEtapasVisiveis(painelDeDados);

		painelDeDados.revalidate();
		painelDeDados.repaint();

	}

	public void addMateriais(JPanel painelDeDados) {
		// TODO
	}

	public void addEmpecilhos(JPanel painelDeDados) {
		// TODO
	}

	private JLabel obtemLabelFormatada(JPanel painelDeDados, String texto, int tamanho) {

		JLabel label = new JLabel();

		label.setFont(new Font("Arial Black", Font.PLAIN, tamanho));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setText(texto);

		return label;

	}

	private void criaEtapasVisiveis(JPanel painelDeDados) {

		int contadorDeEtapas = 1;
		int contadorDePartes = 1;
		
		for (String etapaAtual : etapas.getEtapas().keySet()) {
			
			JLabel infoEtapas = obtemLabelFormatada(painelDeDados, ("ETAPA " + contadorDeEtapas), 25);
			infoEtapas.setAlignmentX(Component.CENTER_ALIGNMENT);
			painelDeDados.add(infoEtapas);
			
			JButton etapa = capturarDadoComoBotao(painelDeDados, etapaAtual);
			etapa.setAlignmentX(Component.CENTER_ALIGNMENT);
			painelDeDados.add(etapa);
			
			painelDeDados.add(Box.createVerticalStrut(20));
			
			for (String parteAtual : etapas.getPartesDeEtapa(etapaAtual).keySet()) {

				JLabel infoPartes = obtemLabelFormatada(painelDeDados, ("Parte " + contadorDePartes), 17);
				infoPartes.setAlignmentX(Component.CENTER_ALIGNMENT);
				painelDeDados.add(infoPartes);

				JButton parte = capturarDadoComoBotao(painelDeDados, parteAtual);
				parte.setAlignmentX(Component.CENTER_ALIGNMENT);
				painelDeDados.add(parte);

				JLabel infoValor = obtemLabelFormatada(painelDeDados, "Valor:", 17);
				infoValor.setAlignmentX(Component.CENTER_ALIGNMENT);

				painelDeDados.add(infoValor);

				JButton valor = capturarDadoComoBotao(painelDeDados,
						(etapas.getValorParteEtapa(etapaAtual, parteAtual).toString() + "R$"));
				valor.setAlignmentX(Component.CENTER_ALIGNMENT);
				painelDeDados.add(valor);

				painelDeDados.add(Box.createVerticalStrut(20));

				contadorDePartes++;

			}
			contadorDePartes = 1;

			contadorDeEtapas++;

		}

	}

	private void verificarSeTituloExiste(JPanel painelDeDados, String titulo) {

		JLabel label = new JLabel();
		label.setText(titulo);

		boolean seExisteTitulo = false;

		for (Component componente : painelDeDados.getComponents()) {

			if (componente instanceof JLabel) {

				if (((JLabel) componente).getText().equals(label.getText())) {

					seExisteTitulo = true;

				}

			}

		}
		if (!seExisteTitulo && !etapas.getEtapas().isEmpty()) {

			adicionarTitulo(painelDeDados, titulo);

		}

	}

	private void adicionarTitulo(JPanel painelDeDados, String titulo) {

		JLabel item = obtemLabelFormatada(painelDeDados, titulo, 30);
		painelDeDados.add(item);
		painelDeDados.add(Box.createVerticalStrut(20));

	}

	private JButton capturarDadoComoBotao(JPanel painelDeDados, String dado) {

		JButton botao = new JButton();
		botao.setFont(new Font("Arial", Font.PLAIN, 17));
		botao.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao.setText(dado);

		LogicaPainel menu = new LogicaPainel(painelDeDados);

		botao.addActionListener(menu.escolherAcao());

		return botao;

	}

}
