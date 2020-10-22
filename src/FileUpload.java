import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUpload {

	
	public static String read(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		StringBuilder sBuilder = new StringBuilder();
		while (true) {
			if (linha != null) {
				sBuilder.append(linha);	
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
		return sBuilder.toString();
	}

	public static void writer(String path,String txt) throws IOException {
		new File("arquivos").mkdir();
		System.out.println(path);
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("arquivos\\"+path));
		buffWrite.append(txt);
		buffWrite.close();
	}
	
}
