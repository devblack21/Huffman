
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Huffman {
	
	private Node root;
	private TableCod tableCod = new TableCod();
	
	private char[] getChars(String text) {
		char[] letters = new char[text.length()];
		text.getChars(0, text.length(), letters, 0);
		return letters;
	}
	
	private PriorityQueue<Node> countFrequencies(char[] letters){
		Map<Character, Node> countMap = new HashMap<>();
		for(char ch : letters) {
			if(!countMap.containsKey(ch)) {
				countMap.put(ch, new Node(ch));
			}
			countMap.get(ch).add();
		}
		return new PriorityQueue<>(countMap.values());
	}
	
	private Node createNodeTree(PriorityQueue<Node> nodes) {
		
		while(true) {
			
			Node node1 = nodes.poll();
			Node node2 = nodes.poll();
			
			Node parent = new Node(node1, node2);
			
			if (nodes.isEmpty()) {
				return parent;
			}
			
			nodes.add(parent);
		}
	}
	
	private Map<Character, String> createCodeMap(){
		Map<Character, String> resultMap = new TreeMap<>();
		root.fillCodeMap(resultMap, "");
		return resultMap;
	}
	
	
	public String encode(String text) {
		
		char[] letters = getChars(text);
		root = createNodeTree(countFrequencies(letters));
		Map<Character, String> codeMap = createCodeMap();
		
		StringBuilder dataBuilder = new StringBuilder();
		
		for(char ch: letters) {
			dataBuilder.append("#"+codeMap.get(ch));
			tableCod.add(ch,codeMap.get(ch));
		}
		
		return dataBuilder.toString();
	}
	
	public String table() {
		return this.tableCod.elemenstToString();
	}
	
	private String[] replaces(String data,char replace) {
		String[] arrayList ;
		StringBuilder valor = new StringBuilder();
		arrayList = data.substring(1, data.length()).split(Pattern.quote("#"));
	
		return arrayList;
	}
	
	public String decode(String data) {
		
		String[] texto_table = data.split("²");
	
	      
	   
		tableCod.tranform(texto_table[1]);
		StringBuilder result = new StringBuilder();
        for (String ch : replaces(texto_table[0], '#')) {
            
            result.append(tableCod.returnChar(ch));
        }
 
        return result.toString();
    }

}