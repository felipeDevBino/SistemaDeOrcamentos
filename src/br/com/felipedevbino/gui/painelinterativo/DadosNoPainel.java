package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.gui.painelinterativo.posicionamento.Posicionamento;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class DadosNoPainel {

	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
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

		label.setBounds(posicionar.larguraNoPainel, posicionar.alturaNoPainel, posicionar.larguraDoObjeto,
				posicionar.alturaDoObjeto);
		label.setText(texto);
		label.setFont(new Font("Arial Black", Font.PLAIN, tamanho));

		return label;

	}

	private void criaEtapasVisiveis(JPanel painelDeDados) {

		int contadorDeEtapas = 1;
		int contadorDePartes = 1;

		for (String etapaAtual : etapas.getEtapas().keySet()) {

			JLabel infoEtapas = obtemLabelFormatada(painelDeDados, ("Etapa " + contadorDeEtapas), 17);
			posicionar.incrementarParaOProximoTexto(0);
			painelDeDados.add(infoEtapas);

			JButton etapa = capturarDadoComoBotao(painelDeDados, etapaAtual);
			posicionar.incrementarParaOProximoTexto(0);
			painelDeDados.add(etapa);

			for (Map<String, BigDecimal> partes : etapas.getEtapas().values()) {
				for (String parteAtual : partes.keySet()) {

					JLabel infoPartes = obtemLabelFormatada(painelDeDados, ("Parte " + contadorDePartes), 17);
					posicionar.incrementarParaOProximoTexto(0);
					painelDeDados.add(infoPartes);

					JButton parte = capturarDadoComoBotao(painelDeDados, parteAtual);
					posicionar.incrementarParaOProximoTexto(0);
					painelDeDados.add(parte);
					
					JLabel infoValor = obtemLabelFormatada(painelDeDados, "Valor:", 17);
					posicionar.incrementarParaOProximoTexto(0);
					painelDeDados.add(infoValor);

					JButton valor = capturarDadoComoBotao(painelDeDados, (partes.get(parteAtual).toString() + "R$"));
					posicionar.incrementarParaOProximoTexto(0);
					painelDeDados.add(valor);

					contadorDePartes++;
					
				}
				contadorDeEtapas++;
			}

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
		if (!seExisteTitulo) {

			adicionarTitulo(painelDeDados, titulo);

		}

	}

	private void adicionarTitulo(JPanel painelDeDados, String titulo) {

		JLabel item = obtemLabelFormatada(painelDeDados, titulo, 20);
		painelDeDados.add(item);
		posicionar.incrementarParaOProximoTexto(60);

	}

	private JButton capturarDadoComoBotao(JPanel painelDeDados, String dado) {

		JButton botao = new JButton();
		botao.setBounds(posicionar.alturaNoPainel, posicionar.larguraNoPainel, posicionar.alturaDoObjeto,
				posicionar.larguraDoObjeto);
		botao.setFont(new Font("Arial", Font.PLAIN, 17));
		botao.setText(dado);

		LogicaPainel menu = new LogicaPainel(painelDeDados);

		botao.addActionListener(menu.escolherAcao());

		return botao;

	}

}
