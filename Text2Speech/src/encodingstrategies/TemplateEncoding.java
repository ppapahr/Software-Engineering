package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy {
	
	public TemplateEncoding() {
		
	}
	
	public String encode(String s) {
		return null;
	}
	
	public abstract char mapCharacter(char c);
	
}
