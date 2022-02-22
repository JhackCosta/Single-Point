import java.util.Random;
import java.util.Scanner;

/*Desenvolver um programa que gere um código aleatório onde receba como parâmetro de entrada
	a quantidade de dígitos que o código deverá ter. */

public class Atividade1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//// Prevendo alguns erros de digitação
		try {

			System.out.print("Digite a quantidade de códigos: ");
			int qnt = scanner.nextInt();

			// Verificando se o valor digitador no console está entre 5 e 7
			if (qnt >= 5 && qnt <= 7) {
				gerador(qnt);
			} else {
				System.err.println("Número inválido!");
			}

		} catch (Exception e) {
			System.err.println("Erro! por favor reinicie o programa, e verifique as informações preenchidas");
		}
		scanner.close();

	}

	public static int[] gerador(int qnt) {

		// Usando o metodod Random para gerar os numeros aleatorios
		Random gerador = new Random();

		// Criando um arrey para quardar os valores
		int[] codigo = new int[qnt];

		boolean iguais = false;

		// Gerando os numeros aleatorios e quardando no arrey
		for (int i = 0; i < codigo.length; i++) {
			int valor = gerador.nextInt(10);
			codigo[i] = valor;
		}

		// Verificar numeros repetidos
		for (int i = 0; i < codigo.length; i++) {
			for (int j = 0; j < codigo.length; j++) {
				if (i != j) {
					if (codigo[i] == codigo[j]) {
						iguais = true;
					}
				}
			}
		}
		// Se os valores forem iguais ele ira chamar a função novamente e gerar dnv
		// fazendo uma recursão
		if (iguais) {
			return gerador(qnt);
		} else {
			for (int i = 0; i < codigo.length; i++) {
				System.out.print(codigo[i]);
			}
			return codigo;
		}
	}
}

