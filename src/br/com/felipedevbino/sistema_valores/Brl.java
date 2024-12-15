package br.com.felipedevbino.sistema_valores;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Brl {

	private StringBuilder valorMontado;
	private BigDecimal formatacaoDecimal;

	/**
	 * Inicializa variáveis importantes para o sistema, definindo o tipo de
	 * formatação para o BigDecimal Principal.
	 * 
	 * @param valor
	 */
	private void inicializarFormatacao(Double valor) {
		formatacaoDecimal = retornarFormatacaoDecimal(valor);
		valorMontado = new StringBuilder().append(formatacaoDecimal);
	}

	/**
	 * Método público principal da classe. Ele recebe até 3 parâmetros: o primeiro é
	 * uma variável booleana que define um limite absoluto. Se esse parâmetro for
	 * passado como verdadeiro, o limite será sempre definido pelo último caractere
	 * numérico do valor Double passado ao método, resultando em um arredondamento
	 * sem exceções. Caso seja passado como falso, o método poderá analisar o limite
	 * definido pelo usuário.
	 * 
	 * @param limiteAbsoluto
	 * @param limiteParaArredondar
	 * @param valor
	 * @return
	 */
	public BigDecimal formatar(boolean limiteIndependente, int limiteParaArredondar, Double valor) {
		inicializarFormatacao(valor);

		if (limiteIndependente) {
			valor = arredondar(valor);
		} else {
			valor = arredondar(limiteParaArredondar, valor);
		}
		return retornarFormatacaoDecimal(valor);
	}

	/**
	 * O método arredondar absoluto, este, captura o último caracter do valor Double
	 * e o verifica, sempre arredondando o valor com base nele.
	 * 
	 * @param valor
	 * @return
	 */
	private Double arredondar(Double valor) {
		int valorUltimoCaracter = definirValorUltimoCaracter();
		Double decimalArredondado = definirDecimalArredondado(valorUltimoCaracter);

		return valor += 0.10 - decimalArredondado;
	}

	/**
	 * O método arredondar de forma variável permite que o limite para
	 * arredondamento seja personalizável. O usuário poderá escolher o limite em que
	 * os centavos excedentes podem chegar até o máximo de 9, sem serem
	 * automaticamente arredondados.
	 * 
	 * @param limiteParaArredondar
	 * @param valor
	 * @return
	 */
	private Double arredondar(int limiteParaArredondar, Double valor) {
		if (limiteParaArredondar >= 10) {
			limiteParaArredondar = 9;
		}
		int valorUltimoCaracter = definirValorUltimoCaracter();
		if (valorUltimoCaracter >= limiteParaArredondar) {
			Double decimalArredondado = definirDecimalArredondado(valorUltimoCaracter);
			valor += 0.10 - decimalArredondado;
		}
		return valor;
	}

	private int definirValorUltimoCaracter() {
		String ultimoCaracter = String.valueOf(valorMontado.charAt(valorMontado.length() - 1));
		int valorUltimoCaracter = Integer.parseInt(ultimoCaracter);
		return valorUltimoCaracter;
	}

	private Double definirDecimalArredondado(int limiteParaArredondar) {
		StringBuilder valorJuntado = new StringBuilder().append("0.0").append(limiteParaArredondar);
		Double decimalArredondado = Double.parseDouble(valorJuntado.toString());
		return decimalArredondado;
	}

	private BigDecimal retornarFormatacaoDecimal(Double valor) {
		return new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
	}

}
