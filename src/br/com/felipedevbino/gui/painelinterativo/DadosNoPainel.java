package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

	private Map<Integer, Component> componentes;
	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private LogicaPainel logicaPainel;
	private JPanel painelDeDados;
	private BuscarEtapa buscarEtapas;
	private BuscarParte buscarParte;

	public DadosNoPainel(JPanel painelDeDados) {
		
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		this.painelDeDados = painelDeDados;
		buscarEtapas = new BuscarEtapa();
		buscarParte = new BuscarParte();
		componentes = new HashMap<>();
		
		//logicaPainel = new LogicaPainel(painelDeDados);
		
	}
	
	public void addEtapas() {

		verificarSeTituloExiste("ETAPAS");

		inserirEtapasComponentes();

		painelDeDados.revalidate();
		painelDeDados.repaint();
		
		exibirComponentes();

	}

	public void addMateriais(JPanel painelDeDados) {
		// TODO
	}

	public void addEmpecilhos(JPanel painelDeDados) {
		// TODO
	}

	private JLabel obtemLabelFormatada(String texto, int tamanho) {

		JLabel label = new JLabel();

		label.setFont(new Font("Arial Black", Font.PLAIN, tamanho));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setText(texto);

		return label;

	}
	
	public void exibirComponentes() {
		
		for(Component componente : componentes.values()) {
			painelDeDados.add(componente);
		}
		
	}

	private void inserirEtapasComponentes() {

		int contador = 0;
		int contadorDeEtapas = 1;
		int contadorDePartes = 1;
		
		for (String etapaAtual : etapas.getEtapas().keySet()) {
			
			JLabel infoEtapas = obtemLabelFormatada( ("ETAPA " + contadorDeEtapas), 25);
			infoEtapas.setAlignmentX(Component.CENTER_ALIGNMENT);
			componentes.put(contador, infoEtapas);
			contador++;
			
			JButton etapa = capturarDadoComoBotao(etapaAtual);
			etapa.setAlignmentX(Component.CENTER_ALIGNMENT);
			componentes.put(contador, etapa);
			contador++;
			
			for (String parteAtual : etapas.getPartesDeEtapa(etapaAtual).keySet()) {

				componentes.put(contador, Box.createVerticalStrut(15));
				contador++;
				
				JLabel infoPartes = obtemLabelFormatada(("Parte " + contadorDePartes), 17);
				infoPartes.setAlignmentX(Component.CENTER_ALIGNMENT);
				componentes.put(contador, infoPartes);
				contador++;
				
				JButton parte = capturarDadoComoBotao(parteAtual);
				parte.setAlignmentX(Component.CENTER_ALIGNMENT);
				componentes.put(contador, parte);
				contador++;
				
				JLabel infoValor = obtemLabelFormatada("Valor:", 17);
				infoValor.setAlignmentX(Component.CENTER_ALIGNMENT);
				componentes.put(contador, infoValor);
				contador++;
				
				JButton valor = capturarDadoComoBotao((etapas.getValorParteEtapa(etapaAtual, parteAtual)
						.toString() + "R$"));
				valor.setAlignmentX(Component.CENTER_ALIGNMENT);
				componentes.put(contador, valor);
				contador++;
				
				contadorDePartes++;
				
			}
			
			contadorDePartes = 1;
			contadorDeEtapas++;
			
			componentes.put(contador, Box.createVerticalStrut(25));
			contador++;
			
		}
		

	}
	
	private void inserirMateriaisComponentes() {
		//TODO
	}
	
	private void inserirEmpecilhosComponentes() {
		//TODO
	}

	private void verificarSeTituloExiste(String titulo) {

		JLabel label = new JLabel();
		label.setText(titulo);

		boolean seExisteTitulo = false;
		
		for(Component componente : componentes.values()) {
			
			if (componente instanceof JLabel) {

				if (((JLabel) componente).getText().equals(label.getText())) {

					seExisteTitulo = true;

				}

			}
			
		}

		if (!seExisteTitulo && !etapas.getEtapas().isEmpty()) {
			adicionarTitulo(titulo);
		}

	}

	private void adicionarTitulo(String titulo) {

		JLabel item = obtemLabelFormatada(titulo, 30);
		componentes.put(0, item);
		painelDeDados.add(componentes.get(0));
		painelDeDados.add(Box.createVerticalStrut(30));

	}

	private JButton capturarDadoComoBotao(String dado) {

		JButton botao = new JButton();
		botao.setFont(new Font("Arial", Font.PLAIN, 17));
		botao.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao.setText(dado);

		//LogicaPainel menu = new LogicaPainel(painelDeDados);

		botao.addActionListener(e -> mostrarMenu(botao));

		return botao;

	}
	
	private void mostrarMenu(JButton botao) {

		MenuDeAcoes menu = new MenuDeAcoes(painelDeDados, botao);
		menu.getJFrame().setVisible(true);
	
	}

}
