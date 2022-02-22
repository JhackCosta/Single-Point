import java.util.Scanner;

public class Atividade2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o texto: ");
		String text = scanner.nextLine();

		String menu = "\n1. Criptografar  " + "\n2. Descriptografar";

		// Prevendo alguns erros de digitação
		try {
			System.out.println(menu);
			System.out.print("\nDigite sua opção: ");
			int opcao = scanner.nextInt();

			if (opcao == 1 || opcao == 2) {

				switch (opcao) {
				case 1: {

					System.out.println("Digite o valor da chave: ");
					int adicionar = scanner.nextInt();

					System.out.print("Texto criptografado: " + criptografar(text, adicionar));
					break;
				}

				case 2: {
					System.out.println("Digite o valor da chave: ");
					int remover = scanner.nextInt();

					System.out.println("Texto descriptografado: " + descriptografar(text, remover));

					break;
				}

				}
			} else {
				System.err.println("opção inválida!");
			}
		} catch (Exception e) {
			System.err.println("Erro! por favor reinicie o programa, e verifique as informações preenchidas");
		}

		scanner.close();
	}

	public static String criptografar(String texto, int chave) {

		// Variavel que ira guardar o texto crifrado
		StringBuilder textoCriptografado = new StringBuilder();

		// Criptografa cada caracter por vez
		for (int i = 0; i < texto.length(); i++) {

			// Transforma o caracter em codigo ASCII e faz a criptografia
			int ascii = ((int) texto.codePointAt(i)) + chave;
			
			// Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
			while (ascii > 126)
				ascii -= 94;

			// Transforma codigo ASCII criptografado em caracter ao novo texto
			textoCriptografado.append((char) ascii);
		}

		// Por fim retorna a mensagem criptografada por completo
		return textoCriptografado.toString();
	}

	public static String descriptografar(String textoCifrado, int chave) {

		// Variavel que ira guardar o texto decifrado
		StringBuilder textoDescriptografado = new StringBuilder();

		// Descriptografa cada caracter por vez
		for (int i = 0; i < textoCifrado.length(); i++) {

			// Transforma o caracter em codigo ASCII e faz a descriptografia
			int ascii = ((int) textoCifrado.charAt(i)) - chave;
				
			
			// Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
			while (ascii < 32)
				ascii += 94;

			// Transforma codigo ASCII descriptografado em caracter ao novo texto
			textoDescriptografado.append((char) ascii);
		}

		// Por fim retorna a mensagem descriptografada por completo
		return textoDescriptografado.toString();
	}

}
