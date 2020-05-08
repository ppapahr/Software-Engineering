package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy {
	
	public TemplateEncoding() {
		
	}
	
	public String encode(String s) {
		char[] charArray = s.toCharArray();
		for(int i=0; i<charArray.length; i++) {
			charArray[i] = this.mapCharacter(charArray[i]);
		}
		String encodedS = new String(charArray);
		return encodedS;
	}
	
	public abstract char mapCharacter(char c);
	
}
