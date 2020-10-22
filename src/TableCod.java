
import java.util.HashSet;
import java.util.Set;

public class TableCod {

	private static Set<Element> elements = null;
	
	private class Element {
		
		private String symbomBit;
		private String cod;
		
		public String getSymbomBit() {
			return symbomBit;
		}
		public void setSymbomBit(String symbomBit) {
			this.symbomBit = symbomBit;
		}
		public String getCod() {
			return cod;
		}
		public void setCod(String cod) {
			this.cod = cod;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((cod == null) ? 0 : cod.hashCode());
			result = prime * result + ((symbomBit == null) ? 0 : symbomBit.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Element other = (Element) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (cod == null) {
				if (other.cod != null)
					return false;
			} else if (!cod.equals(other.cod))
				return false;
			if (symbomBit == null) {
				if (other.symbomBit != null)
					return false;
			} else if (!symbomBit.equals(other.symbomBit))
				return false;
			return true;
		}
		private TableCod getEnclosingInstance() {
			return TableCod.this;
		}
			
	
	}
	
	public TableCod() {
		getInstance();
	}
	
	public void add(char ch, String cod) {
		getInstance();
		Element element = new Element();
		element.setSymbomBit(generatedBIT(ch));
		element.setCod(cod);
		elements.add(element);
	}
	
	public String elemenstToString() {
		
		StringBuilder sBuilder =  new StringBuilder();
		sBuilder.append("{");
		for (Element element : elements) {
			sBuilder.append("[");
			sBuilder.append(element.getCod());
			sBuilder.append(" : ");
			sBuilder.append(element.getSymbomBit());
			sBuilder.append("]");
		}
		sBuilder.append("}");
		return sBuilder.toString();
	}
	
	public Set<Element> getInstance() {
		
		if (elements == null) {
			elements = new HashSet<TableCod.Element>();
		}
		return elements;
	}
	
	public Character returnChar(String cod) {
		Character retorno = null;
		for (Element element : elements ) {
			
			if(element.getCod().equals(cod)) {
			
				retorno = convertCHAR(element.getSymbomBit());
			}
			
		}
		return retorno;
	}
	
	
	private String generatedBIT(char ch) {
		
		String valorString = null;
		valorString = String.valueOf((int) ch);
		
		return valorString;
		
	}
	
	private Character convertCHAR(String bit) {

		int valor = Integer.parseInt(bit);
		return (char) valor;
		
	}

	public void tranform(String string) {
		
		
		
		elements = new HashSet<TableCod.Element>();
		string = string.replace("{", "");
		string = string.replace("}", "");
		string = string.replace("[", "");
		
	
		
		String string2[] = string.split("]");
		
		
		for (String s : string2) {
			s = s.replace("]", "");
			Element element = new Element();
			String atribsString[] = s.split(":");
			for (int i = 0; i < atribsString.length; i++) {
			
				if (i == 0) {
					element.setCod(atribsString[i].trim());
					
				}else {
					element.setSymbomBit(atribsString[i].trim());
					
				}				
			}
			elements.add(element);
			
		}
		
	}
}