package text2speechapis;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

//ALL FREETTS COPYRIGHTS BELONG TO THEIR RESPECTIVE OWNERS
//freetts.sourceforge.io

public class FreeTTSAdapter implements TextToSpeechAPI{
	
	private Voice voice;
	private VoiceManager vm;
	
	public FreeTTSAdapter() {
		//set a voice and initialize it
		this.voice = VoiceManager.getInstance().getVoice("kevin16");
		this.voice.allocate();
	}

	@Override
	public void play(String text) {
		voice.speak(text);
	}

	@Override
	public void setVolume(int volume) {
		voice.setVolume(volume);
	}

	@Override
	public void setRate(int rate) {
		voice.setRate(rate);
	}

	@Override
	public void setPitch(int pitch) {
		voice.setPitch(pitch);
	}
}
