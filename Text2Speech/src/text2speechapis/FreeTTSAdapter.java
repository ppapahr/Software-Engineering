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

	//convert all ints from 0-100 range to float 0.0-1.0
	@Override
	public void setVolume(int volume) {
		float vol = (float)volume/(float)100;
		voice.setVolume(vol);
	}

	@Override
	public void setRate(int rate) {
		//set rate 1 to 1000
		voice.setRate(rate);
	}

	@Override
	public void setPitch(int pitch) {
		voice.setPitch(pitch);
	}
}
