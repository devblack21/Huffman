import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		System.out.println("--------------------------------------------------------");
		System.out.println("Huffman coding - Developed by DevBlack - Marcos Rocha");
		System.out.println("--------------------------------------------------------");
		System.out.println("-------------------------MENU---------------------------");
		System.out.println("COMPACTAR: compactar arquivo de texto.");
		System.out.println("DESCOMPACTAR: descompactar arquivo de texto.");
		System.out.println("--------------------------------------------------------");
		while (true) {
			System.out.println("INSIRA A OPÇÃO:");
			String text = in.nextLine().trim();


			if (text.equals("COMPACTAR")) {
				System.out.println("Digite o caminho do arquivo para compactar: ");
				String caminho = in.nextLine().trim();
				
				try {
					Huffman huff = new Huffman();
					String data = huff.encode(FileUpload.read(caminho));
					System.out.println(data);
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append(data).append("²").append(huff.table());
					File file = new File(caminho);
					FileUpload.writer(file.getName()+"comp", sBuilder.toString());

					int normalSize = text.length() * 8;
					int compressedSize = data.length();
					double rate = 100.0 - (compressedSize * 100.0 / normalSize);
					System.out.println("Tamanho Normal : " + normalSize);
					System.out.println("Tamanho Comprimido: " + compressedSize);
					System.out.printf("Comprimido é %.2f%% menor que o original. %n", rate);
					System.out.println();
					System.out.println("Valor comprimido:");
					
					//System.out.println(data);
					System.out.println();
					
				} catch (Exception e) {
					System.out.println("Não foi possivel compactar!");
				}
				
				
			}

			if (text.equals("DESCOMPACTAR")) {
				System.out.println("Digite o caminho do arquivo para descompactar: ");
				String caminho = in.nextLine().trim();
				try {
					
					Huffman huff = new Huffman();
					
					System.out.println();
					
					System.out.println("valor descomprimido:");
					System.out.println(huff.decode(FileUpload.read(caminho)));
					System.out.println();
					System.out.println();
					
				} catch (Exception e) {
					System.out.println("Não foi possivel compactar!\n verifique se selecionou o arquivo que foi descompactado por esse programa.");
				}
				
				
			}

			

		}
	}
}