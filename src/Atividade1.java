import java.util.Random;
import java.util.Scanner;

/*Desenvolver um programa que gere um c�digo aleat�rio onde receba como par�metro de entrada
	a quantidade de d�gitos que o c�digo dever� ter. */

public class Atividade1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//// Prevendo alguns erros de digita��o
		try {

			System.out.print("Digite a quantidade de c�digos: ");
			int qnt = scanner.nextInt();

			// Verificando se o valor digitador no console est� entre 5 e 7
			if (qnt >= 5 && qnt <= 7) {
				gerador(qnt);
			} else {
				System.err.println("N�mero inv�lido!");
			}

		} catch (Exception e) {
			System.err.println("Erro! por favor reinicie o programa, e verifique as informa��es preenchidas");
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
		// Se os valores forem iguais ele ira chamar a fun��o novamente e gerar dnv
		// fazendo uma recurs�o
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

