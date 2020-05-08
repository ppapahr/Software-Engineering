package text2speechapis;

public class FakeTextToSpeechAPI implements TextToSpeechAPI{
	 
	private int volume;
	private int rate;
	private int pitch;
	
	public FakeTextToSpeechAPI(){

	}
	
	@Override
	public void play(String text) {
		System.out.println(text);
	}
	
	//setters
	@Override
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@Override
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Override
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
}
