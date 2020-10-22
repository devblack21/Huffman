import java.util.Map;

public class Node implements Comparable<Node> {

	private char symbol;
	private int count;
	
	private Node left;
	private Node right;
	
	
	public Node(char symbol) {
		this.symbol = symbol;
	}
	
	public Node(Node leftNode , Node rightNode) {
		this.symbol = '+';
		this.left = leftNode;
		this.right = rightNode;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public int getFrequency() {
		if(isLeaf()) {
			return count;
		}
		return left.getFrequency() + right.getFrequency();
	}
	
	public void add() {
		this.count++;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node arg0) {
		return getFrequency() - arg0.getFrequency();
	}
	
	public void fillCodeMap(Map<Character, String> codeMap, String work) {
		
		if(isLeaf()) {
			codeMap.put(getSymbol(), work);
			return;
		}
		
		left.fillCodeMap(codeMap, work + "0");
		right.fillCodeMap(codeMap, work + "1");
	}
	
	@Override
	public String toString() {
		String ch = symbol == '\n' ? "\\n" : "" + symbol;
		
		return String.format("'%s' : %d",ch,getFrequency());
	}

}
